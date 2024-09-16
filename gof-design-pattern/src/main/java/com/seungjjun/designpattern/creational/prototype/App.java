package com.seungjjun.designpattern.creational.prototype;

public class App {

	public static void main(String[] args) throws CloneNotSupportedException {
		GithubRepository repository = new GithubRepository();
		repository.setUser("whiteship");
		repository.setName("live-study");

		GithubIssue githubIssue = new GithubIssue(repository);
		githubIssue.setId(1);
		githubIssue.setTitle("JVM");

		String url = githubIssue.getUrl();
		System.out.println(url);

		GithubIssue clone = (GithubIssue) githubIssue.clone();
		System.out.println(clone.getUrl());

		System.out.println(clone != githubIssue);
		System.out.println(clone.equals(githubIssue));
		System.out.println(clone.getClass() == githubIssue.getClass());
		System.out.println(clone.getRepository() == githubIssue.getRepository());
	}
}
