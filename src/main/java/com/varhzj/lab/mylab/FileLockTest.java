package com.varhzj.lab.mylab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by varhzj on 12/21/16.
 */
public class FileLockTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile file = new RandomAccessFile("/Users/varhzj/WorkSpace/Learn/javalab/src/main/resources/test.txt", "rwd");
        FileChannel channel = file.getChannel();
        FileLock lock = null;
        try {
            lock = channel.lock();
            for (int i = 0; i < 1000; i++) {
                ByteBuffer buffer = ByteBuffer.wrap("test\n".getBytes());
                channel.write(buffer);
                Thread.sleep(1000);
            }
        } finally {
            if (lock != null)
                lock.release();
            if (channel != null)
                channel.close();
        }

    }
}
