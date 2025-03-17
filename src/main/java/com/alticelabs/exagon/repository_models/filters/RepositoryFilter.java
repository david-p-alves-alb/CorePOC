package com.alticelabs.exagon.repository_models.filters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryFilter {
    private final String key;
    private final Map<LogicalCriteriaComparison, Object> comparisons;
    private final LogicalOperator operator;
    private final List<RepositoryFilter> filters;

    private RepositoryFilter(String key, LogicalOperator operator, RepositoryFilter... filters) {
        this.key = key;
        this.comparisons = new HashMap<>();
        this.operator = operator;
        this.filters = List.of(filters);
    }

    public static RepositoryFilter or(RepositoryFilter... filters) {
        return new RepositoryFilter((String)null, LogicalOperator.OR, filters);
    }

    public static RepositoryFilter and(RepositoryFilter... filters) {
        return new RepositoryFilter((String)null, LogicalOperator.AND, filters);
    }

    public static RepositoryFilter where(String key) {
        return new RepositoryFilter(key, (LogicalOperator)null, new RepositoryFilter[0]);
    }

    public RepositoryFilter is(Object value) {
        this.comparisons.put(LogicalCriteriaComparison.EQUALS, value);
        return this;
    }

    public RepositoryFilter ne(Object value) {
        this.comparisons.put(LogicalCriteriaComparison.NOT_EQUAL, value);
        return this;
    }

    public RepositoryFilter lt(Object value) {
        this.comparisons.put(LogicalCriteriaComparison.LESS_THAN, value);
        return this;
    }

    public RepositoryFilter gt(Object value) {
        this.comparisons.put(LogicalCriteriaComparison.GREATER_THAN, value);
        return this;
    }

    public RepositoryFilter lte(Object value) {
        this.comparisons.put(LogicalCriteriaComparison.LESS_THAN_OR_EQUALS, value);
        return this;
    }

    public RepositoryFilter gte(Object value) {
        this.comparisons.put(LogicalCriteriaComparison.GREATER_THAN_OR_EQUALS, value);
        return this;
    }

    public RepositoryFilter contains(Object value) {
        this.comparisons.put(LogicalCriteriaComparison.CONTAINS, value);
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public Map<LogicalCriteriaComparison, Object> getComparisons() {
        return this.comparisons;
    }

    public LogicalOperator getOperator() {
        return this.operator;
    }

    public List<RepositoryFilter> getFilters() {
        return this.filters;
    }
}
