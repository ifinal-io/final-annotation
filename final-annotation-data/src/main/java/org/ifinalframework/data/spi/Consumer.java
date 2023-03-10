/*
 * Copyright 2020-2022 the original author or authors.
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

/**
 * PreConsumer.
 *
 * @author ilikly
 * @version 1.4.3
 * @since 1.4.3
 */
@FunctionalInterface
public interface Consumer<T, U> {

    /**
     * @param action   the spi action.
     * @param entities the entities will be deleted, maybe empty.
     * @param user     operator user.
     * @since 1.4.3
     */
    void accept(@NonNull SpiAction action, @NonNull SpiAction.Advice advice, @NonNull List<T> entities, @NonNull U user);

    @FunctionalInterface
    interface ForEach<T, U> extends Consumer<T, U> {
        default void accept(@NonNull SpiAction action, @NonNull SpiAction.Advice advice, @NonNull List<T> entities, @NonNull U user) {
            entities.forEach(item -> accept(action, advice, item, user));
        }

        /**
         * @param action the spi action.
         * @param entity the entity will be deleted.
         * @param user   operator user.
         */
        void accept(@NonNull SpiAction action, @NonNull SpiAction.Advice advice, @NonNull T entity, @NonNull U user);
    }


}
