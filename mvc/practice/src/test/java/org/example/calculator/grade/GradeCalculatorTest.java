package org.example.calculator.grade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GradeCalculatorTest {
    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courseList = List.of(new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+"));

        GradeCalculator gradeCalculator = new GradeCalculator(courseList);
        double gradeResult = gradeCalculator.calculate();

        assertThat(gradeResult).isEqualTo(4.5);
    }
}
