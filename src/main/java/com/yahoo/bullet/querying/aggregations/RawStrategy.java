/*
 *  Copyright 2017, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.querying.aggregations;

import com.yahoo.bullet.common.BulletConfig;
import com.yahoo.bullet.common.SerializerDeserializer;
import com.yahoo.bullet.query.aggregations.Aggregation;
import com.yahoo.bullet.record.BulletRecord;
import com.yahoo.bullet.result.Clip;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the LIMIT operation on multiple raw {@link BulletRecord}.
 *
 * A call to {@link #getData()} or {@link #getResult()} will return the current collection of
 * records, which is a {@link List} of {@link BulletRecord}.
 *
 * A call to {@link #combine(byte[])} with the result of {@link #getData()} will combine records from
 * the {@link List} till the aggregation size is reached.
 *
 * This {@link Strategy} will only consume or combine till the specified aggregation size is reached.
 */
@Slf4j
public class RawStrategy implements Strategy {

    private ArrayList<BulletRecord> aggregate = new ArrayList<>();

    private Integer size;

    private int consumed = 0;

    private int combined = 0;

    /**
     * Constructor that takes in an {@link Aggregation} and a {@link BulletConfig}. The size of the aggregation is used
     * as a LIMIT operation.
     *
     * @param aggregation The aggregation that specifies how and what this will compute.
     * @param config The config that has relevant configs for this strategy.
     */
    @SuppressWarnings("unchecked")
    public RawStrategy(Aggregation aggregation, BulletConfig config) {
        int maximumSize = config.getAs(BulletConfig.RAW_AGGREGATION_MAX_SIZE, Integer.class);
        size = Math.min(aggregation.getSize(), maximumSize);
    }

    @Override
    public boolean isClosed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void consume(BulletRecord data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Since {@link #getData()} returns a {@link List} of {@link BulletRecord}, this method consumes
     * that list. If the deserialized List has a size that takes the aggregated records above the aggregation size, only
     * the first X records in the List will be combined till the size is reached.
     *
     * @param data A serialized {@link List} of {@link BulletRecord}.
     */
    @Override
    public void combine(byte[] data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the serialized {@link List} of {@link BulletRecord} seen before the last call to {@link #reset()}.
     *
     * @return the serialized byte[] representing the {@link List} of {@link BulletRecord} or null if it could not.
     */
    @Override
    public byte[] getData() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the aggregated records so far since the last call to {@link #reset()}. The records have a size that is at
     * most the maximum specified by the {@link Aggregation}.
     *
     * @return a {@link Clip} of the records so far.
     */
    @Override
    public Clip getResult() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the aggregated records so far since the last call to {@link #reset()}. The records have a size that is at
     * most the maximum specified by the {@link Aggregation}.
     *
     * @return a {@link List} of the records so far.
     */
    @Override
    public List<BulletRecord> getRecords() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
