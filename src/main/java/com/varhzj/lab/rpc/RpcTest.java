package com.varhzj.lab.rpc;

/**
 * Created by varhzj on 2/7/17.
 */
public class RpcTest {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 8080);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<>();
        EchoService echo = importer.importer(EchoServiceImpl.class, "localhost", 8080);
        System.out.println(echo.echo("Are you ok ?"));

        EchoService echoBack = importer.importer(EchoServiceImpl2.class, "localhost", 8080);
        System.out.println(echoBack.echo("ping"));
    }

}
