/*
 * Copyright 2020-2021 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ifinalframework.core;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A simple {@linkplain IQuery query} with {@link Pageable}, {@link Orderable},{@link Limitable} and {@link Groupable}.
 *
 * @author ilikly
 * @version 1.0.0
 * @since 1.0.0
 */
@Setter
@Getter
@ToString
public class PageQuery implements IQuery, Pageable, Groupable, Orderable, Limitable, Viewable, Serializable {

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
     * return the page index number for pageable, start from {@code 1}, could be null.
     */
    @Nullable
    @Min(1)
    private Integer page = DEFAULT_PAGE;

    /**
     * return the page size for pageable, min is {@code 1}, could be null.
     */
    @Nullable
    @Max(100000)
    private Integer size = DEFAULT_SIZE;

    /**
     * return {@code true} when need count query otherwise {@code false}.
     */
    @Nullable
    private Boolean count = Boolean.TRUE;

    @Nullable
    private List<String> groups;

    @Nullable
    private List<String> orders;

    @Nullable
    private Long offset;

    @Nullable
    private Long limit;

    private Class<?> view;

    public void setPage(final Integer page) {
        if (Objects.nonNull(page) && page < DEFAULT_PAGE) {
            this.page = DEFAULT_PAGE;
        } else {
            this.page = page;
        }
    }

    /**
     * add order to {@link #orders}
     *
     * @param order order
     * @return page query
     * @since 1.2.2
     */
    public PageQuery addOrder(@NonNull String order) {
        if (orders == null) {
            orders = new LinkedList<>();
        }
        orders.add(order);
        return this;
    }

    /**
     * add group to {@link #groups}
     *
     * @param group group
     * @return page query
     * @since 1.2.2
     */
    public PageQuery addGroup(@NonNull String group) {
        if (Objects.isNull(groups)) {
            groups = new LinkedList<>();
        }
        groups.add(group);
        return this;
    }

}
