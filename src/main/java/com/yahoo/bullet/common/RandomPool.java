/*
 *  Copyright 2016, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.common;

import java.util.List;
import java.util.Random;

public class RandomPool<T> {

    private List<T> items;

    private static final Random RANDOM = new Random();

    /**
     * Constructor for the RandomPool that takes a list of items.
     * @param items A list of items to form the pool with.
     */
    public RandomPool(List<T> items) {
        this.items = items;
    }

    /**
     * Get a random item from the pool.
     *
     * @return a randomly chosen item from the pool.
     */
    public T get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Clear the RandomPool. Gets now return null.
     */
    public void clear() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
