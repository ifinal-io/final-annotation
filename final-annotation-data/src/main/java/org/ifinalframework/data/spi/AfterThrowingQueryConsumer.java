/*
 * Copyright 2020-2023 the original author or authors.
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

package org.ifinalframework.data.spi;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

/**
 * AfterThrowingQueryConsumer.
 *
 * @author ilikly
 * @version 1.4.3
 * @since 1.4.3
 */
public interface AfterThrowingQueryConsumer<T, Q, U> {

    default void accept(@Nullable List<T> entities, @NonNull Q query, @NonNull U user, @NonNull Throwable e) {
        if (CollectionUtils.isEmpty(entities)) {
            accept((T) null, query, user, e);
        } else {
            entities.forEach(item -> accept(item, query, user, e));
        }
    }

    void accept(@Nullable T entity, @NonNull Q query, @NonNull U user, @NonNull Throwable e);
}
