package com.seungjjun.designpattern.behavioral.command;

public class Light {

	private boolean isOn;

	public void on() {
		System.out.println("light on");
		this.isOn = true;
	}

	public void off() {
		System.out.println("light off");
		this.isOn = false;
	}

	public boolean isOn() {
		return this.isOn;
	}
}
