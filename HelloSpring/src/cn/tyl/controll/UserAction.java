package cn.tyl.controll;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserAction {

	@RequestMapping("/UserCenter.action")
	public String toCenter(){
		
		return "../WEB-INF/jsp/ok.jsp";
	}
	@RequestMapping("/login.action")
	public	String login(@RequestParam("username") String username,HttpServletRequest request ){
	 request.getSession().setAttribute("users",username );
	return "../WEB-INF/jsp/ok.jsp";
	}
	
}
