package com.seungjjun.item16.method;

// 접근자와 변경자(mutator) 메서드를 활용해 데이터를 '캡슐화'한다.
public class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		// 부가 작업이 가능하다. (검증같은 부가 작업)
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
