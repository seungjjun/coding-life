package org.example.calculator.grade;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;
    public GradeCalculator(List<Course> courseList) {
        this.courses = new Courses(courseList);
    }

    public double calculate() {
        double multipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();
        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
