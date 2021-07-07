package com.toyota.uicomponent.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataSourceRequest {
    private int page;
    private int pageSize;
    private int take;
    private int skip;
    private List<Filter> filter;
    private List<Sort> sort;

    public DataSourceRequest() {
        filter = new ArrayList<Filter>();
        sort = new ArrayList<Sort>();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTake() {
        return take;
    }

    public void setTake(int take) {
        this.take = take;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public List<Filter> getFilter() {
        return filter;
    }

    public void setFilter(ArrayList<Filter> filter) {
        this.filter = filter;
    }

    public List<Sort> getSort() {
        return sort;
    }

    public void setSort(ArrayList<Sort> sort) {
        this.sort = sort;
    }
}
