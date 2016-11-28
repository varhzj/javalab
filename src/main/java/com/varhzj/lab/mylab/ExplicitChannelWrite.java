package com.varhzj.lab.mylab;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by varhzj on 11/10/16.
 */
public class ExplicitChannelWrite {

    public static void main(String[] args) {
        try (FileChannel fileChannel = FileChannel.open(Paths.get("test.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer buffer = ByteBuffer.allocate(26);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 26; j++) {
                    buffer.put((byte) ('a' + j));
                }
                buffer.rewind();
                fileChannel.write(buffer);
                buffer.rewind();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
