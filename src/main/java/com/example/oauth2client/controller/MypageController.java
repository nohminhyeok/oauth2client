package com.example.oauth2client.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {
	@GetMapping("/myPage")
	public String myPage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// authentication(인증된 UserDetails DTO name)
		String loginUsername = authentication.getName();
		// authentication(인증된 UserDetails DTO role)
		Collection<? extends GrantedAuthority> roleList = authentication.getAuthorities();
		// 순서가 있는(foreach가능한) 컬렉션으로 변경
		Iterator <? extends GrantedAuthority> iterator = roleList.iterator(); // 이트레이트 패턴
		
		GrantedAuthority gh = null;
		/* 하나의 role만 설정된 상태이기에 반복문은 불필요
			while((gh=iterator.next()) != null) {
				String role = gh.getAuthority(); // 사용자의 role
			}
		*/
		
		String loginRole = "";
		if((gh=iterator.next()) != null) {
			loginRole = gh.getAuthority();
		}
		model.addAttribute("loginRole", loginRole);
		model.addAttribute("loginUsername", loginUsername);
		
		return "myPage";
	}
}
