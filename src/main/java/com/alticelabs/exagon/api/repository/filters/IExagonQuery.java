package com.alticelabs.exagon.api.repository.filters;

/**
 * Interface representing a query for retrieving data from a data source.
 * This interface provides methods for controlling pagination and sorting of the query results.
 */
public interface IExagonQuery {

    /**
     * Sets the number of results to skip in the query.
     *
     * @param skip the number of results to skip
     */
    void setSkip(int skip);

    /**
     * Gets the number of results to skip in the query.
     * @return the number of results to skip
     */
    int getSkip();

    /**
     * Sets the maximum number of results to return in the query.
     *
     * @param limit the maximum number of results to return
     */
    void setLimit(int limit);


    /**
     * Gets the maximum number of results to return in the query.
     *
     * @return the maximum number of results to return
     */
    int getLimit();

    /**
     * Sets the sorting criteria for the query results.
     *
     * @param orderBy the sorting criteria
     */
    void setOrderBy(ExagonOrderCriterion orderBy);

    /**
     * Gets the sorting criteria for the query results.
     *
     * @return the sorting order
     */
    ExagonOrderCriterion getOrderBy();

}
