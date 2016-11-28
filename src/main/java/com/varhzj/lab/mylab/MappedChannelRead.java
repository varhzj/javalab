package com.varhzj.lab.mylab;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by varhzj on 11/10/16.
 */
public class MappedChannelRead {

    public static void main(String[] args) {
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("README.md"))) {
            long fileSize = fileChannel.size();
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);
            for (int i = 0; i < fileSize; i++) {
                System.out.print((char) mappedByteBuffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
