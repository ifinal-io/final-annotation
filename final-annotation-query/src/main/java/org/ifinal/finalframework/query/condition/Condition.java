package org.ifinal.finalframework.query.condition;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import org.ifinal.finalframework.query.Criterion;
import org.ifinal.finalframework.query.CriterionAttributes;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Condition.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Condition {

    default Criterion condition(@NonNull String expression, @Nullable Object value) {
        return condition(expression, value, null);
    }

    Criterion condition(@NonNull String expression, @Nullable Object value, @Nullable Consumer<CriterionAttributes> consumer);

    default Criterion condition(@NonNull String expression, @NonNull Supplier<String> column, @Nullable Object value,
        @Nullable Consumer<CriterionAttributes> consumer) {
        return condition(expression, column.get(), value, consumer);
    }

    default Criterion condition(@NonNull String expression, @NonNull String column, @Nullable Object value,
        @Nullable Consumer<CriterionAttributes> consumer) {
        CriterionAttributes criterion = CriterionAttributes.builder(expression)
            .column(column)
            .value(value)
            .build();

        if (Objects.nonNull(consumer)) {
            consumer.accept(criterion);
        }

        return criterion;
    }

}
