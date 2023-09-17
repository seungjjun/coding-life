package org.example.calculator.grade;

import java.util.List;

public class Courses {
    private final List<Course> courseList;
    public Courses(List<Course> courseList) {
        this.courseList = courseList;
    }

    public double multiplyCreditAndCourseGrade() {
        return courseList.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit() {
        return courseList.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
