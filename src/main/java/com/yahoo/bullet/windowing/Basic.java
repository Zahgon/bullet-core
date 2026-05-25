/*
 *  Copyright 2018, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.windowing;

import com.yahoo.bullet.querying.aggregations.Strategy;
import com.yahoo.bullet.common.BulletConfig;
import com.yahoo.bullet.query.Window;
import com.yahoo.bullet.record.BulletRecord;
import com.yahoo.bullet.result.Clip;
import com.yahoo.bullet.result.Meta;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.yahoo.bullet.result.Meta.addIfNonNull;

/**
 * This is a scheme that does not do any windowing. It just proxies the {@link com.yahoo.bullet.common.Monoidal} calls
 * to the {@link Strategy}. This window is only ever closed when the underlying {@link Strategy} is also
 * {@link Strategy#isClosed()}.
 */
public class Basic extends Scheme {

    public static final String NAME = "Windowless";

    protected long windowCount = 1L;

    /**
     * Creates an instance of this windowing scheme with the provided {@link Strategy} and {@link BulletConfig}.
     *
     * @param aggregation The non-null initialized aggregation strategy that this window will operate.
     * @param window The initialized, configured window to use.
     * @param config The validated config to use.
     */
    public Basic(Strategy aggregation, Window window, BulletConfig config) {
        super(aggregation, window, config);
    }

    @Override
    protected Map<String, Object> getMetadata(Map<String, String> metadataKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * This consumes any data fed to it even if it is {@link #isClosed()} or {@link #isClosedForPartition()}.
     *
     * @param data The {@link BulletRecord} to consume.
     */
    @Override
    public void consume(BulletRecord data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * This combines any data fed to it even if it is {@link #isClosed()} or {@link #isClosedForPartition()}.
     *
     * @param data The {@link BulletRecord} to consume.
     */
    @Override
    public void combine(byte[] data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public byte[] getData() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Clip getResult() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<BulletRecord> getRecords() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void resetForPartition() {
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
    public void start() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the name of this windowing scheme.
     *
     * @return A String name for this window.
     */
    protected String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Counts the number of windows that have been opened since creation.
     *
     * @return A long representing the number of windows opened.
     */
    protected long count() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
