package com.varhzj.lab.concurrency.examples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by varhzj on 16-11-3.
 */
public class Preloader {

    private final FutureTask<ProductInfo> futureTask = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws Exception {
            return loadProductInfo();
        }
    });
    private final Thread thread = new Thread(futureTask);

    public void start() {
        thread.start();
    }

    public ProductInfo getProductInfo() throws DataLoadException {
        try {
            return futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException) {
                throw (DataLoadException) cause;
            }
        }
        return null;
    }

    ProductInfo loadProductInfo() {
        return null;
    }

    interface ProductInfo {
    }
}

class DataLoadException extends Exception {
}
