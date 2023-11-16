package com.example.security;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Privacy {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, String> termMap = new HashMap<>();

        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], split[1]);
        }

        LocalDate todayDate = LocalDate.parse(convertLocalDate(today));

        for (int i = 0; i < privacies.length; i += 1) {
            String[] privacy = privacies[i].split(" ");

            String localDate = convertLocalDate(privacy[0]);
            LocalDate date = LocalDate.parse(localDate);

            String term = privacy[1];
            LocalDate plusMonthDate = plusDate(Long.parseLong(termMap.get(term)), date);

            if (plusMonthDate.isBefore(todayDate)) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i += 1) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public String convertLocalDate(String date) {
        return date.replace(".", "-");
    }

    public LocalDate plusDate(long month, LocalDate date) {
        return date.plusMonths(month).minusDays(1);
    }
}
