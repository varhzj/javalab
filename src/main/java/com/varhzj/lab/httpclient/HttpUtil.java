package com.varhzj.lab.httpclient;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by varhzj on 7/4/17.
 */
public class HttpUtil {

    /*  ConnectionTimeout(ms)
     *  Client tries to connect to the server.
     *  This denotes the time elapsed before the connection established or Server responded to connection request.
     */
    public static final int DEFAULT_CONN_TIMEOUT = 3000;

    /*  SocketTimeout(ms)
     *  After establishing the connection, the client socket waits for response after sending the request.
     *  This is the elapsed time since the client has sent request to the server before server responds.
     *  In other words its maximum period inactivity between two consecutive data packets arriving at client side after connection is established
     */
    public static final int DEFAULT_SOCKET_TIMEOUT = 3000;

    public static String basicGetUtf(String url) throws Exception {
        return basicGetUtf(url, null, null, DEFAULT_CONN_TIMEOUT, DEFAULT_SOCKET_TIMEOUT);
    }

    public static String basicGetUtf(String url, Map<String, String> params) throws Exception {
        return basicGetUtf(url, params, null, DEFAULT_CONN_TIMEOUT, DEFAULT_SOCKET_TIMEOUT);
    }

    public static String basicGetUtf(
            String url,
            Map<String, String> params,
            Map<String, String> headers,
            int connectTimeout,
            int socketTimeout
    ) throws Exception {
        Form form = Form.form();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                form.add(entry.getKey(), entry.getValue());
            }
        }
        List<NameValuePair> nvParams = form.build();

        List<Header> headerList = new ArrayList<>();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                headerList.add(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }

        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameters(nvParams);
            URI uri = uriBuilder.build();
            String res = Request.Get(uri)
                    .connectTimeout(connectTimeout)
                    .socketTimeout(socketTimeout)
                    .setHeaders(headerList.toArray(new Header[0]))
                    .execute()
                    .returnContent()
                    .asString(Consts.UTF_8);
            return res;
        } catch (URISyntaxException | IOException e) {
            throw new Exception("Get " + url + " error, params: " + nvParams, e);
        }
    }


    public static String basicPostUtf(String url, Map<String, String> params) throws Exception {
        return basicPostUtf(url, params, null, DEFAULT_CONN_TIMEOUT, DEFAULT_SOCKET_TIMEOUT);
    }


    public static String basicPostUtf(
            String url,
            Map<String, String> params,
            Map<String, String> headers,
            int connectTimeout,
            int socketTimeout
    ) throws Exception {
        Form form = Form.form();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            form.add(entry.getKey(), entry.getValue());
        }
        List<NameValuePair> nvParams = form.build();

        List<Header> headerList = new ArrayList<>();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                headerList.add(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }

        try {
            String res = Request.Post(url)
                    .bodyForm(nvParams, Consts.UTF_8)
                    .connectTimeout(connectTimeout)
                    .socketTimeout(socketTimeout)
                    .setHeaders(headerList.toArray(new Header[0]))
                    .execute()
                    .returnContent()
                    .asString(Consts.UTF_8);
            return res;
        } catch (IOException e) {
            throw new Exception("Post " + url + " error, params: " + nvParams, e);
        }
    }

}
