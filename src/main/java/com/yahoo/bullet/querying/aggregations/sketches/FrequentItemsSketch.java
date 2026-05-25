/*
 *  Copyright 2017, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.querying.aggregations.sketches;

import com.yahoo.bullet.record.BulletRecord;
import com.yahoo.bullet.record.BulletRecordProvider;
import com.yahoo.bullet.result.Clip;
import com.yahoo.bullet.result.Meta.Concept;
import com.yahoo.memory.NativeMemory;
import com.yahoo.sketches.ArrayOfItemsSerDe;
import com.yahoo.sketches.ArrayOfUtf16StringsSerDe;
import com.yahoo.sketches.Family;
import com.yahoo.sketches.frequencies.ErrorType;
import com.yahoo.sketches.frequencies.ItemsSketch;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static com.yahoo.bullet.result.Meta.addIfNonNull;

/**
 * Wraps a {@link ItemsSketch} of String.
 */
public class FrequentItemsSketch extends Sketch {

    private ItemsSketch<String> sketch;

    private final ErrorType type;

    private final long threshold;

    private final int maxSize;

    // No state -> static
    private static final ArrayOfItemsSerDe<String> SER_DE = new ArrayOfUtf16StringsSerDe();

    public static final String ITEM_FIELD = "item";

    public static final String COUNT_FIELD = "count";

    /**
     * Creates a FrequentItemsSketch with the given {@link ErrorType}, the maximum map entries, and threshold.
     *
     * @param type The {@link ErrorType} for the Sketch.
     * @param maxMapCapacity The maximum power of 2 entries for the Sketch used as the internal map size.
     * @param threshold The threshold that will be used for selecting items if the Sketch error is less than it.
     * @param maxSize The maximum size of the number of frequent items.
     * @param provider A BulletRecordProvider to generate BulletRecords.
     */
    public FrequentItemsSketch(ErrorType type, int maxMapCapacity, long threshold, int maxSize, BulletRecordProvider provider) {
        this.type = type;
        this.threshold = threshold;
        this.maxSize = maxSize;
        sketch = new ItemsSketch<>(maxMapCapacity);
        this.provider = provider;
    }

    /**
     * Creates a FrequentItemsSketch with the given {@link ErrorType} and the maximum map entries.
     *
     * @param type The {@link ErrorType} for the Sketch.
     * @param maxMapCapacity The maximum power of 2 entries for the Sketch used as the internal map size.
     * @param maxSize The maximum size of the number of frequent items.
     * @param provider A BulletRecordProvider to generate BulletRecords.
     */
    public FrequentItemsSketch(ErrorType type, int maxMapCapacity, int maxSize, BulletRecordProvider provider) {
        // Using -1 guarantees that the Sketch will use its error rather than the -1 threshold.
        this(type, maxMapCapacity, -1L, maxSize, provider);
    }

    /**
     * Inserts an item into the Sketch.
     *
     * @param item The String item to add to the Sketch.
     */
    public void update(String item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void union(byte[] serialized) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<BulletRecord> getRecords() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public byte[] serialize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Clip getResult(String metaKey, Map<String, String> conceptKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Map<String, Object> addMetadata(Map<String, String> conceptKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected String getFamily() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Boolean isEstimationMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Integer getSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Long getStreamLength() {
        return sketch.getStreamLength();
    }

    private Integer getItemsStored() {
        return sketch.getNumActiveItems();
    }

    private Long getMaximumError() {
        return sketch.getMaximumError();
    }
}
