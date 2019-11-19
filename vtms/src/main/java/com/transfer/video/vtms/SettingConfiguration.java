package com.transfer.video.vtms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SettingConfiguration implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/login")//로그인 폼
				.excludePathPatterns("/assets/css/*")//화면 그릴 때
				.excludePathPatterns("/device/agent");//디바이스 정보 자동 등록 할 때
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
