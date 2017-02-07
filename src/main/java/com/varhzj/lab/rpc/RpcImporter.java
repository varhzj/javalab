package com.varhzj.lab.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by varhzj on 2/7/17.
 */
public class RpcImporter<T> {

    public T importer(Class<?> serviceClass, String host, int port) {
        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(),
                serviceClass.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try (
                                Socket socket = new Socket(host, port);
                                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        ) {
                            output.writeUTF(serviceClass.getName());
                            output.writeUTF(method.getName());
                            output.writeObject(method.getParameterTypes());
                            output.writeObject(args);
                            return input.readObject();
                        }
                    }
                });
    }

}
