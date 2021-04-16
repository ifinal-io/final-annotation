package org.ifinal.finalframework.query;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import org.ifinal.finalframework.core.Sortable;

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
