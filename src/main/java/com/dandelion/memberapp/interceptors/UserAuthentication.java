package com.dandelion.memberapp.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.dandelion.memberapp.model.po.User;

@Component
public class UserAuthentication {
	public UserAuthentication() {
	}

	public void authorize(User user) {
		RequestContextHolder.currentRequestAttributes().setAttribute("user", user, RequestAttributes.SCOPE_SESSION);
	}

	public User getCurrentUser() {
		User s =  (User) RequestContextHolder.currentRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_SESSION);
		return s;
	}
}
