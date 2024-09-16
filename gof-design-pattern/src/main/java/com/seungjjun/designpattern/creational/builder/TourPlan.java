package com.seungjjun.designpattern.creational.builder;

import java.time.LocalDate;
import java.util.List;

public class TourPlan {

	private String title;

	private int nights;

	private int days;

	private LocalDate startDate;

	private String whereToStay;

	private List<DetailPlan> plans;

	public TourPlan() {
	}

	public TourPlan(String title, int nights, int days, LocalDate startDate, String whereToStay,
					List<DetailPlan> plans) {
		this.title = title;
		this.nights = nights;
		this.days = days;
		this.startDate = startDate;
		this.whereToStay = whereToStay;
		this.plans = plans;
	}

	@Override
	public String toString() {
		return "TourPlan{" +
			"title='" + title + '\'' +
			", nights=" + nights +
			", days=" + days +
			", startDate=" + startDate +
			", whereToStay='" + whereToStay + '\'' +
			", plans=" + plans +
			'}';
	}
}
