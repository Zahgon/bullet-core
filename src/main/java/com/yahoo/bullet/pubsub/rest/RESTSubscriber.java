/*
 *  Copyright 2018, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.pubsub.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.yahoo.bullet.pubsub.BufferingSubscriber;
import com.yahoo.bullet.pubsub.Metadata;
import com.yahoo.bullet.pubsub.PubSubMessage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RESTSubscriber extends BufferingSubscriber {

    private static final JsonDeserializer<Metadata> METADATA_DESERIALIZER = (item, type, context) -> context.deserialize(item, RESTMetadata.class);

    private static final Gson GSON = new GsonBuilder().registerTypeAdapter(Metadata.class, METADATA_DESERIALIZER).create();

    @Getter(AccessLevel.PACKAGE)
    private List<String> urls;

    private CloseableHttpClient client;

    private long minWait;

    @Setter(AccessLevel.PACKAGE)
    private long lastRequest;

    private int connectTimeout;

    /**
     * Create a RESTSubscriber.
     *
     * @param maxUncommittedMessages The maximum number of records that will be buffered before commit() must be called.
     * @param urls The URLs which will be used to make the http request.
     * @param client The client to use to make http requests.
     * @param minWait The minimum time (ms) to wait between subsequent http requests.
     * @param connectTimeout The minimum time (ms) to wait for a connection to be made.
     */
    public RESTSubscriber(int maxUncommittedMessages, List<String> urls, CloseableHttpClient client, long minWait, int connectTimeout) {
        super(maxUncommittedMessages);
        this.client = client;
        this.urls = urls;
        this.minWait = minWait;
        this.lastRequest = 0;
        this.connectTimeout = connectTimeout;
    }

    @Override
    public List<PubSubMessage> getMessages() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private HttpGet makeHttpGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout).setSocketTimeout(connectTimeout).build();
        httpGet.setConfig(requestConfig);
        return httpGet;
    }
}
