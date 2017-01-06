package com.varhzj.lab.mylab;

/**
 * Created by varhzj on 17-1-6.
 */
public class ClassLoaderSimple {

    public static void main(String[] args) {
        /**
         * 对于静态字段，只有直接定义这个字段的类才会初始化，因此，
         * 通过子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化
         * 以下将输入：
         * Super loaded.
         * 1
         */
//        System.out.println(Sub.value);
        /**
         * 通过数组定义来引用类，不会触发此类的初始化
         */
        Super[] sca = new Super[10];
        Super[] subs = new Sub[10];
        System.out.println();
    }
}

class Super {
    static {
        System.out.println("Super loaded.");
    }

    public static int value = 1;
}

class Sub extends Super {
    static {
        System.out.println("Sub loaded.");
    }
}
