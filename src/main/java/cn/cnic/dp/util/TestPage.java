
package cn.cnic.dp.util;

public class TestPage {
	public static void main(String[] args) {
		
		int pageNo = 10;
		int lastPageNo = 15;
		
		int displayPage = 10;
		int from = 0;
		int to = lastPageNo-1;
		
		int count = 0;
		
		int pre = pageNo;
		int nex = pageNo;
		
		for(int y=1; y<=displayPage; y++) {
			pre = pageNo - y;
			nex = pageNo + y;
			if(pre>=0) {
				from = pre;
				count++;
				if(count==displayPage-1) {
					break;
				}
			}
			if(nex<=lastPageNo) {
				to = nex;
				count++;
				if(count==displayPage-1) {
					break;
				}
			}
			
		}
		System.out.println(from+"-->"+to);
		
	}
}
