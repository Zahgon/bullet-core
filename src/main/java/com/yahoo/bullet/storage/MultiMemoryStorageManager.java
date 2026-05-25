/*
 *  Copyright 2020, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.storage;

import com.yahoo.bullet.common.BulletConfig;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

/**
 * A storage that stores everything in-memory and supports namespaces and partitions. It starts off with a fixed initial
 * number of partitions for all namespaces. You may use {@link #repartition(String, int)} to change it at runtime per
 * namespace.
 *
 * Supported criteria:
 * <ol>
 *     <li>{@link MultiMemoryCountingCriteria} that counts keys across namespaces</li>
 * </ol>
 */
@Slf4j
public class MultiMemoryStorageManager<V extends Serializable> extends StorageManager<V> implements Serializable {

    private static final long serialVersionUID = 9019357859078979031L;

    private Set<String> namespaces;

    private String defaultNamespace;

    private Map<String, Integer> partitions;

    @Getter(AccessLevel.PACKAGE)
    private Map<String, Map<Integer, Map<String, byte[]>>> storage;

    /**
     * Constructor.
     *
     * @param config The {@link BulletConfig} to create this manager with.
     */
    @SuppressWarnings("unchecked")
    public MultiMemoryStorageManager(BulletConfig config) {
        super(config);
        this.config = new StorageConfig(config);
        namespaces = (Set<String>) this.config.getAs(StorageConfig.NAMESPACES, Set.class);
        int defaultPartitions = this.config.getAs(StorageConfig.PARTITION_COUNT, Integer.class);
        partitions = new HashMap<>();
        namespaces.forEach(namespace -> partitions.put(namespace, defaultPartitions));
        // Pick the first one as the default
        defaultNamespace = namespaces.iterator().next();
        initializeStorage();
        log.info("Initialized storage with {} namepaces and {} partitions each", namespaces.size(), defaultPartitions);
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
    protected CompletableFuture<Map<String, byte[]>> getPartitionRaw(String namespace, int partition) {
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

    @Override
    public int numberOfPartitions(String namespace) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<Boolean> clear(String namespace, int partition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<Boolean> repartition(String namespace, int newPartitionCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected String getDefaultNamespace() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Map<Integer, Map<String, byte[]>> repartition(String namespace, Collection<Map<String, byte[]>> oldPartitions) {
        Map<Integer, Map<String, byte[]>> data = emptyPartitions(namespace);
        int count = partitions.get(namespace);
        for (Map<String, byte[]> partition : oldPartitions) {
            for (Map.Entry<String, byte[]> entry : partition.entrySet()) {
                String key = entry.getKey();
                data.get(hash(key, count)).put(key, entry.getValue());
            }
        }
        return data;
    }

    private int hash(String namespace, String key) {
        int numberOfPartitions = partitions.get(namespace);
        return hash(key, numberOfPartitions);
    }

    /**
     * Exposed for use by {@link Criteria}. Validates and throws if the given namespace is not a valid namespace.
     *
     * @param namespace The namespace to validate.
     * @throws IllegalArgumentException if the namespace is not a valid namespace.
     */
    void validateNamespace(String namespace) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void validatePartition(String namespace, int partition) {
        Integer count = partitions.get(namespace);
        if (partition >= count) {
            log.error("Partition {} is not between 0 and {} exclusive for {}", partition, count, namespace);
            throw new IllegalArgumentException("The provided partition is not valid: " + partition);
        }
    }

    private void initializeStorage() {
        storage = new HashMap<>();
        namespaces.forEach(namespace -> storage.put(namespace, emptyPartitions(namespace)));
    }

    private Map<Integer, Map<String, byte[]>> emptyPartitions(String namespace) {
        int count = partitions.get(namespace);
        Map<Integer, Map<String, byte[]>> emptyPartitions = new HashMap<>();
        IntStream.range(0, count).forEach(i -> emptyPartitions.put(i, new HashMap<>()));
        return emptyPartitions;
    }
}
