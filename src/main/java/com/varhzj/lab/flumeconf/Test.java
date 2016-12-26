package com.varhzj.lab.flumeconf;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by varhzj on 16-12-20.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("/home/huangzhijian/workspace/lab/javalab/src/main/resources/flume.conf.ftl"));
        RandomAccessFile rcFile = new RandomAccessFile("/home/huangzhijian/workspace/lab/javalab/src/main/resources/flume.conf", "rw");
        FileChannel channel = rcFile.getChannel();
        FileLock fileLock = channel.tryLock();
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            ByteBuffer buffer = ByteBuffer.wrap(((String)entry.getKey() + " = " + (String)entry.getValue() + "\n").getBytes());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            channel.write(buffer);
        }
        fileLock.release();
        channel.close();
    }

}
