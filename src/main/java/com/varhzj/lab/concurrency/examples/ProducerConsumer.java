package com.varhzj.lab.concurrency.examples;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by varhzj on 11/3/16.
 */
public class ProducerConsumer {

    static class FileCrawler implements Runnable {

        private final BlockingQueue<File> fileQueue;
        private final FileFilter filter;
        private final File root;

        public FileCrawler(BlockingQueue<File> fileQueue, FileFilter filter, File root) {
            this.fileQueue = fileQueue;
            this.filter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory() || filter.accept(pathname);
                }
            };
            this.root = root;
        }

        @Override
        public void run() {
            try {
                crawl(root);
            } catch (InterruptedException e) {
                // Restoring the interrupted status so as not to swallow the interruptRestoring the interrupted status
                // so as not to swallow the interrupt
                Thread.currentThread().interrupt();
            }
        }

        private void crawl(File root) throws InterruptedException {
            File[] entries = root.listFiles();
            for (File entry : entries) {
                if (entry.isDirectory()) {
                    crawl(entry);
                }
                else if (!alreadyIndexed(entry)) {
                    fileQueue.put(entry);
                }
            }
        }

        private boolean alreadyIndexed(File entry) {
            return false;
        }
    }

    static class Indexer implements Runnable {

        private final BlockingQueue<File> fileQueue;

        public Indexer(BlockingQueue<File> fileQueue) {
            this.fileQueue = fileQueue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    indexFile(fileQueue.take());
                }
            }
            catch (InterruptedException e) {
                // Restoring the interrupted status so as not to swallow the interruptRestoring the interrupted status
                // so as not to swallow the interrupt
                Thread.currentThread().interrupt();
            }
        }

        public void indexFile(File file) {
            // TODO: indexFile
            System.out.println(file.getAbsolutePath());
        }
    }

    public static final int BOUND = 10;
    public static final int N_CONSUMERS = Runtime.getRuntime().availableProcessors();

    public static void startIndexing(File[] roots) {
        BlockingQueue<File> fileQueue = new LinkedBlockingDeque<>(BOUND);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        };

        for (File root : roots) {
            new Thread(new FileCrawler(fileQueue, filter, root)).start();
        }

        for (int i = 0; i < N_CONSUMERS; i++) {
            new Thread(new Indexer(fileQueue)).start();
        }
    }

    public static void main(String[] args) {
        File[] roots = new File[] {new File(System.getProperty("user.dir")), new File(System.getProperty("user.home"))};
        startIndexing(roots);
    }

}
