package com.alticelabs.exagon.api.repository.filters;

/**
 * Enumeration representing the different comparison operators used in Exagon Repository Queries.
 * These operators define various ways to compare values in filtering operations.
 */
public enum ExagonComparisonOperator {
    /**
     * Represents the "less than" comparison operator.
     */
    LESS_THAN,

    /**
     * Represents the "greater than" comparison operator.
     */
    GREATER_THAN,

    /**
     * Represents the "less than or equal to" comparison operator.
     */
    LESS_THAN_OR_EQUALS,

    /**
     * Represents the "equal to" comparison operator.
     */
    EQUALS,

    /**
     * Represents the "greater than or equal to" comparison operator.
     */
    GREATER_THAN_OR_EQUALS,

    /**
     * Represents the "not equal to" comparison operator.
     */
    NOT_EQUAL,

    /**
     * Represents a comparison operator that checks if a value contains a specific substring.
     */
    CONTAINS
}
