package com.seungjjun.designpattern.structural.decorator;

public class Client {

	private final CommentService commentService;

	public Client(CommentService commentService) {
		this.commentService = commentService;
	}

	public void writeComment(String comment) {
		commentService.addComment(comment);
	}
}
