package com.varhzj.lab.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by varhzj on 2/7/17.
 * RPC服务端发布者
 */
public class RpcExporter {

    private static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String host, int port) throws Exception {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(host, port));
        try {
            while (true) {
                executor.execute(new ExporterTask(server.accept()));
            }
        } finally {
            server.close();
        }
    }

    private static class ExporterTask implements Runnable {

        private Socket client;

        public ExporterTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (
                    ObjectInputStream input = new ObjectInputStream(client.getInputStream());
                    ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
            ) {
                // 获取接口名称
                String interfaceName = input.readUTF();
                // 获取方法名称
                String methodName = input.readUTF();
                // 获取参数类型
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                // 获取参数
                Object[] argument = (Object[]) input.readObject();

                Class<?> service = Class.forName(interfaceName);
                Method method = service.getMethod(methodName, parameterTypes);
                Object result = method.invoke(service.newInstance(), argument);

                output.writeObject(result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (client != null) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
