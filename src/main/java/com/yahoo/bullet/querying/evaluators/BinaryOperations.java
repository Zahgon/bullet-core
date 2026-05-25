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
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static com.yahoo.bullet.common.Utilities.isNull;

/**
 * Binary operations used by BinaryEvaluator.
 */
public class BinaryOperations {

    @FunctionalInterface
    public interface BinaryOperator extends Serializable {

        TypedObject apply(Evaluator left, Evaluator right, BulletRecord record);
    }

    static final Map<Operation, BinaryOperator> BINARY_OPERATORS = new EnumMap<>(Operation.class);

    static {
        BINARY_OPERATORS.put(Operation.ADD, BinaryOperations::add);
        BINARY_OPERATORS.put(Operation.SUB, BinaryOperations::sub);
        BINARY_OPERATORS.put(Operation.MUL, BinaryOperations::mul);
        BINARY_OPERATORS.put(Operation.DIV, BinaryOperations::div);
        BINARY_OPERATORS.put(Operation.MOD, BinaryOperations::mod);
        BINARY_OPERATORS.put(Operation.EQUALS, BinaryOperations::equals);
        BINARY_OPERATORS.put(Operation.EQUALS_ANY, BinaryOperations::equalsAny);
        BINARY_OPERATORS.put(Operation.EQUALS_ALL, BinaryOperations::equalsAll);
        BINARY_OPERATORS.put(Operation.NOT_EQUALS, BinaryOperations::notEquals);
        BINARY_OPERATORS.put(Operation.NOT_EQUALS_ANY, BinaryOperations::notEqualsAny);
        BINARY_OPERATORS.put(Operation.NOT_EQUALS_ALL, BinaryOperations::notEqualsAll);
        BINARY_OPERATORS.put(Operation.GREATER_THAN, BinaryOperations::greaterThan);
        BINARY_OPERATORS.put(Operation.GREATER_THAN_ANY, BinaryOperations::greaterThanAny);
        BINARY_OPERATORS.put(Operation.GREATER_THAN_ALL, BinaryOperations::greaterThanAll);
        BINARY_OPERATORS.put(Operation.LESS_THAN, BinaryOperations::lessThan);
        BINARY_OPERATORS.put(Operation.LESS_THAN_ANY, BinaryOperations::lessThanAny);
        BINARY_OPERATORS.put(Operation.LESS_THAN_ALL, BinaryOperations::lessThanAll);
        BINARY_OPERATORS.put(Operation.GREATER_THAN_OR_EQUALS, BinaryOperations::greaterThanOrEquals);
        BINARY_OPERATORS.put(Operation.GREATER_THAN_OR_EQUALS_ANY, BinaryOperations::greaterThanOrEqualsAny);
        BINARY_OPERATORS.put(Operation.GREATER_THAN_OR_EQUALS_ALL, BinaryOperations::greaterThanOrEqualsAll);
        BINARY_OPERATORS.put(Operation.LESS_THAN_OR_EQUALS, BinaryOperations::lessThanOrEquals);
        BINARY_OPERATORS.put(Operation.LESS_THAN_OR_EQUALS_ANY, BinaryOperations::lessThanOrEqualsAny);
        BINARY_OPERATORS.put(Operation.LESS_THAN_OR_EQUALS_ALL, BinaryOperations::lessThanOrEqualsAll);
        BINARY_OPERATORS.put(Operation.REGEX_LIKE, BinaryOperations::regexLike);
        BINARY_OPERATORS.put(Operation.REGEX_LIKE_ANY, BinaryOperations::regexLikeAny);
        BINARY_OPERATORS.put(Operation.NOT_REGEX_LIKE, BinaryOperations::notRegexLike);
        BINARY_OPERATORS.put(Operation.NOT_REGEX_LIKE_ANY, BinaryOperations::notRegexLikeAny);
        BINARY_OPERATORS.put(Operation.SIZE_IS, BinaryOperations::sizeIs);
        BINARY_OPERATORS.put(Operation.CONTAINS_KEY, BinaryOperations::containsKey);
        BINARY_OPERATORS.put(Operation.CONTAINS_VALUE, BinaryOperations::containsValue);
        BINARY_OPERATORS.put(Operation.IN, BinaryOperations::in);
        BINARY_OPERATORS.put(Operation.NOT_IN, BinaryOperations::notIn);
        BINARY_OPERATORS.put(Operation.AND, BinaryOperations::and);
        BINARY_OPERATORS.put(Operation.OR, BinaryOperations::or);
        BINARY_OPERATORS.put(Operation.XOR, BinaryOperations::xor);
        BINARY_OPERATORS.put(Operation.FILTER, BinaryOperations::filter);
    }

