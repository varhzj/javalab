package com.varhzj.lab.basic;

public enum TestEnum {

    A(1), B(2);

    private int key;

    // 默认为private，不能为public,protected
    TestEnum(int key) {
        this.key = key;
    }
}
