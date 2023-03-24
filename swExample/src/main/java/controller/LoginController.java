package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.User;
import service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	//로그인 페이지
	@RequestMapping("/login")
	public String loginPage() {
		//return "/WEB-INF/view/Login";
		return "/WEB-INF/view/Login";
	}
	
	//회원가입 페이지
	@RequestMapping("/signup")
	public String signup() {
		return "/WEB-INF/view/Signup";
	}
	
	//회원가입
	@PostMapping("/signUpCheck")
	public String signUpCheck(@ModelAttribute("signupTest") User user) {
		int result=loginService.insertUser(user);
		System.out.println(result);
		return "redirect:/login";
	}
	
	//사용자가 입력한 아이디와 비밀번호를 받아 커맨드 객체로 생성
	//검증 필요?
	@PostMapping("/loginCheck")
	public ModelAndView loginCheck(@ModelAttribute("test") User user) {
		//System.out.println(user.getUserId());
		//System.out.println(user.getUserPw());
		
		
		ModelAndView mav=new ModelAndView();
		
		//사용자가 입력한 id,pw에 맞는 db정보가 있는지 확인(로그인 정보 확인)
		try {
			User result=loginService.selectUser(user);
			
			System.out.println(result.getUserId());
			System.out.println(result.getUserPw());
			mav.addObject("userInfo",result);
			mav.setViewName("/WEB-INF/view/main");
			
			return mav;
			
			//return "/WEB-INF/view/main";
			
			
		}catch(Exception e) {//아이디나 비밀번호가 달라 예외가 발생한 경우 다시 로그인 페이지로 리다이렉트(틀렸다는 메세지가 필요할 듯)
			//return "redirect:/login";
			mav.setViewName("redirect:/login");
			return mav;
		}
	}
}

