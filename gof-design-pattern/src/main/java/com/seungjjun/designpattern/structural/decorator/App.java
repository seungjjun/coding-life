package com.seungjjun.designpattern.structural.decorator;

public class App {

	private static boolean enabledSpamFilter = true;

	private static boolean enabledTrimming = true;

	public static void main(String[] args) {
		CommentService commentService = new DefaultCommentService();

		if (enabledSpamFilter) {
			commentService = new SpamFilteringCommentDecorator(commentService);
		}

		if (enabledTrimming) {
			commentService = new TrimmingCommentDecorator(commentService);
		}

		Client client = new Client(commentService);
		client.writeComment("design patter");
		client.writeComment("study...");
		client.writeComment("http://seungjjun.com");
	}
}
