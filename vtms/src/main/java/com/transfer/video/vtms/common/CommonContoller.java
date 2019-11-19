package com.transfer.video.vtms.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonContoller {
	@Autowired
	private CommonService commonService;
	
	@GetMapping("/login")
	public ModelAndView login() {//로그인 폼
		return new ModelAndView("/common/login");
	}
	
	@PostMapping("/login")
	public ModelAndView login(Account account) {//로그인
		boolean result = this.commonService.isLogin(account);
		
		ModelAndView mav = new ModelAndView();
		if (result == true) {//비밀번호 일치 시
			mav = new ModelAndView("redirect:/device");
		} else {
			mav = new ModelAndView("/common/login");
			mav.addObject("revisit", "Y");
		}
		
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout() {//로그아웃
		this.commonService.logout();
		
		return new ModelAndView("redirect:/login");
	}
}
