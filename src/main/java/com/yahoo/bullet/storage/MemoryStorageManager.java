/*
 *  Copyright 2019, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.storage;

import com.yahoo.bullet.common.BulletConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * A Storage manager that stores everything in-memory and does not support namespaces or partitions.
 */
public class MemoryStorageManager<V extends Serializable> extends StorageManager<V> implements Serializable {

    private static final long serialVersionUID = 3815534537510449363L;

    private Map<String, byte[]> storage;

    /**
     * Constructor.
     *
     * @param config The {@link BulletConfig} to create this manager with.
     */
    public MemoryStorageManager(BulletConfig config) {
        super(config);
        storage = new HashMap<>();
    }

    @Override
    protected CompletableFuture<Boolean> putRaw(String namespace, String id, byte[] value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CompletableFuture<byte[]> getRaw(String namespace, String id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CompletableFuture<Map<String, byte[]>> getAllRaw(String namespace) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CompletableFuture<byte[]> removeRaw(String namespace, String id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<Boolean> wipe() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<Boolean> clear(String namespace) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<Boolean> clear(String namespace, Set<String> ids) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
