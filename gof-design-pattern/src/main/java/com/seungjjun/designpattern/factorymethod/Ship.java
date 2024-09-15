package com.seungjjun.designpattern.factorymethod;

public class Ship {
	private String name;
	private String color;
	private String logo;

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public String getLogo() {
		return logo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Ship{" +
			"name='" + name + '\'' +
			", color='" + color + '\'' +
			", logo='" + logo + '\'' +
			'}';
	}
}
