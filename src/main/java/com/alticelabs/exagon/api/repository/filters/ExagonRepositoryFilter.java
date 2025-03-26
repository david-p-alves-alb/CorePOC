package com.alticelabs.exagon.api.repository.filters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a repository filter used in Exagon for constructing complex query conditions.
 * This class supports logical operations (AND, OR) and comparison operations (GT, LT, etc.) .
 */
public final class ExagonRepositoryFilter {

    /**
     * The key representing the field to be filtered.
     */
    private final String key;

    /**
     * A map holding comparison operators and their corresponding values.
     */
    private final Map<ExagonComparisonOperator, Object> comparisons;

    /**
     * The logical operator used to combine multiple filters.
     */
    private final ExagonLogicalOperator operator;

    /**
     * A list of sub-filters combined using the specified logical operator.
     */
    private final List<ExagonRepositoryFilter> filters;

    /**
     * Private constructor for creating a filter with logical operators.
     *
     * @param key the field name to filter on
     * @param operator the logical operator (AND, OR)
     * @param filters sub-filters to be combined
     */
    private ExagonRepositoryFilter(String key, ExagonLogicalOperator operator, ExagonRepositoryFilter... filters) {
        this.key = key;
        this.comparisons = new HashMap<>();
        this.operator = operator;
        this.filters = List.of(filters);
    }

    /**
     * Creates a filter using the OR logical operator.
     *
     * @param filters the filters to combine with OR
     * @return a new ExagonRepositoryFilter instance
     */
    public static ExagonRepositoryFilter or(ExagonRepositoryFilter... filters) {
        return new ExagonRepositoryFilter(null, ExagonLogicalOperator.OR, filters);
    }

    /**
     * Creates a filter using the AND logical operator.
     *
     * @param filters the filters to combine with AND
     * @return a new ExagonRepositoryFilter instance
     */
    public static ExagonRepositoryFilter and(ExagonRepositoryFilter... filters) {
        return new ExagonRepositoryFilter(null, ExagonLogicalOperator.AND, filters);
    }

    /**
     * Creates a filter for a specific field.
     *
     * @param key the field name to filter on
     * @return a new ExagonRepositoryFilter instance
     */
    public static ExagonRepositoryFilter where(String key) {
        return new ExagonRepositoryFilter(key, null);
    }

    /**
     * Adds an equality comparison to the filter.
     *
     * @param value the value to compare
     * @return the updated filter instance
     */
    public ExagonRepositoryFilter is(Object value) {
        comparisons.put(ExagonComparisonOperator.EQUALS, value);
        return this;
    }

    /**
     * Adds a not-equal comparison to the filter.
     *
     * @param value the value to compare
     * @return the updated filter instance
     */
    public ExagonRepositoryFilter ne(Object value) {
        comparisons.put(ExagonComparisonOperator.NOT_EQUAL, value);
        return this;
    }

    /**
     * Adds a less-than comparison to the filter.
     *
     * @param value the value to compare
     * @return the updated filter instance
     */
    public ExagonRepositoryFilter lt(Object value) {
        comparisons.put(ExagonComparisonOperator.LESS_THAN, value);
        return this;
    }

    /**
     * Adds a greater-than comparison to the filter.
     *
     * @param value the value to compare
     * @return the updated filter instance
     */
    public ExagonRepositoryFilter gt(Object value) {
        comparisons.put(ExagonComparisonOperator.GREATER_THAN, value);
        return this;
    }

    /**
     * Adds a less-than-or-equal comparison to the filter.
     *
     * @param value the value to compare
     * @return the updated filter instance
     */
    public ExagonRepositoryFilter lte(Object value) {
        comparisons.put(ExagonComparisonOperator.LESS_THAN_OR_EQUALS, value);
        return this;
    }

    /**
     * Adds a greater-than-or-equal comparison to the filter.
     *
     * @param value the value to compare
     * @return the updated filter instance
     */
    public ExagonRepositoryFilter gte(Object value) {
        comparisons.put(ExagonComparisonOperator.GREATER_THAN_OR_EQUALS, value);
        return this;
    }

    /**
     * Adds a contains comparison to the filter.
     *
     * @param value the value to check containment
     * @return the updated filter instance
     */
    public ExagonRepositoryFilter contains(Object value) {
        comparisons.put(ExagonComparisonOperator.CONTAINS, value);
        return this;
    }

}
