package com.varhzj.lab.concurrency;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe {

    static final Unsafe unsafe;

    static final long stateOffset;

    private final int state = 0;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error(e);
        }
    }

    public int getState() {
        return state;
    }

    public static void main(String[] args) {
        TestUnsafe testUnsafe = new TestUnsafe();
        boolean success = unsafe.compareAndSwapInt(testUnsafe, stateOffset, 0, 1);
        System.out.println(success);
        System.out.println(testUnsafe.getState());
    }


}
