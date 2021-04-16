package org.ifinal.finalframework.core.result;

import org.ifinal.finalframework.core.IPagination;

import lombok.Data;

/**
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class Pagination implements IPagination {

    private static final long serialVersionUID = -4875155337971995663L;

    /**
     * 页码
     */
    private Integer page;

    /**
     * 页面容量
     */
    private Integer size;

    /**
     * 页数
     */
    private Integer pages;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 是否首页
     */
    private Boolean firstPage;

    /**
     * 是否尾页
     */
    private Boolean lastPage;

}

