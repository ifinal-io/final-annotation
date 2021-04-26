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

package org.finalframework.query;

import java.io.Serializable;
import java.util.stream.Stream;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface QEntity<I extends Serializable, T> extends Iterable<QProperty<?>> {

    Class<T> getType();

    default String getName() {
        return getType().getName();
    }

    default String getSimpleName() {
        return getType().getSimpleName();
    }

    String getTable();

    QProperty<I> getIdProperty();

    <E> QProperty<E> getVersionProperty();

    default boolean hasVersionProperty() {
        return getVersionProperty() != null;
    }

    <E> QProperty<E> getProperty(String path);

    default <E> QProperty<E> getRequiredProperty(String path) {
        QProperty<E> property = getProperty(path);

        if (property != null) {
            return property;
        }

        throw new IllegalStateException(String.format("Required property of %s not found for %s!", path, getType()));
    }

    Stream<QProperty<?>> stream();

}
