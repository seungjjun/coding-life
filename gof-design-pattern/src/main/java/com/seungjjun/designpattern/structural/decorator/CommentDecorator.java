package com.seungjjun.designpattern.structural.decorator;

public class CommentDecorator implements CommentService {

	private final CommentService commentService;

	public CommentDecorator(CommentService commentService) {
		this.commentService = commentService;
	}

	@Override
	public void addComment(String comment) {
		commentService.addComment(comment);
	}
}
