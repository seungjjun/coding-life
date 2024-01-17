package com.study.springadvanced.trace.strategy.code.template;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TimeLogTemplate {
    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();

        callback.call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
