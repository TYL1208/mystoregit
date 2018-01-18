package cn.tyl.controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
/**
 * 后置拦截器
 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object object, ModelAndView arg3) throws Exception {
		Long end = System.currentTimeMillis();
		Long time = end-Long.valueOf(request.getSession().getAttribute("st").toString());
		System.out.println(object.getClass().getName()+"花了"+time);
	}

	/**
	 * 前置拦截器
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		Long start= System.currentTimeMillis();
		request.getSession().setAttribute("st", start);
		String username=(String) request.getSession().getAttribute("users");
		StringBuffer requestURL = request.getRequestURL();
		String substring = requestURL.substring(requestURL.length()-19);
		if("/users/login.action".equals(substring)){
			return true;
		}
		System.out.println(requestURL);
		if(username==null){
			request.getRequestDispatcher("../WEB-INF/jsp/login.jsp").forward(request, response);
		}
		return true;
	}

}
