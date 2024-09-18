package com.seungjjun.designpattern.structural.composite;

public class Client {

	public static void main(String[] args) {
		Item blade = new Item("검", 450);
		Item potion = new Item("물약", 50);

		Bag bag = new Bag();
		bag.add(blade);
		bag.add(potion);

		Client client = new Client();
		client.printPrice(blade);
		client.printPrice(bag);
	}

	private void printPrice(Component component) {
		System.out.println(component.getPrice());
	}

}
