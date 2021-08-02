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

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * IRepository.
 *
 * @author likly
 * @version 1.2.1
 * @since 1.2.1
 */
public interface IRepository<I extends Serializable, T extends IEntity<I>> {

    int insert(@Nullable String table, @Nullable Class<?> view, boolean ignore, @NonNull Collection<T> entities);

    int replace(@Nullable String table, @Nullable Class<?> view, @NonNull Collection<T> entities);

    int save(@Nullable String table, @Nullable Class<?> view, @NonNull Collection<T> entities);

    int update(@Nullable String table, @Nullable Class<?> view,
        @Nullable T entity, @Nullable IUpdate update, boolean selective,
        @Nullable Collection<I> ids, @Nullable IQuery query);

    int delete(@Nullable String table, @Nullable Collection<I> ids, @Nullable IQuery query);

    List<T> select(@Nullable String table, @Nullable Class<?> view, @Nullable Collection<I> ids,
        @Nullable IQuery query);

    T selectOne(@Nullable String table, @Nullable Class<?> view, @Nullable I id, @Nullable IQuery query);

    List<I> selectIds(@Nullable String table, @NonNull IQuery query);

    long selectCount(@Nullable String table, @Nullable Collection<I> ids, @Nullable IQuery query);

    void truncate(@Nullable String table);

}
