package com.varhzj.lab.concurrency.examples;

/**
 * Created by varhzj on 11/3/16.
 */
public class UnsafePublic {

    // 不安全发布
    public Holder holder;

    public void initialize() {
        holder = new Holder(42);
    }

    public static void main(String[] args) {
        UnsafePublic up = new UnsafePublic();
        new Thread(new Runnable() {
            @Override
            public void run() {
                up.holder.assertSanity();
                up.holder = new Holder(21);
            }
        }).start();
        // 匿名内部类中的外部对象必须为不可变或事实上不可变，下句将破坏事实上不可变（effectively immutable）
//        up = new UnsafePublic();
        up.initialize();
    }
}
