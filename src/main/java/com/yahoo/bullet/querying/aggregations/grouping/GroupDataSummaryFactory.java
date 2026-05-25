/*
 *  Copyright 2017, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.querying.aggregations.grouping;

import com.yahoo.memory.Memory;
import com.yahoo.sketches.tuple.DeserializeResult;
import com.yahoo.sketches.tuple.Summary;
import com.yahoo.sketches.tuple.SummaryFactory;
import com.yahoo.sketches.tuple.SummarySetOperations;

public class GroupDataSummaryFactory implements SummaryFactory {

    public static final int SERIALIZED_SIZE = 1;

    public static final byte[] SERIALIZED = new byte[SERIALIZED_SIZE];

    public static final GroupDataSummarySetOperations SUMMARY_OPERATIONS = new GroupDataSummarySetOperations();

    @Override
    public Summary newSummary() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SummarySetOperations getSummarySetOperations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DeserializeResult summaryFromMemory(Memory serializedSummary) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public byte[] toByteArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Needed to deserialize an instance of this {@link GroupDataSummaryFactory} from a {@link Memory}.
     *
     * @param summaryFactory The serialized summary factory.
     * @return A {@link DeserializeResult} representing the deserialized summary factory.
     */
    public static DeserializeResult<GroupDataSummaryFactory> fromMemory(Memory summaryFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
