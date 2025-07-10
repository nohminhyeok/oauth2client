package com.example.oauth2client.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        // 1. Spring Security에서 현재 로그인한 사용자 정보 꺼냄
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 2. 로그인한 사용자의 식별값(기본은 name, 직접 구현한 경우 provider에 따라 달라짐)
        String loginUsername = authentication.getName(); // 예: 카카오 로그인 id 등

        // 3. 권한(ROLE_XXX 등) 정보 가져오기
        Collection<? extends GrantedAuthority> roleList = authentication.getAuthorities();
        Iterator <? extends GrantedAuthority> iterator = roleList.iterator();
        GrantedAuthority gh = null;

        // 4. 권한이 하나만 있을 때 (보통 ROLE_USER, ROLE_KAKAO 등 하나만 씀)
        String loginRole = "";
        if((gh=iterator.next()) != null) {
            loginRole = gh.getAuthority(); // 예: ROLE_KAKAO
        }
        model.addAttribute("loginRole", loginRole);          // 템플릿에 넘김
        model.addAttribute("loginUsername", loginUsername);  // 템플릿에 넘김

        // 5. 소셜 로그인 프로필 이미지 추출
        String profileImage = null;
        // 인증 정보가 OAuth2User 타입일 때만 (소셜 로그인일 때만!)
        if (authentication.getPrincipal() instanceof OAuth2User oAuth2User) {
            Object providerObj = null;
            // attributes Map에 provider 키가 있으면 가져옴 (ex: kakao, naver)
            if (oAuth2User.getAttributes().containsKey("provider")) {
                providerObj = oAuth2User.getAttributes().get("provider");
            }
            String provider = providerObj != null ? providerObj.toString() : null;
            // provider가 "kakao"일 때만 카카오 방식대로 파싱 (네이버면 다르게 해야함)
            if ("kakao".equals(provider)) {
                Map<String, Object> kakaoAccount = (Map<String, Object>) oAuth2User.getAttributes().get("kakao_account");
                if (kakaoAccount != null) {
                    Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");
                    if (profile != null && profile.get("profile_image_url") != null) {
                        // profile_image_url 값이 있을 때만 이미지 경로 저장
                        profileImage = profile.get("profile_image_url").toString();
                    }
                }
            } 
            // ★ 네이버/구글 등 다른 provider는 else if 또는 분기로 따로 작성 필요 (여긴 카카오만 함)
        }
        model.addAttribute("profileImage", profileImage);    // 템플릿에 프로필 이미지 주소 전달

        // 6. 최종적으로 home.jsp(또는 home.html) 렌더링
        return "home";
    }
}
