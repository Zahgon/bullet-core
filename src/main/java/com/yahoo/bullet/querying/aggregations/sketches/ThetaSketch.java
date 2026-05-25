/*
 *  Copyright 2017, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.querying.aggregations.sketches;

import com.yahoo.bullet.record.BulletRecord;
import com.yahoo.bullet.record.BulletRecordProvider;
import com.yahoo.bullet.result.Clip;
import com.yahoo.memory.NativeMemory;
import com.yahoo.sketches.Family;
import com.yahoo.sketches.ResizeFactor;
import com.yahoo.sketches.theta.SetOperation;
import com.yahoo.sketches.theta.Sketch;
import com.yahoo.sketches.theta.Sketches;
import com.yahoo.sketches.theta.Union;
import com.yahoo.sketches.theta.UpdateSketch;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ThetaSketch extends KMVSketch {

    private UpdateSketch updateSketch;

    private Union unionSketch;

    private Sketch result;

    private String family;

    public static final String COUNT_FIELD = "count";

    /**
     * Constructor for creating a theta sketch.
     *
     * @param resizeFactor The {@link ResizeFactor} to use for the sketch.
     * @param family The {@link Family} to use.
     * @param samplingProbability The sampling probability to use.
     * @param nominalEntries The nominal entries for the sketch.
     * @param provider A BulletRecordProvider to generate BulletRecords.
     */
    public ThetaSketch(ResizeFactor resizeFactor, Family family, float samplingProbability, int nominalEntries, BulletRecordProvider provider) {
        updateSketch = UpdateSketch.builder().setFamily(family).setNominalEntries(nominalEntries).setP(samplingProbability).setResizeFactor(resizeFactor).build();
        unionSketch = SetOperation.builder().setNominalEntries(nominalEntries).setP(samplingProbability).setResizeFactor(resizeFactor).buildUnion();
        this.family = family.getFamilyName();
        this.provider = provider;
    }

    /**
     * Update the sketch with a String field.
     *
     * @param field The field to present to the sketch.
     */
    public void update(String field) {
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

    // Metadata
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

    private BulletRecord getCount() {
        double count = result.getEstimate();
        BulletRecord record = provider.getInstance();
        record.setLong(COUNT_FIELD, Math.round(count));
        return record;
    }
}
