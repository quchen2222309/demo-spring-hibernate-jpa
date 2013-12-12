package cn.cnic.dp.util;

import javax.servlet.jsp.JspException;


import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class MyPagerBar extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PageUtil<?> page;
	
	private String url;

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = this.pageContext.getOut();
			if (page == null) {
				out.println("没有分页信息");
				return SKIP_BODY;
			}
			out.print("<span style=\"margin-top:30px;float:left;margin-right:30px\">第" + (page.getPageNo()) + "页&nbsp;共" + page.getLastPageNo() + "页</span>");
			out.print("<ul class=\"pagination\">");
			if(page.getIsHasPreviousPage()==1) {
				out.print("<li><a href=\"" + makeUpUrl(url, page.getPageNo()-1, page.getPageSize()) + "\">上一页</a></li>");
			} else {
				out.print("<li class=\"disabled\"><a>上一页</a></li>");
			}
			
			int displayPage = PropertyUtil.getInstance().getIntegerPropertyValue(StaticUtil.DISPLAY_NAME);
			
			int from = 1;
			int to = page.getLastPageNo();
			
			int count = 0;
			
			int pre = page.getPageNo();
			int nex = page.getPageNo();
			
			for(int y=1; y<=displayPage; y++) {
				pre = page.getPageNo() - y;
				nex = page.getPageNo() + y;
				if(pre>=1) {
					from = pre;
					count++;
					if(count==displayPage-1) {
						break;
					}
				}
				if(nex<=page.getLastPageNo()) {
					to = nex;
					count++;
					if(count==displayPage-1) {
						break;
					}
				}
				
			}
			System.out.println(from+"-->"+to);
			
			for(int x = from ; x<=to; x++) {
				if(x==page.getPageNo()) {
					out.print("<li class=\"active\"><a href=\""+ makeUpUrl(url, page.getPageNo(), page.getPageNo()) +"\">"+ x +"<span class=\"sr-only\">(current)</span></a></li>");
				} else {
					out.print("<li><a href=\""+ makeUpUrl(url, x, page.getPageSize()) +"\">"+ x +"<span class=\"sr-only\">(current)</span></a></li>");
				}
			}
			if(page.getIsHasNextPage()==1){
				out.print("<li><a href=\"" + makeUpUrl(url, page.getPageNo()+1, page.getPageSize()) + "\">下一页</a></li>");
			} else {
				out.print("<li class=\"disabled\"><span>下一页</span></li>");
			}
			out.print("</ul>");
		} catch (Exception e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	private String makeUpUrl(String url, int pageNo, int pageSize) {
		if(url.indexOf("pageNo")!=-1) {
			url = url.substring(0, url.indexOf("&pageNo"));
		} else {
			url = url + "?1=1";
		}
		String paramUrl = url+"&pageNo="+pageNo+"&pageSize="+pageSize;
		return paramUrl;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public void release() {
		super.release();
		this.page = null;
	}

	public PageUtil<?> getPage() {
		return page;
	}

	public void setPage(PageUtil<?> page) {
		this.page = page;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
