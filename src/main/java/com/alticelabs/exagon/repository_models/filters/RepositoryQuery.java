package com.alticelabs.exagon.repository_models.filters;

public class RepositoryQuery implements IQuery {
    private final RepositoryFilter filter;
    private int skip;
    private int limit;
    private OrderBy orderBy;

    public RepositoryQuery(RepositoryFilter filter) {
        this.filter = filter;
    }

    public int getSkip() {
        return this.skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public OrderBy getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
    }

    public RepositoryFilter getFilter() {
        return this.filter;
    }
}
