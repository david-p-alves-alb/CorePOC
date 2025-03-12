package com.alticelabs.repositoryAPI;

public enum LogicalCriteriaComparison {
    NONE,
    AND,
    OR,
    LESS_THAN,
    GREATER_THAN,
    LESS_THAN_OR_EQUALS,
    EQUALS,
    GREATER_THAN_OR_EQUALS,
    NOT_EQUAL,
    CONTAINS;

    private LogicalCriteriaComparison() {
    }

}
