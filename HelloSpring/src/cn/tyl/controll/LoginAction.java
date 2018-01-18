package cn.tyl.controll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginAction implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String psd = request.getParameter("psd");
		String mess="";
		ModelAndView moView = new ModelAndView("index.jsp");
		if("admin".equals(username)&&"admin".equals(psd)){
			mess="登入成功";
		}else {
			mess="登入失败";
		}
		moView.addObject("msg", mess);
		return moView;
	}
	
}
