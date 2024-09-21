package com.seungjjun.designpattern.behavioral.chainofresponsibilities;

public class Request {

	private String body;

	public Request(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}
}
