package com.alticelabs.repo_external_api;

public class MongoQuery implements IQuery {
    private String filterMongoLike;
    private int skip;
    private int limit;
    private OrderBy orderBy;

    public MongoQuery() {
        this.filterMongoLike = "{}";
    }

    public MongoQuery(String filterMongoLike) {
        if (filterMongoLike.isBlank()) {
            this.filterMongoLike = "{}";
        } else {
            this.filterMongoLike = filterMongoLike;
        }

    }

    public void addFilterMongoLike(String filterMongoLike) {
        if (filterMongoLike.isBlank()) {
            this.filterMongoLike = "{}";
        } else {
            this.filterMongoLike = filterMongoLike;
        }

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

    public MongoQuery(String filterMongoLike, int skip, int limit, OrderBy orderBy) {
        this.filterMongoLike = filterMongoLike;
        this.skip = skip;
        this.limit = limit;
        this.orderBy = orderBy;
    }

    public String getFilterMongoLike() {
        return this.filterMongoLike;
    }
}
