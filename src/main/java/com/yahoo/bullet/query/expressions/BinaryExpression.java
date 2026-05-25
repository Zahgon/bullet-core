/*
 *  Copyright 2019, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.query.expressions;

import com.yahoo.bullet.common.BulletException;
import com.yahoo.bullet.querying.evaluators.BinaryEvaluator;
import com.yahoo.bullet.querying.evaluators.Evaluator;
import lombok.Getter;
import java.util.Objects;
import static com.yahoo.bullet.query.expressions.Operation.BINARY_OPERATIONS;

/**
 * An expression that requires two operands and a binary operation.
 */
@Getter
public class BinaryExpression extends Expression {

    private static final long serialVersionUID = -7911485746578844403L;

    private static final BulletException BINARY_EXPRESSION_REQUIRES_BINARY_OPERATION = new BulletException("Binary expression requires a binary operation.", "Please specify a binary operation.");

    private final Expression left;

    private final Expression right;

    private final Operation op;

    /**
     * Constructor that creates a binary expression.
     *
     * @param left The non-null left operand.
     * @param right The non-null right operand.
     * @param op The non-null binary operation.
     */
    public BinaryExpression(Expression left, Expression right, Operation op) {
        this.left = Objects.requireNonNull(left);
        this.right = Objects.requireNonNull(right);
        this.op = Objects.requireNonNull(op);
        if (!BINARY_OPERATIONS.contains(op)) {
            throw BINARY_EXPRESSION_REQUIRES_BINARY_OPERATION;
        }
    }

    @Override
    public Evaluator getEvaluator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
