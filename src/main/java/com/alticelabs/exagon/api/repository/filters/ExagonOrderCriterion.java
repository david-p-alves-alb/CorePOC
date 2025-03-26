package com.alticelabs.exagon.api.repository.filters;

/**
 * Represents an ordering criterion for sorting query results.
 * This class defines the field to be used for sorting and the order direction.
 */
public class ExagonOrderCriterion {

    /**
     * Default constructor.
     * Initializes an empty sorting criterion.
     */
    public ExagonOrderCriterion() {
    }

    /**
     * Constructs a new ExagonOrderCriterion with the specified field and order.
     *
     * @param field the field by which the results should be sorted
     * @param order the sorting order (ascending or descending)
     */
    public ExagonOrderCriterion(String field, ExagonOrder order) {
        this.field = field;
        this.order = order;
    }

    /** The field by which the results should be sorted. */
    private String field;

    /** The sorting order (ascending or descending). */
    private ExagonOrder order;

}
