package com.alticelabs.exagon.api.repository.filters;

/**
 * Enumeration representing logical operators used in Exagon Repository Queries.
 * These operators define logical relationships between conditions in filtering operations.
 */
public enum ExagonLogicalOperator {
    /**
     * Represents the logical AND operator.
     * This operator returns true if both conditions are true.
     */
    AND,

    /**
     * Represents the logical OR operator.
     * This operator returns true if at least one condition is true.
     */
    OR,

    /**
     * Represents the logical NOT operator.
     * This operator inverts the truth value of a condition.
     */
    NOT
}
