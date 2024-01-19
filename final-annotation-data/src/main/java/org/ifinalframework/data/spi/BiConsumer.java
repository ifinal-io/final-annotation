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

/**
 * BiConsumer.
 *
 * @author iimik
 * @version 1.5.0
 * @since 1.5.0
 */
public interface BiConsumer<T, V, U> {
    void accept(@NonNull SpiAction action, @NonNull SpiAction.Advice advice, @NonNull List<T> entities, @Nullable V value, @NonNull U user);

    @FunctionalInterface
    interface ForEach<T, V, U> extends BiConsumer<T, V, U> {
        @Override
        default void accept(@NonNull SpiAction action, @NonNull SpiAction.Advice advice, @NonNull List<T> entities, @Nullable V value, @NonNull U user) {
            entities.forEach(item -> accept(action, advice, item, value, user));
        }

        void accept(@NonNull SpiAction action, @NonNull SpiAction.Advice advice, @NonNull T entity, @Nullable V value, @NonNull U user);
    }

}