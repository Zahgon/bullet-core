/*
 *  Copyright 2020, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.query;

import com.yahoo.bullet.query.expressions.Expression;
import lombok.Getter;
import java.io.Serializable;
import java.util.Objects;

@Getter
public class Field implements Serializable {

    private static final long serialVersionUID = -2084429671585261042L;

    private String name;

    private Expression value;

    /**
     * Constructor that creates a field used in projection and computation.
     *
     * @param name The non-null name of the field.
     * @param value The non-null value of the field.
     */
    public Field(String name, Expression value) {
        this.name = Objects.requireNonNull(name);
        this.value = Objects.requireNonNull(value);
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
