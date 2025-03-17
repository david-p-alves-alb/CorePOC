package com.alticelabs.exagon.repository_models.filters;

public interface IQuery {
    int getSkip();

    void setSkip(int var1);

    int getLimit();

    void setLimit(int var1);

    OrderBy getOrderBy();

    void setOrderBy(OrderBy var1);
}
