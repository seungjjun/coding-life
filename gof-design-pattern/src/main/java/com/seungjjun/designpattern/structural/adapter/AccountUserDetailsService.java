package com.seungjjun.designpattern.structural.adapter;

import com.seungjjun.designpattern.structural.adapter.security.UserDetails;
import com.seungjjun.designpattern.structural.adapter.security.UserDetailsService;

public class AccountUserDetailsService implements UserDetailsService {

	private final AccountService accountService;

	public AccountUserDetailsService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public UserDetails loadUser(String username) {
		Account account = accountService.findAccountByUsername(username);
		return new AccountUserDetails(account);
	}
}
