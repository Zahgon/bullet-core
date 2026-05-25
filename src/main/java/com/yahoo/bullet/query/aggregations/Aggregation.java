/*
 *  Copyright 2017, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.query.aggregations;

import com.yahoo.bullet.common.BulletConfig;
import com.yahoo.bullet.common.Configurable;
import com.yahoo.bullet.querying.aggregations.Strategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public abstract class Aggregation implements Configurable, Serializable {

    private static final long serialVersionUID = -4451469769203362270L;

    protected Integer size;

    protected final AggregationType type;

    @Override
    public void configure(BulletConfig config) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new {@link Strategy} instance that handles this aggregation.
     *
     * @param config The {@link BulletConfig} containing configuration for the strategy.
     * @return The created instance of a strategy that can implement this aggregation.
     */
    public abstract Strategy getStrategy(BulletConfig config);

    /**
     * Gets the aggregation fields.
     *
     * @return The aggregation fields.
     */
    public List<String> getFields() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
