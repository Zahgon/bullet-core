/*
 *  Copyright 2017, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.querying.aggregations.sketches;

import com.yahoo.bullet.common.Utilities;
import com.yahoo.bullet.query.aggregations.DistributionType;
import com.yahoo.bullet.record.BulletRecord;
import com.yahoo.bullet.record.BulletRecordProvider;
import com.yahoo.bullet.result.Clip;
import com.yahoo.bullet.result.Meta.Concept;
import com.yahoo.memory.NativeMemory;
import com.yahoo.sketches.Family;
import com.yahoo.sketches.quantiles.DoublesSketch;
import com.yahoo.sketches.quantiles.DoublesSketchBuilder;
import com.yahoo.sketches.quantiles.DoublesUnion;
import com.yahoo.sketches.quantiles.DoublesUnionBuilder;
import com.yahoo.sketches.quantiles.UpdateDoublesSketch;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static com.yahoo.bullet.common.Utilities.round;
import static com.yahoo.bullet.result.Meta.addIfNonNull;

/**
 * Wraps operations for working with a {@link DoublesSketch} - Quantile Sketch.
 */
public class QuantileSketch extends DualSketch {

    private UpdateDoublesSketch updateSketch;

    private DoublesUnion unionSketch;

    private DoublesSketch result;

    private double[] points;

    private Integer numberOfPoints;

    private int rounding;

    private final DistributionType type;

    public static final double QUANTILE_MIN = 0.0;

    public static final double QUANTILE_MAX = 1.0;

    public static final String QUANTILE_FIELD = "Quantile";

    public static final String VALUE_FIELD = "Value";

    public static final String PROBABILITY_FIELD = "Probability";

    public static final String COUNT_FIELD = "Count";

    public static final String RANGE_FIELD = "Range";

    public static final String START_INCLUSIVE = "[";

    public static final String START_EXCLUSIVE = "(";

    public static final String END_EXCLUSIVE = ")";

    public static final String SEPARATOR = " to ";

    public static final String INFINITY = "\u221e";

    public static final String POSITIVE_INFINITY = "+" + INFINITY;

    public static final String NEGATIVE_INFINITY = "-" + INFINITY;

    public static final String NEGATIVE_INFINITY_START = START_EXCLUSIVE + NEGATIVE_INFINITY;

    public static final String POSITIVE_INFINITY_END = POSITIVE_INFINITY + END_EXCLUSIVE;

    private QuantileSketch(int k, DistributionType type) {
        updateSketch = new DoublesSketchBuilder().build(k);
        unionSketch = new DoublesUnionBuilder().setMaxK(k).build();
        this.type = type;
    }

    /**
     * Creates a quantile sketch with the given number of entries getting results with the given points.
     *
     * @param k A number representative of the size of the sketch.
     * @param type A {@link DistributionType} that determines what the points mean.
     * @param points An array of points to get the quantiles, PMF and/or CDF for.
     * @param provider A BulletRecordProvider to generate BulletRecords.
     */
    public QuantileSketch(int k, DistributionType type, double[] points, BulletRecordProvider provider) {
        this(k, type);
        this.points = points;
        this.provider = provider;
    }

    /**
     * Creates a quantile sketch with the given number of entries generating results with the number of
     * points (evenly-spaced).
     *
     * @param k A number representative of the size of the sketch.
     * @param rounding A number representing how many max decimal places points should have.
     * @param type A {@link DistributionType} that determines what the points mean.
     * @param numberOfPoints A positive number of evenly spaced points in the range for the type to get the data for.
     * @param provider A BulletRecordProvider to generate BulletRecords.
     */
    public QuantileSketch(int k, int rounding, DistributionType type, int numberOfPoints, BulletRecordProvider provider) {
        this(k, type);
        this.rounding = Math.abs(rounding);
        this.numberOfPoints = numberOfPoints;
        this.provider = provider;
    }

