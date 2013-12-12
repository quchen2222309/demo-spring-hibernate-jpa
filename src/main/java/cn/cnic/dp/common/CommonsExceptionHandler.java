package cn.cnic.dp.common;

import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import cn.cnic.dp.common.datetime.DateUtils;
import cn.cnic.dp.util.ExceptionUtils;


/**
 * spring MVC 通用异常处理
 * 
 * @see org.springframework.web.servlet.HandlerExceptionResolver
 * @author gzb
 * @version 1.1.0 , 2013-07-03
 */
public class CommonsExceptionHandler implements HandlerExceptionResolver {

	private static Logger _logger = LoggerFactory.getLogger(CommonsExceptionHandler.class);

	private String _errorPage;

	public void setErrorPage(String errorPage) {
		_errorPage = errorPage;
	}

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		String message = ex.getMessage();

		_logger.error(message, ex);

		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("location", "异常信息");
		model.put("date", DateUtils.getDateTimeString(new Date()));
		model.put("class", handler.getClass().getName());
		model.put("message", message);
		model.put("stackMessage", ExceptionUtils.exceptionToString(ex));

		// 应用程序扩展,可根据异常类型跳转至相应错误页面,默认页面 WEB-INF/views/error/500.jsp
		return new ModelAndView(StringUtils.isNotEmpty(_errorPage) ? _errorPage : "error/500", model);
	}
}
