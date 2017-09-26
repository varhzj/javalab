package com.varhzj.lab.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.FutureRequestExecutionService;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpRequestFutureTask;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by varhzj on 17-1-11.
 */
public class HttpClientSample {

    public static void main(String[] args) {
        HttpClient httpClient = HttpClientBuilder.create().setMaxConnPerRoute(10).build();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        FutureRequestExecutionService futureRequestExecutionService = new FutureRequestExecutionService(httpClient, executorService);
        HttpRequestFutureTask<Boolean> task = futureRequestExecutionService.execute(new HttpGet("https://www.baidu.com"), HttpClientContext.create(), new ResponseHandler<Boolean>() {
            @Override
            public Boolean handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                return httpResponse.getStatusLine().getStatusCode() == 200;
            }
        });
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    void fluentSample() {
//        Request.Get("https://www.baidu.com").execute()
        Executor.newInstance();
    }

}
