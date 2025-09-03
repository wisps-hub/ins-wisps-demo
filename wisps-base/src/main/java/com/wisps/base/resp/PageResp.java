package com.wisps.base.resp;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页响应
 */
@Setter
@Getter
public class PageResp<T> extends MultiResp<T> {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    private int currPage;
    /**
     * 每页结果数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 总数
     */
    private int total;

    public static <T> PageResp<T> of(List<T> datas, int total, int pageSize, int currentPage) {
        PageResp<T> pageResponse = new PageResp<>();
        pageResponse.setSuccess(true);
        pageResponse.setDatas(datas);
        pageResponse.setTotal(total);
        pageResponse.setPageSize(pageSize);
        pageResponse.setCurrPage(currentPage);
        pageResponse.setTotalPage((pageSize + total - 1) / pageSize);
        return pageResponse;
    }
}
