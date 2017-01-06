package com.varhzj.lab.mylab;

/**
 * Created by varhzj on 17-1-6.
 * -XX:+TraceClassLoading
 * 类加载过程分析：
 * 1、加载：
 *      1）通过一个类的全限定名来获取定义此类的二进制字节流
 *      2）将这个字节流所代表的静态存储结构转换为方法区的运行时数据结构
 *      3）在内存中生成一个代表这个类的java.lang.Class对象，作为方法区这个类的各种数据的访问入口
 *      注：
 *          数组类本身不通过类加载器创建，而是由Java虚拟机直接创建的
 * 2、链接：
 *      2.1、验证：
 *          1）文件格式验证
 *          2）元数据验证
 *          3）字节码验证
 *          4）符号引用验证
 *      2.2、准备：
 *          为类变量分配内存并设置类变量初始值，这些变量所使用的内存都将在方法区中进行分配
 *          注：
 *              1）这时候进行内存分配的仅包括类变量（被static修饰的变量），而不包括实例变量，
 *              实例变量将会在对象实例化时随着对象一起分配在Java堆中
 *              2）初始值通常情况下是数据类型的零值，特殊情况：如果类字段的字段属性表存在ConstantValue（static final）属性，
 *              那在准备阶段变量value就会被初始化为ConstantValue属性所指定的值
 *      2.3、解析：
 *          将常量池中的符号引用（以一组符号来描述所引用的目标，符号可以是任何形式的字面量，只要使用时能无歧义的定位到目标即可）
 *          替换为直接引用（直接指向目标的指针、相对偏移量或是一个能间接定位到目标的句柄）的过程
 *          解析符号引用：
 *              1）类或接口符号引用：CONSTANT_Class_info
 *              2）字段：CONSTANT_Fieldref_info
 *              3）类方法：CONSTANT_Methodref_info
 *              4）接口方法：CONSTANT_InterfaceMethodref_info
 *              5）方法类型：CONSTANT_MethodType_info
 *              6）方法句柄：CONSTANT_MethodHandle_info
 *              7）调用点限定符：CONSTANT_InvokeDynamic_info
 * 3、初始化：
 *      1）在准备阶段，变量已经赋过一次系统要求的初始值，而在初始化阶段，则根据程序制定的主观计划去初始化类变量和其他资源，
 *      或者说是执行类构造器<clinit>()方法的过程。
 *      2）<clinit>()方法是由编译器自动收集类中所有类变量的赋值动作和静态语句块中的语句合并产生的，
 *      编译器收集的顺序是由语句在源文件中出现的顺序所决定。
 *      静态语句块只能访问到定义在静态语句块之前的变量，定义在之后的变量，在静态语句块中可以赋值，但是不能访问（参考StaticBlockClass）
 *      3）<clinit>()方法与类的构造函数（或者说实例构造器<init>()方法）不同，不需要显式地调用父类构造器，虚拟机回保证子类的<clinit>()方法
 *      执行之前，父类的<clinit>()方法已经执行完毕
 *      4）<clinit>()方法对于类或者接口来说并不是必须的，如果一个类没有静态语句块也没有对变量的赋值操作，那么编译器可以不生成此方法
 *      5）接口中不能使用静态语句块，但仍有变量初始化的赋值操作，因此接口和类一样都会生成<clinit>()方法。但执行接口的<clinit>()方法不需要先
 *      执行父接口的<clinit>()方法，只有当使用父接口定义的变量时，父接口才会初始化
 *      6）虚拟机会保证一个类的<clinit>()方法在多线程环境下被正确的加锁、同步，如果多个线程同时去初始化一个类，那么只会有执行这个类的<clinit>()方法，
 *      其他线程需要阻塞等待
 */
public class ClassLoaderSimple {

    public static void main(String[] args) {
        constantClassValue();
        array();
        supClassStaticValue();
        staticBlockOrder();
    }

    /**
     * 通过数组定义来引用类，触发类加载，不会触发此类的初始化
     */
    static void array() {
        Super[] sca = new Super[10];
        Super[] subs = new Sub[10];
        System.out.println();
    }

    /**
     * 对于静态字段，只有直接定义这个字段的类才会初始化，因此，
     * 通过子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化
     * 以下将输出：
     * Super loaded.
     * valueBefore: 0
     * 1
     */
    static void supClassStaticValue() {
        System.out.println(Sub.value);
    }

    /**
     * 引用类的静态常量将不会触发类的初始化
     * -XX:+TraceClassLoading，查看类加载中没有发现ConstantClass加载
     * 在编译阶段通过常量传播优化，已经将CONSTANT_VALUE的值"TEST_CONSTANT_VALUE"存储到ClassLoaderSimple类的常量池中
     * 以下将输出：
     * TEST_CONSTANT_VALUE
     */
    static void constantClassValue() {
        System.out.println(ConstantClass.CONSTANT_VALUE);
    }

    /**
     * 静态语句块只能访问到定义在静态语句块之前的变量，
     * 定义在之后的变量，在静态语句块中可以赋值，但是不能访问
     * 输出：
     * valueBefore: 11
     * 1
     */
    static void staticBlockOrder() {
        System.out.println(StaticBlockClass.valueAfter);
    }


}

class ConstantClass {

    public static final String CONSTANT_VALUE = "TEST_CONSTANT_VALUE";
}

class StaticBlockClass {
    public static int valueBefore = 11;

    static {
        valueBefore = 10;
        System.out.println("valueBefore: " + valueBefore);
        valueAfter = 10; // 将会被后续的value赋值覆盖，即value=1
        TEST = "test"; // 必须设置初始值
//        System.out.println("TEST: " + TEST); // illegal forward reference，对于final
//        System.out.println("valueAfter: " + valueAfter); // illegal forward reference
    }

    public static final String TEST;

    public static int valueAfter = 1;
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