    /**
     * Updates the sketch with a double.
     *
     * @param data A double to insert into the sketch.
     */
    public void update(double data) {
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

    private Double getMinimum() {
        return result.getMinValue();
    }

    private Double getMaximum() {
        return result.getMaxValue();
    }

    private Long getNumberOfEntries() {
        return result.getN();
    }

    private Double getNormalizedRankError() {
        return result.getNormalizedRankError();
    }

    private double[] getDomain() {
        if (numberOfPoints != null) {
            return type == DistributionType.QUANTILE ? getPoints(QUANTILE_MIN, QUANTILE_MAX, numberOfPoints, rounding) : getPoints(getMinimum(), getMaximum(), numberOfPoints, rounding);
        }
        return points;
    }

    /**
     * Exposed for testing only.
     *
     * Creates a {@link List} of {@link BulletRecord} for each corresponding entry in domain and range. The domain
     * is first converted into range names depending on the type.
     *
     * @param domain An array of split points of size N greater than 0.
     * @param range  An array of values for each range in domain: of size N + 1
     *               if type is not {@link DistributionType#QUANTILE} else N.
     * @param type The {@link DistributionType} to zip for.
     * @param n A long to scale the value of each range entry by if type is not {@link DistributionType#QUANTILE}.
     * @return The records that correspond to the data.
     */
    List<BulletRecord> zip(double[] domain, double[] range, DistributionType type, long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Static helpers
    private static double[] getPoints(double start, double end, int numberOfPoints, int rounding) {
        // We should have numberOfPoints >= 1 but just in case...
        if (numberOfPoints <= 1 || start >= end) {
            return new double[] { round(start, rounding) };
        }
        double increment = (end - start) / (numberOfPoints - 1);
        return Utilities.generatePoints(start, num -> num + increment, numberOfPoints, rounding);
    }

    private List<BulletRecord> zipQuantiles(double[] domain, double[] range) {
        List<BulletRecord> records = new ArrayList<>();
        for (int i = 0; i < domain.length; ++i) {
            records.add(provider.getInstance().setDouble(QUANTILE_FIELD, domain[i]).setDouble(VALUE_FIELD, range[i]));
        }
        return records;
    }

    private List<BulletRecord> zipRanges(double[] domain, double[] range, long n, boolean cumulative) {
        List<BulletRecord> records = new ArrayList<>();
        String[] bins = makeBins(domain, cumulative);
        for (int i = 0; i < bins.length; ++i) {
            records.add(provider.getInstance().setString(RANGE_FIELD, bins[i]).setDouble(PROBABILITY_FIELD, range[i]).setDouble(COUNT_FIELD, range[i] * n));
        }
        return records;
    }

    private static String[] makeBins(double[] splits, boolean cumulative) {
        String[] bins = new String[splits.length + 1];
        int lastIndex = splits.length - 1;
        return cumulative ? makeCDFBins(bins, splits, lastIndex) : makePMFBins(bins, splits, lastIndex);
    }

    private static String[] makePMFBins(String[] bins, double[] splits, int lastIndex) {
        // The bins are created from (-infinity to splits[0]), [split[1] to split[2]), ..., [split[N] to infinity)
        String prefix = NEGATIVE_INFINITY_START + SEPARATOR;
        for (int i = 0; i <= lastIndex; ++i) {
            double binEnd = splits[i];
            bins[i] = prefix + binEnd + END_EXCLUSIVE;
            prefix = START_INCLUSIVE + binEnd + SEPARATOR;
        }
        bins[lastIndex + 1] = START_INCLUSIVE + splits[lastIndex] + SEPARATOR + POSITIVE_INFINITY_END;
        return bins;
    }

    private static String[] makeCDFBins(String[] bins, double[] splits, int lastIndex) {
        // The bins are created from (-infinity to splits[0]), (-infinity to split[1]), ..., (-infinity to +infinity)
        for (int i = 0; i <= lastIndex; ++i) {
            double binEnd = splits[i];
            bins[i] = NEGATIVE_INFINITY_START + SEPARATOR + binEnd + END_EXCLUSIVE;
        }
        bins[lastIndex + 1] = NEGATIVE_INFINITY_START + SEPARATOR + POSITIVE_INFINITY_END;
        return bins;
    }
}
