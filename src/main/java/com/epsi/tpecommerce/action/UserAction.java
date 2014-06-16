package com.epsi.tpecommerce.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epsi.tpecommerce.entity.User;
import com.epsi.tpecommerce.service.UserService;

public class UserAction {

	private UserService userService;

	public UserAction() {
		super();
		userService = new UserService();
	}
	
	public String loginUser(HttpServletRequest request, HttpServletResponse response) {
		User user = userService.userCanLogin(request.getAttribute("login").toString(), request.getAttribute("password").toString());
		if(user != null) {
			request.getSession().setAttribute("user", user);
			return "admin.jsp";
		}else {
			request.setAttribute("error", "Mot de passe trop court");
			return "login.jsp";
		}
		
	}
}
