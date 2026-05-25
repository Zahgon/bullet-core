/*
 *  Copyright 2017, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.querying.aggregations.sketches;

import com.yahoo.bullet.querying.aggregations.grouping.CachingGroupData;
import com.yahoo.bullet.querying.aggregations.grouping.GroupData;
import com.yahoo.bullet.querying.aggregations.grouping.GroupDataSummary;
import com.yahoo.bullet.querying.aggregations.grouping.GroupDataSummaryFactory;
import com.yahoo.bullet.record.BulletRecord;
import com.yahoo.bullet.record.BulletRecordProvider;
import com.yahoo.bullet.result.Clip;
import com.yahoo.bullet.result.Meta.Concept;
import com.yahoo.memory.NativeMemory;
import com.yahoo.sketches.Family;
import com.yahoo.sketches.ResizeFactor;
import com.yahoo.sketches.tuple.Sketch;
import com.yahoo.sketches.tuple.SketchIterator;
import com.yahoo.sketches.tuple.Sketches;
import com.yahoo.sketches.tuple.Union;
import com.yahoo.sketches.tuple.UpdatableSketch;
import com.yahoo.sketches.tuple.UpdatableSketchBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static com.yahoo.bullet.result.Meta.addIfNonNull;

public class TupleSketch extends KMVSketch {

    private UpdatableSketch<CachingGroupData, GroupDataSummary> updateSketch;

    private Union<GroupDataSummary> unionSketch;

    private Sketch<GroupDataSummary> result;

    private final int maxSize;

    /**
     * Initialize a tuple sketch for summarizing group data.
     *
     * @param resizeFactor The {@link ResizeFactor} to use for the sketch.
     * @param samplingProbability The sampling probability to use.
     * @param nominalEntries The nominal entries for the sketch.
     * @param maxSize The maximum size of groups to return.
     * @param provider A BulletRecordProvider to generate BulletRecords.
     */
    @SuppressWarnings("unchecked")
    public TupleSketch(ResizeFactor resizeFactor, float samplingProbability, int nominalEntries, int maxSize, BulletRecordProvider provider) {
        GroupDataSummaryFactory factory = new GroupDataSummaryFactory();
        UpdatableSketchBuilder<CachingGroupData, GroupDataSummary> builder = new UpdatableSketchBuilder(factory);
        updateSketch = builder.setResizeFactor(resizeFactor).setNominalEntries(nominalEntries).setSamplingProbability(samplingProbability).build();
        unionSketch = new Union<>(nominalEntries, factory);
        this.maxSize = maxSize;
        this.provider = provider;
    }

    /**
     * Update the sketch with a key representing a group and the data for it.
     *
     * @param key The key to present the data to the sketch as.
     * @param data The data for the group.
     */
    public void update(String key, CachingGroupData data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void union(byte[] serialized) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public byte[] serialize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<BulletRecord> getRecords() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Clip getResult(String metaKey, Map<String, String> conceptKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void mergeBothSketches() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void mergeUpdateSketch() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void mergeUnionSketch() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected boolean unionedExistingResults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Map<String, Object> addMetadata(Map<String, String> conceptKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Meta
    @Override
    protected Boolean isEstimationMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected String getFamily() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Integer getSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Double getTheta() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Double getLowerBound(int standardDeviation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Double getUpperBound(int standardDeviation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the estimate of the uniques in the Sketch. Only applicable after {@link #merge()}.
     *
     * @return A Double representing the number of unique values in the Sketch.
     */
    private Double getUniquesEstimate() {
        return result.getEstimate();
    }
}
