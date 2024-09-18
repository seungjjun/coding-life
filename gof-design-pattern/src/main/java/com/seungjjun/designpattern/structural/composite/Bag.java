package com.seungjjun.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Bag implements Component {

	private List<Component> components = new ArrayList<>();

	public void add(Component component) {
		this.components.add(component);
	}

	public List<Component> getComponents() {
		return components;
	}

	@Override
	public int getPrice() {
		return components.stream().mapToInt(Component::getPrice).sum();
	}
}
