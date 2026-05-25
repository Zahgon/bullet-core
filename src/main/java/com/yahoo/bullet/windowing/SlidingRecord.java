/*
 *  Copyright 2018, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.windowing;

import com.yahoo.bullet.querying.aggregations.Strategy;
import com.yahoo.bullet.common.BulletConfig;
import com.yahoo.bullet.common.SerializerDeserializer;
import com.yahoo.bullet.query.Window;
import com.yahoo.bullet.record.BulletRecord;
import com.yahoo.bullet.result.Meta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;
import java.util.Map;
import static com.yahoo.bullet.result.Meta.addIfNonNull;

public class SlidingRecord extends Basic {

    public static String NAME = "Sliding";

    private int maxCount;

    private int recordCount;

    @AllArgsConstructor
    @Getter
    public static class Data implements Serializable {

        private static final long serialVersionUID = -3035790881273001274L;

        private final long count;

        private final byte[] data;
    }

    /**
     * Creates an instance of this windowing scheme with the provided {@link Strategy} and {@link BulletConfig}.
     *
     * @param aggregation The non-null initialized aggregation strategy that this window will operate.
     * @param window The initialized, configured window to use.
     * @param config The validated config to use.
     */
    public SlidingRecord(Strategy aggregation, Window window, BulletConfig config) {
        super(aggregation, window, config);
        maxCount = window.getEmitEvery();
    }

    @Override
    protected Map<String, Object> getMetadata(Map<String, String> metadataKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void consume(BulletRecord data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void combine(byte[] data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public byte[] getData() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isClosed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isClosedForPartition() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
