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

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import org.finalframework.core.Sortable;

import java.lang.annotation.Annotation;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface QProperty<T> extends Comparable<QProperty<T>>, FunctionCriteriable<Object>, Sortable<Order> {

    <E extends QEntity<?, ?>> E getEntity();

    Class<T> getType();

    Integer getOrder();

    String getPath();

    String getTable();

    String getName();

    @Nullable
    String getWriter();

    @Nullable
    String getReader();

    String getColumn();

    boolean isIdProperty();

    boolean isVersionProperty();

    boolean isReadable();

    boolean isWriteable();

    boolean isModifiable();

    Class<?> getTypeHandler();

    boolean isAnnotationPresent(Class<? extends Annotation> annotation);

    /**
     * Returns whether the property is an array.
     */
    boolean isArray();

    boolean hasView(@Nullable Class<?> view);

    boolean unique();

    boolean nonnull();

    @NonNull
    @Override
    default Criterion condition(@NonNull String expression, @Nullable Object value, @Nullable Consumer<CriterionAttributes> consumer) {
        return CriterionTarget.from(getColumn()).condition(expression, value, consumer);
    }

    @Override
    default Criteriable<Object> apply(@NonNull UnaryOperator<String> column, @Nullable Consumer<CriterionAttributes> consumer) {
        return CriterionTarget.from(getColumn()).apply(column, consumer);
    }

    @Override
    default Order asc() {
        return Order.asc(this.getColumn());
    }

    @Override
    default Order desc() {
        return Order.desc(this.getColumn());
    }

    @Override
    default int compareTo(QProperty<T> o) {
        return Integer.compare(this.getOrder(), o.getOrder());
    }

}
