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

package org.ifinalframework.core;

import java.io.Serializable;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * The interface of pagination info which query with {@link Pageable}.
 *
 * @author ilikly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IPagination extends Serializable {

    /**
     * return the page number.
     *
     * @return the page number.
     */
    @NonNull
    Integer getPage();

    /**
     * return the size of page in this query.
     *
     * @return the size of page in this query.
     */
    @NonNull
    Integer getSize();

    /**
     * return the total counts of this query.
     *
     * @return the total counts of this query.
     */
    @Nullable
    Long getTotal();

    /**
     * return the total pages of this query.
     *
     * @return the total pages of this query.
     */
    @Nullable
    Integer getPages();

    /**
     * return {@code true} if is the first page.
     *
     * @return {@code true} if is the first page.
     */
    @Nullable
    Boolean getFirstPage();

    /**
     * return {@code true} if this is the last page,
     *
     * @return {@code true} if this is the last page,
     */
    @Nullable
    Boolean getLastPage();

}
