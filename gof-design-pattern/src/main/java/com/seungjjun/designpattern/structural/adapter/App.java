package com.seungjjun.designpattern.structural.adapter;

import com.seungjjun.designpattern.structural.adapter.security.LoginHandler;
import com.seungjjun.designpattern.structural.adapter.security.UserDetailsService;

public class App {

	public static void main(String[] args) {
		AccountService accountService = new AccountService();
		UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
		LoginHandler loginHandler = new LoginHandler(userDetailsService);
		String login = loginHandler.login("seungjjun", "seungjjun");
		System.out.println(login);
	}
}
