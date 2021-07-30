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

import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
public class PageQuery implements IQuery, Pageable, Groupable, Orderable, Limitable, Serializable {

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
    private Integer page = DEFAULT_PAGE;

    /**
     * return the page size for pageable, min is {@code 1}, could be null.
     */
    @Nullable
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

    public void setPage(final Integer page) {
        if (Objects.nonNull(page) && page < DEFAULT_PAGE) {
            this.page = DEFAULT_PAGE;
        } else {
            this.page = page;
        }
    }

}