    static TypedObject add(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject sub(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject mul(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject div(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject mod(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject equals(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject equalsAny(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject equalsAll(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject notEquals(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject notEqualsAny(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject notEqualsAll(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject greaterThan(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject greaterThanAny(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject greaterThanAll(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject lessThan(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject lessThanAny(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject lessThanAll(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject greaterThanOrEquals(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject greaterThanOrEqualsAny(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject greaterThanOrEqualsAll(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject lessThanOrEquals(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject lessThanOrEqualsAny(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject lessThanOrEqualsAll(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject regexLike(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    static TypedObject regexLikeAny(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject notRegexLike(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    static TypedObject notRegexLikeAny(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject sizeIs(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject containsKey(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject containsValue(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject in(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject notIn(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject and(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject or(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static TypedObject xor(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    static TypedObject filter(Evaluator left, Evaluator right, BulletRecord record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static TypedObject checkNull(Evaluator left, Evaluator right, BulletRecord record, BiFunction<TypedObject, TypedObject, TypedObject> operator) {
        TypedObject leftValue = left.evaluate(record);
        if (isNull(leftValue)) {
            return TypedObject.NULL;
        }
        TypedObject rightValue = right.evaluate(record);
        if (isNull(rightValue)) {
            return TypedObject.NULL;
        }
        return operator.apply(leftValue, rightValue);
    }

    @SuppressWarnings("unchecked")
    private static TypedObject ternaryAnyMatch(TypedObject leftValue, TypedObject rightValue, Predicate<Integer> predicate) {
        Type subType = rightValue.getType().getSubType();
        boolean containsNull = false;
        for (Serializable object : (List<? extends Serializable>) rightValue.getValue()) {
            if (object == null) {
                containsNull = true;
            } else if (predicate.test(leftValue.compareTo(new TypedObject(subType, object)))) {
                return TypedObject.TRUE;
            }
        }
        return !containsNull ? TypedObject.FALSE : TypedObject.NULL;
    }

    @SuppressWarnings("unchecked")
    private static TypedObject ternaryAllMatch(TypedObject leftValue, TypedObject rightValue, Predicate<Integer> predicate) {
        Type subType = rightValue.getType().getSubType();
        boolean hasNull = false;
        for (Serializable object : (List<? extends Serializable>) rightValue.getValue()) {
            if (object == null) {
                hasNull = true;
            } else if (!predicate.test(leftValue.compareTo(new TypedObject(subType, object)))) {
                return TypedObject.FALSE;
            }
        }
        return !hasNull ? TypedObject.TRUE : TypedObject.NULL;
    }

    private static Type getArithmeticResultType(Type left, Type right) {
        if (left == Type.DOUBLE || right == Type.DOUBLE) {
            return Type.DOUBLE;
        }
        if (left == Type.FLOAT || right == Type.FLOAT) {
            return Type.FLOAT;
        }
        if (left == Type.LONG || right == Type.LONG) {
            return Type.LONG;
        }
        return Type.INTEGER;
    }

    private static Integer getInteger(TypedObject object) {
        return ((Number) object.getValue()).intValue();
    }

    private static Long getLong(TypedObject object) {
        return ((Number) object.getValue()).longValue();
    }

    private static Float getFloat(TypedObject object) {
        return ((Number) object.getValue()).floatValue();
    }

    private static Double getDouble(TypedObject object) {
        return ((Number) object.getValue()).doubleValue();
    }
}
