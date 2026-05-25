/*
 *  Copyright 2019, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.querying.evaluators;

import com.yahoo.bullet.query.expressions.Operation;
import com.yahoo.bullet.record.BulletRecord;
import com.yahoo.bullet.typesystem.Type;
import com.yahoo.bullet.typesystem.TypedObject;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import static com.yahoo.bullet.common.Utilities.isNull;

public class NAryOperations {

    @FunctionalInterface
    public interface NAryOperator extends Serializable {

        TypedObject apply(List<Evaluator> evaluator, BulletRecord record);
    }

    static final Map<Operation, NAryOperator> N_ARY_OPERATORS = new EnumMap<>(Operation.class);

    static {
        N_ARY_OPERATORS.put(Operation.AND, NAryOperations::allMatch);
        N_ARY_OPERATORS.put(Operation.OR, NAryOperations::anyMatch);
        N_ARY_OPERATORS.put(Operation.IF, NAryOperations::ternary);
        N_ARY_OPERATORS.put(Operation.BETWEEN, NAryOperations::between);
        N_ARY_OPERATORS.put(Operation.NOT_BETWEEN, NAryOperations::notBetween);
        N_ARY_OPERATORS.put(Operation.SUBSTRING, NAryOperations::substring);
        N_ARY_OPERATORS.put(Operation.UNIX_TIMESTAMP, NAryOperations::unixTimestamp);
    }

    static TypedObject allMatch(List<Evaluator> evaluators, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject anyMatch(List<Evaluator> evaluators, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject ternary(List<Evaluator> evaluators, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject between(List<Evaluator> evaluators, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject notBetween(List<Evaluator> evaluators, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject substring(List<Evaluator> evaluators, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject unixTimestamp(List<Evaluator> evaluators, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
