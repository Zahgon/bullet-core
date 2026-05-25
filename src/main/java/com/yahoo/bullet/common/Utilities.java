/*
 *  Copyright 2017, Yahoo Inc.
 *  Licensed under the terms of the Apache License, Version 2.0.
 *  See the LICENSE file associated with the project for terms.
 */
package com.yahoo.bullet.common;

import com.yahoo.bullet.record.BulletRecord;
import com.yahoo.bullet.typesystem.Type;
import com.yahoo.bullet.typesystem.TypedObject;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

public class Utilities {

    /**
     * Tries to get the object casted as the target type. If it is generic, the captured types cannot not be
     * validated. Only the base object type is validated.
     *
     * @param entry The object to cast.
     * @param clazz The class of the U.
     * @param <U> The type to get the object as.
     * @return The casted object of type U or null if the cast could not be done.
     */
    @SuppressWarnings("unchecked")
    public static <U> U getCasted(Object entry, Class<U> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tries to get a key from a map as the target type. If it is a generic type, the captured types are not
     * validated. Only the base object type is validated.
     *
     * @param map  The non-null map that possibly contains the key.
     * @param key  The String key to get the value for from the map.
     * @param clazz The class of the U.
     * @param <U> The type to get the object as.
     * @return The casted object of type U or null if the cast could not be done.
     * @throws NullPointerException if the map was null.
     */
    @SuppressWarnings("unchecked")
    public static <U> U getCasted(Map<String, Object> map, String key, Class<U> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks to see if the {@link Map} contains any mappings.
     *
     * @param map The map to check.
     * @return A boolean denoting whether the map had mappings.
     */
    public static boolean isEmpty(Map map) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks to see if the {@link Collection} contains any items.
     *
     * @param collection The collection to check.
     * @return A boolean denoting whether the collection had items.
     */
    public static boolean isEmpty(Collection collection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks to see if the {@link String} is present.
     *
     * @param string The string to check.
     * @return A boolean denoting whether the string was present.
     */
    public static boolean isEmpty(String string) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Throws a {@link NullPointerException} if the {@link List} is null or contains any null elements.
     *
     * @param list The list to check.
     * @param <T> The type of the list.
     * @return The list.
     */
    public static <T> List<T> requireNonNull(List<T> list) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Throws a {@link NullPointerException} if the {@link Set} is null or contains any null elements.
     *
     * @param set The set to check.
     * @param <T> The type of the set.
     * @return The set.
     */
    public static <T> Set<T> requireNonNull(Set<T> set) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Throws a {@link NullPointerException} if the {@link Map} is null or contains any null keys or null values.
     *
     * @param map The map to check.
     * @param <K> The type of the map key.
     * @param <V> The type of the map value.
     * @return The map.
     */
    public static <K, V> Map<K, V> requireNonNull(Map<K, V> map) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the given mapping to the given {@link Map} if the value is not null.
     *
     * @param map The map to check.
     * @param key The key to add.
     * @param value The value to add if not null.
     * @param <K> The type of the map key.
     * @param <V> The type of the map value.
     * @return The map.
     */
    public static <K, V> Map<K, V> putNotNull(Map<K, V> map, K key, V value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Rounds a double up to the specified number of places.
     *
     * @param value The number to round.
     * @param places The number of maximum decimal places to round up to.
     * @return The resulting rounded double.
     */
    public static double round(double value, int places) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Generates an array of points from the given arguments.
     *
     * @param start The first point to begin with.
     * @param generator A function that returns the next point given the previous.
     * @param numberOfPoints The size of the resulting array.
     * @param rounding The number of maximum decimal places to round up to.
     * @return An array of points generated from the given arguments.
     */
    public static double[] generatePoints(double start, Function<Double, Double> generator, int numberOfPoints, int rounding) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Extracts the field from the given (@link BulletRecord} as a {@link Number}, if possible.
     *
     * @param field The field to get as a number.
     * @param record The record containing the field.
     * @return The value of the field as a {@link Number} or null if it cannot be forced to one.
     */
    public static Number extractFieldAsNumber(String field, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns if the {@link TypedObject} has type {@link TypedObject#NULL} or value null.
     *
     * @param typedObject The typed object to check for null.
     * @return true if the {@link TypedObject} has type {@link TypedObject#NULL} or value null and false otherwise.
     */
    public static boolean isNull(TypedObject typedObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * This method loads a given class name with the class name key and creates an instance of it by using a constructor
     * that has a single argument for a {@link BulletConfig}. It then passes in the provided config and returns the
     * constructed instance.
     *
     * @param name The name of class name to load.
     * @param config The {@link BulletConfig} to use to create an instance of the class.
     * @param <S> The type of the class.
     * @return A created instance of this class.
     * @throws RuntimeException if there were issues creating an instance. It wraps the real exception.
     */
    @SuppressWarnings("unchecked")
    public static <S> S loadConfiguredClass(String name, BulletConfig config) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
