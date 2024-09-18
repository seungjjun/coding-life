package com.seungjjun.designpattern.structural.adapter.security;

public interface UserDetailsService {

	UserDetails loadUser(String username);

}
