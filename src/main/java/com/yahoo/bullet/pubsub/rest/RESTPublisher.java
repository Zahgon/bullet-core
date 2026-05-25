/*
 *  Copyright 2018, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.pubsub.rest;

import com.yahoo.bullet.pubsub.PubSubMessage;
import com.yahoo.bullet.pubsub.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Slf4j
public abstract class RESTPublisher implements Publisher {

    public static final String APPLICATION_JSON = "application/json";

    public static final String CONTENT_TYPE = "content-type";

    private int connectTimeout;

    private CloseableHttpClient client;

    /**
     * Create a RESTQueryPublisher from a {@link CloseableHttpClient}.
     *
     * @param client The client.
     * @param connectTimeout The minimum time (ms) to wait for a connection to be made.
     */
    public RESTPublisher(CloseableHttpClient client, int connectTimeout) {
        this.client = client;
        this.connectTimeout = connectTimeout;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Send the {@link PubSubMessage} to the given url.
     *
     * @param url The url to which to send the message.
     * @param message The message to send.
     */
    protected void sendToURL(String url, PubSubMessage message) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private HttpPost makeHttpPost(String url, PubSubMessage message) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(message.asJSON()));
        httpPost.setHeader(CONTENT_TYPE, APPLICATION_JSON);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout).setSocketTimeout(connectTimeout).build();
        httpPost.setConfig(requestConfig);
        return httpPost;
    }
}
