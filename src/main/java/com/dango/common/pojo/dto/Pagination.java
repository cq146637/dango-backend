package com.dango.common.pojo.dto;

import lombok.Data;

@Data
public class Pagination<T> {

    private Integer page;

    private Integer pageSize;

    private Integer totalCount;

    /**
     * 分页数据
     */
    private T data;

    public static<T> Pagination<T> build(Integer pageSize, Integer page, Integer totalCount, T data) {
        Pagination<T> pagination = new Pagination<>();
        pagination.setPageSize(pageSize);
        pagination.setPage(page);
        pagination.setTotalCount(totalCount);
        pagination.setData(data);
        return pagination;
    }
}
