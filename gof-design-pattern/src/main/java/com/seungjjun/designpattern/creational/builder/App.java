package com.seungjjun.designpattern.creational.builder;

import java.time.LocalDate;

public class App {

	public static void main(String[] args) {
		TourPlanBuilder builder = new DefaultTourBuilder();
		TourPlan plan = builder.title("여행")
			.nightsAndDays(2, 3)
			.startDate(LocalDate.of(2020, 12, 9))
			.whereToStay("리조트")
			.addPlan(0, "체크인 후 짐 풀기")
			.addPlan(0, "저녁 식사")
			.getPlan();

		TourPlan longBeachTrip = builder.title("롱비치")
			.startDate(LocalDate.of(2021, 7, 30))
			.getPlan();

		TourDirector tourDirector = new TourDirector(new DefaultTourBuilder());
		TourPlan tourPlan = tourDirector.cancunTrip();
		TourPlan tourPlan2 = tourDirector.longBeachTrip();
	}
}
