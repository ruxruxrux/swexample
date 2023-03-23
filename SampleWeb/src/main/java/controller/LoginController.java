package controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.UserDAO;
@Controller
public class LoginController {
	
	@Autowired
	UserDAO userDao;

	@GetMapping("/hello")
	public String hello(Model model,@RequestParam(value="name",required=false)String name) {
		model.addAttribute("greeting","hello,"+name);
		
		return "login";
	}
	
	
	//아이디와 패스워드 입력해서 로그인 버튼 눌렀을때
	//파라미터를 커맨드 객체로 받고, 검증해야함
	//뷰 페이지는 에러 메세지 표현과 재입력을 위해 스프링 폼을 사용
	//로그인 유지필요
	@GetMapping("/LoginCheck")
	public String test(Model model,@RequestParam(value="user_id",required=false)String userId,
			@RequestParam(value="user_pw",required=false)String userPw) {
		model.addAttribute("userId",userId);
		model.addAttribute("userPw",userPw);
		
		userDao.selectUser();
		
		return "logincheck";
	}
}
