package com.seungjjun.item17;

// 상속을 불가능 하게 하도록 final class 선언
public final class PhoneNumber {

    // 필드값 수정 되는 것을 방지하기 위해 final으로 선언
    private final short areaCoe, prefix, lineNum;

    public PhoneNumber(short areaCoe, short prefix, short lineNum) {
        this.areaCoe = areaCoe;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    public short getAreaCoe() {
        return areaCoe;
    }

    public short getPrefix() {
        return prefix;
    }

    public short getLineNum() {
        return lineNum;
    }
}
