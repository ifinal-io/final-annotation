/*
 * Copyright 2020-2021 the original author or authors.
 *
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
 *
 */

package org.ifinal.finalframework.core;

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

    public void setPage(final Integer page) {
        if (Objects.nonNull(page) && page < DEFAULT_PAGE) {
            this.page = DEFAULT_PAGE;
        } else {
            this.page = page;
        }
    }

}
