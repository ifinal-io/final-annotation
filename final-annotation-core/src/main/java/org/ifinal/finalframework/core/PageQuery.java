package org.ifinal.finalframework.core;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A simple {@linkplain IQuery query} with {@link Pageable}, {@link Orderable},{@link Limitable} and {@link Groupable}.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Setter
@Getter
@ToString
public class PageQuery implements Pageable, Groupable, Orderable, Limitable, Serializable {

    private static final long serialVersionUID = 4813020012879522797L;

    /**
     * 默认分页页码
     */
    private static final Integer DEFAULT_PAGE = 1;

    /**
     * 默认分页容量
     */
    private static final Integer DEFAULT_SIZE = 20;

    /**
     * 分页页面
     */
    private Integer page = DEFAULT_PAGE;

    /**
     * 页面容量
     */
    private Integer size = DEFAULT_SIZE;

    /**
     * 是否启用Count统计
     */
    private Boolean count = Boolean.TRUE;

    private List<String> groups;

    private List<String> orders;

    private Long offset;

    private Long limit;

}
