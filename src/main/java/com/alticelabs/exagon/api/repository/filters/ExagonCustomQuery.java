package com.alticelabs.exagon.api.repository.filters;

/**
 * Represents a custom query implementation for Exagon Repositories, allowing filtering, pagination, and ordering.
 */
public class ExagonCustomQuery implements IExagonQuery {

    /**
     * filter query using ExagonRepositoryFilter
     */
    private ExagonRepositoryFilter filter;

    /**
     * Number of records to skip in the query results.
     */
    private int skip;

    /**
     * Maximum number of records to retrieve.
     */
    private int limit;

    /**
     * Ordering criterion for sorting the query results.
     */
    private ExagonOrderCriterion orderBy;

    /**
     * Default constructor.
     */
    public ExagonCustomQuery() {}

    /**
     * Constructs an ExagonCustomQuery with the specified filter, skip, limit, and ordering criterion.
     *
     * @param filter the filter to apply to the query
     * @param skip the number of records to skip
     * @param limit the maximum number of records to retrieve
     * @param orderBy the ordering criterion for sorting the results
     */
    public ExagonCustomQuery(ExagonRepositoryFilter filter, int skip, int limit, ExagonOrderCriterion orderBy) {
        this.filter = filter;
        this.skip = skip;
        this.limit = limit;
        this.orderBy = orderBy;
    }

    /**
     * Retrieves the filter applied to the query.
     *
     * @return the filter
     */
    public ExagonRepositoryFilter getFilter() {
        return filter;
    }

    /**
     * Sets the filter to be applied to the query.
     *
     * @param filter the filter to set
     */
    public void setFilter(ExagonRepositoryFilter filter) {
        this.filter = filter;
    }

    @Override
    public void setSkip(int skip) {
        this.skip = skip;
    }

    @Override
    public int getSkip() {
        return this.skip;
    }

    @Override
    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public int getLimit() {
        return this.limit;
    }

    @Override
    public void setOrderBy(ExagonOrderCriterion orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public ExagonOrderCriterion getOrderBy() {
        return this.orderBy;
    }
}
