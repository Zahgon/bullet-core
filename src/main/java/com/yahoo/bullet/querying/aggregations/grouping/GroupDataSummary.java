/*
 *  Copyright 2017, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.querying.aggregations.grouping;

import com.yahoo.bullet.common.SerializerDeserializer;
import com.yahoo.memory.Memory;
import com.yahoo.memory.NativeMemory;
import com.yahoo.sketches.tuple.DeserializeResult;
import com.yahoo.sketches.tuple.UpdatableSummary;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class GroupDataSummary implements UpdatableSummary<CachingGroupData> {

    public static final int INITIALIZED_POSITION = 0;

    public static final int SIZE_POSITION = Byte.BYTES;

    public static final int DATA_POSITION = SIZE_POSITION + Integer.BYTES;

    @Getter(AccessLevel.PACKAGE)
    private boolean initialized = false;

    @Getter
    @Setter(AccessLevel.PACKAGE)
    private GroupData data;

    @Override
    public void update(CachingGroupData value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * This method merges two {@link GroupDataSummary} into each other. It picks the first non-null parameter to
     * merge into and returns that after merge.
     *
     * @param a The first {@link GroupDataSummary} to merge.
     * @param b The second {@link GroupDataSummary} to merge.
     * @return The resulting merged summary or null if both arguments were null.
     */
    public static GroupDataSummary mergeInPlace(GroupDataSummary a, GroupDataSummary b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void mergeInPlace(GroupDataSummary other) {
        if (other == null) {
            return;
        }
        // This check is unnecessary since all merges will have valid (or at least non empty data) from the very fact
        // that they were created (see update above).
        GroupData targetData = other.getData();
        if (targetData == null) {
            return;
        }
        // In-place, so not copying targetData
        if (data == null) {
            data = targetData;
        } else {
            data.combine(targetData);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public GroupDataSummary copy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public byte[] toByteArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Needed to deserialize an instance of this {@link GroupDataSummary} from a {@link Memory}.
     *
     * @param serializedSummary The serialized summary as a {@link Memory} object.
     * @return A {@link DeserializeResult} representing the deserialized summary.
     */
    public static DeserializeResult<GroupDataSummary> fromMemory(Memory serializedSummary) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
