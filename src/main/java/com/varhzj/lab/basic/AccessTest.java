package com.varhzj.lab.basic;

public class AccessTest {

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.print();

        Sup sup = (Sup) sub;
        // 向上转型后依然调用子类重写的方法
        System.out.println(sup.get());

        Sup sup1 = new Sub();
        // 同样是调用重写方法
        System.out.println(sup1.get());

        Sub.sfTest();
    }
}

class Sup {
    private int i = 1;

    public static final void sfTest() {
        System.out.println(true);
    }

    protected int get() {
        return i;
    }
}

class Sub extends Sup {

    int i = 2;
// 父类定义static final方法，子类无法重写
//    public static void sfTest() {
//
//    }

    @Override
    protected int get() {
        return i;
    }

    public void print() {
        System.out.println(get());
    }
}
