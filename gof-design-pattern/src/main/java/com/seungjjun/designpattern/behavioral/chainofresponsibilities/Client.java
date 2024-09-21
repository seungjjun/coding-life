package com.seungjjun.designpattern.behavioral.chainofresponsibilities;

public class Client {

	private RequestHandler requestHandler;

	public Client(RequestHandler requestHandler) {
		this.requestHandler = requestHandler;
	}

	public void doWork() {
		Request request = new Request("인증/인가");
		requestHandler.handle(request);
	}

	public static void main(String[] args) {
		RequestHandler chain = new AuthRequestHandler(new LoggingRequestHandler(new PrintRequestHandler(null)));
		Client client = new Client(chain);
		client.doWork();
	}
}
