package com.varhzj.lab.designpattern.creational.singleton;

import java.io.*;

/**
 * Created by varhzj on 16-10-16.
 */
public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -1;

    private SerializedSingleton() {}

    private static class SingletonHelper {
        private static final SerializedSingleton INSTANCE = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializedSingleton singleton1 = SerializedSingleton.getInstance();

        ObjectOutput output = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        output.writeObject(singleton1);
        output.flush();
        output.close();

        ObjectInput input = new ObjectInputStream(new FileInputStream("singleton.ser"));
        SerializedSingleton singleton2 = (SerializedSingleton) input.readObject();
        input.close();

        // without the readResolve method this would get false;
        System.out.println(singleton1 == singleton2);
    }

}
