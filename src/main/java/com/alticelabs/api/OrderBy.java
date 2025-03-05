package com.alticelabs.api;


public class OrderBy {
    private String field;
    private OrderEnum order;

    public String getField() {
        return this.field;
    }

    public OrderEnum getOrder() {
        return this.order;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setOrder(OrderEnum order) {
        this.order = order;
    }

    public OrderBy() {
    }
}
