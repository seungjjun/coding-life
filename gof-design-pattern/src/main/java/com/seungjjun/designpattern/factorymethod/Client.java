package com.seungjjun.designpattern.factorymethod;

public class Client {

	public static void main(String[] args) {
		Client client = new Client();
		client.print(new WhiteshipFactory(), "Whiteship", "seungjjun@gmail.com");
		client.print(new BlackshipFactory(), "Blackship", "seungjjun@gmail.com");
	}

	private void print(ShipFactory shipFactory, String name, String email) {
		System.out.println(shipFactory.orderShip(name, email));
	}
}
