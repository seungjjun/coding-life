package com.study.springadvanced.trace.callback;

public interface TraceCallback<T> {
    T call();
}
