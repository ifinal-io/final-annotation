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
import java.util.List;
import java.util.Map;

/**
 * IRepository.
 *
 * @author likly
 * @version 1.2.2
 * @see ParamsBuilder
 * @since 1.2.2
 */
public interface IRepository<I extends Serializable, T extends IEntity<I>> {

    int insert(@NonNull Map<String, Object> params);

    int replace(@NonNull Map<String, Object> params);

    int save(@NonNull Map<String, Object> params);

    int update(@NonNull Map<String, Object> params);

    int delete(@NonNull Map<String, Object> params);

    @Nullable
    List<T> select(@NonNull Map<String, Object> params);

    @Nullable
    List<I> selectIds(@NonNull Map<String, Object> params);

    T selectOne(@NonNull Map<String, Object> params);

    long selectCount(@NonNull Map<String, Object> params);

    void truncate(@NonNull Map<String, Object> params);


}
