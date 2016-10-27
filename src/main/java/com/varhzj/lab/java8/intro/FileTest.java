package com.varhzj.lab.java8.intro;

import java.io.*;
import java.util.Arrays;
import java.util.function.Function;

/**
 * Created by varhzj on 10/27/16.
 */
public class FileTest {

    public static void main(String[] args) {
        String dir = System.getProperty("user.home");
        System.out.println("List hidden file before java8:");
        listHiddenFileNormalWay(dir);
        System.out.println("List hidden file using java8 feature:");
        File[] files = listHiddenFileLambdaWay(dir);
        // print first line of each hidden file
        Arrays.stream(files).filter(File::isFile)
                .forEach(file -> {
                    try {
                        System.out.println(processFile(file, BufferedReader::readLine));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
        System.out.println(Letter.writeLetter("labda test", transformationPipeline));
    }

    public static File[] listHiddenFileLambdaWay(String dir) {
        File[] files = new File(dir).listFiles(File::isHidden);
        Arrays.stream(files).forEach(System.out::println);
        return files;
    }

    public static File[] listHiddenFileNormalWay(String dir) {
        File[] files = new File(dir).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        printFiles(files);
        return files;
    }

    private static void printFiles(File[] files) {
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public static String processFile(File file, BufferReaderProcessor processor) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            return processor.process(bufferedReader);
        }
    }

}

interface BufferReaderProcessor {

    String process(BufferedReader reader) throws IOException;

}

class Letter {

    public static String addHeader(String text) {
        return "From Java, Ruby, Python: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

    public static String writeLetter(String text, Function<String, String> func) {
        return func.apply(text);
    }

}
