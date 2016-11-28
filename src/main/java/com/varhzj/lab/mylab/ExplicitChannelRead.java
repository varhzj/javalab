package com.varhzj.lab.mylab;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by varhzj on 11/10/16.
 */
public class ExplicitChannelRead {

    public static void main(String[] args) {
        int count;
        Path filePath = Paths.get("README.md");

        try (SeekableByteChannel fChan = Files.newByteChannel(filePath)) {
            ByteBuffer buffer = ByteBuffer.allocate(128);
            do {
                count = fChan.read(buffer);
                if (count != -1) {
                    buffer.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) buffer.get());
                    }
                }
            } while (count != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
