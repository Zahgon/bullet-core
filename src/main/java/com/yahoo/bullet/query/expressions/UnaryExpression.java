/*
 *  Copyright 2019, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.query.expressions;

import com.yahoo.bullet.common.BulletException;
import com.yahoo.bullet.querying.evaluators.Evaluator;
import com.yahoo.bullet.querying.evaluators.UnaryEvaluator;
import lombok.Getter;
import java.util.Objects;
import static com.yahoo.bullet.query.expressions.Operation.UNARY_OPERATIONS;

/**
 * An expression that requires an operand and a unary operation.
 */
@Getter
public class UnaryExpression extends Expression {

    private static final long serialVersionUID = -1893522779659725928L;

    private static final BulletException UNARY_EXPRESSION_REQUIRES_UNARY_OPERATION = new BulletException("Unary expression requires a unary operation.", "Please specify a unary operation.");

    private final Expression operand;

    private final Operation op;

    /**
     * Constructor that creates a unary expression.
     *
     * @param operand The non-null operand.
     * @param op The non-null unary operation.
     */
    public UnaryExpression(Expression operand, Operation op) {
        this.operand = Objects.requireNonNull(operand);
        this.op = Objects.requireNonNull(op);
        if (!UNARY_OPERATIONS.contains(op)) {
            throw UNARY_EXPRESSION_REQUIRES_UNARY_OPERATION;
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
