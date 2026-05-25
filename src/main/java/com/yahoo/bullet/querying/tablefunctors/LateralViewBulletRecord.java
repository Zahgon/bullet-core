/*
 *  Copyright 2021, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.querying.tablefunctors;

import com.yahoo.bullet.record.BulletRecord;
import com.yahoo.bullet.typesystem.Type;
import com.yahoo.bullet.typesystem.TypedObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * This {@link BulletRecord} is only used for Lateral View and possible operations in the
 * {@link com.yahoo.bullet.querying.Querier} thereafter. It is not intended to be a fully-functional {@link BulletRecord}
 * and does not implement any methods that are not expected to be called.
 *
 * Note: The {@link com.yahoo.bullet.query.Projection.Type#COPY} projection calls {@link BulletRecord#copy()} so that
 * the incoming record is not clobbered by record changes. In the case of lateral view, the top record is generated from
 * a table function and is therefore one-time use and can be modified however. As a result, the
 * {@link LateralViewBulletRecord#copy()} method returns this.
 *
 * Furthermore, the {@link com.yahoo.bullet.query.Projection.Type#COPY} projection can have a
 * {@link com.yahoo.bullet.query.postaggregations.PostAggregationType#CULLING} post-aggregation as a result of renaming
 * a field. If, for example, there was a field "A" in both the top and base records, renaming field "A" would expose the
 * field "A" in the base record. To handle this, the record tracks which fields were "culled" and removes these from the
 * raw data map when called.
 */
@RequiredArgsConstructor
@Getter(AccessLevel.PACKAGE)
class LateralViewBulletRecord extends BulletRecord {

    private static final long serialVersionUID = 1756000447237973392L;

    private final BulletRecord baseRecord;

    private final BulletRecord topRecord;

    private Set<String> culledFields = new HashSet<>();

    @Override
    protected Serializable convert(Object object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected BulletRecord rawSet(String field, Serializable object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Map<String, Serializable> getRawDataMap() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Serializable get(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasField(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int fieldCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Serializable getAndRemove(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BulletRecord remove(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypedObject typedGet(String field, Type hint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BulletRecord typedSet(String field, TypedObject object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BulletRecord copy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
