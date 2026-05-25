/*
 *  Copyright 2018, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.pubsub.rest;

import com.yahoo.bullet.common.BulletConfig;
import com.yahoo.bullet.pubsub.PubSub;
import com.yahoo.bullet.pubsub.PubSubException;
import com.yahoo.bullet.pubsub.Publisher;
import com.yahoo.bullet.pubsub.Subscriber;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.HttpClients;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class RESTPubSub extends PubSub {

    public static final int OK_200 = 200;

    public static final int NO_CONTENT_204 = 204;

    public static final Charset UTF_8 = StandardCharsets.UTF_8;

    /**
     * Create a RESTPubSub from a {@link BulletConfig}.
     *
     * @param config The config.
     * @throws PubSubException if the context name is not present or cannot be parsed.
     */
    public RESTPubSub(BulletConfig config) throws PubSubException {
        super(config);
        this.config = new RESTPubSubConfig(config);
    }

    @Override
    public Publisher getPublisher() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Publisher> getPublishers(int n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Subscriber getSubscriber() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Subscriber> getSubscribers(int n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
