package cn.tyl.controll;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@org.springframework.stereotype.Controller
@RequestMapping("/user")
@SessionAttributes({"username"})
public class LoginActionZJ {
	@RequestMapping("/login.action")
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("psd") String psd){
		String mess="";
		ModelAndView moView = new ModelAndView("redirect:../index.jsp");
		if("admin".equals(username)&&"admin".equals(psd)){
			mess="登入成功";
		}else {
			mess="登入失败";
		}
		moView.addObject("msg", mess);
		return moView;
	}
	@RequestMapping(value="/log.action")
	@ResponseBody
	public Map Oklogin(@RequestBody UserVo userVo ,ModelMap mmMap){
		Map map = new HashMap();
		System.out.println(userVo.getUsername());
		System.out.println(userVo.getPsd());
		map.put("username", userVo.getUsername());
		map.put("psd", userVo.getPsd());
		return map;
	}
	
	//文件上传
	@RequestMapping(value="upload.action")
	public String upluad(HttpServletRequest request,@RequestParam("file") CommonsMultipartFile file){
		//获取本地服务器绝对路径
		String path=request.getServletContext().getRealPath("/upload/");
		//获取相对路径--测试
		String path1=request.getServletContext().getContextPath();
		System.out.println("我是realpath---"+path);
		System.out.println("我是contextpath---"+path1);
		//获取文件文
		String filename=file.getOriginalFilename();
		StringBuffer strname= new StringBuffer(filename);
		strname.insert(0, "\\");
		File myfile = new File(path+strname);
		try {
			file.getFileItem().write(myfile);
			return "../home.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "../index.jsp";
		}
	}
}
