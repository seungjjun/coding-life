package com.seungjjun.designpattern.structural.adapter;

import com.seungjjun.designpattern.structural.adapter.security.UserDetails;

public class AccountUserDetails implements UserDetails {

	private Account account;

	public AccountUserDetails(Account account) {
		this.account = account;
	}

	@Override
	public String getUsername() {
		return this.account.getName();
	}

	@Override
	public String getPassword() {
		return this.account.getPassword();
	}
}
