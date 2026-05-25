/*
 *  Copyright 2017, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.querying.aggregations;

import com.yahoo.bullet.common.BulletConfig;
import com.yahoo.bullet.query.aggregations.Aggregation;
import com.yahoo.bullet.querying.aggregations.sketches.Sketch;
import com.yahoo.bullet.record.BulletRecord;
import com.yahoo.bullet.result.Clip;
import com.yahoo.bullet.result.Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The parent class for all {@link Strategy} that use Sketches.
 *
 * @param <S> A {@link Sketch} type.
 */
public abstract class SketchingStrategy<S extends Sketch> implements Strategy {

    // The metadata concept to key mapping
    protected final Map<String, String> metadataKeys;

    // Separator for multiple fields when inserting into the Sketch
    protected final String separator;

    // The fields being inserted into the Sketch
    protected final List<String> fields;

    // The Sketch that should be initialized by a child class
    protected S sketch;

    private boolean shouldMeta;

    /**
     * The constructor for creating a Sketch based strategy.
     *
     * @param aggregation An {@link Aggregation} with valid fields and attributes for this aggregation type.
     * @param config The config that has relevant configs for this sketch based strategy.
     */
    @SuppressWarnings("unchecked")
    public SketchingStrategy(Aggregation aggregation, BulletConfig config) {
        metadataKeys = (Map<String, String>) config.getAs(BulletConfig.RESULT_METADATA_METRICS, Map.class);
        separator = config.getAs(BulletConfig.AGGREGATION_COMPOSITE_FIELD_SEPARATOR, String.class);
        shouldMeta = config.getAs(BulletConfig.RESULT_METADATA_ENABLE, Boolean.class);
        fields = aggregation.getFields();
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
    public Clip getResult() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<BulletRecord> getRecords() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Meta getMetadata() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Extracts the fields in a pre-determined order from {@link BulletRecord} as one String with the separator.
     *
     * @param record The non-null record containing data for the fields.
     * @return A string representing the composite field.
     */
    String composeField(BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Composes a {@link Stream} of strings together into one string with the separator.
     *
     * @param fields The fields to combine.
     * @return A string that represents the fields.
     */
    String composeField(Stream<String> fields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Breaks down a composite field into individual fields.
     *
     * @param field The composite field to break down.
     * @return A {@link List} of the fields that this field was made of.
     */
    List<String> decomposeField(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String getMetaKey() {
        return shouldMeta ? metadataKeys.getOrDefault(Meta.Concept.SKETCH_METADATA.getName(), null) : null;
    }
}
