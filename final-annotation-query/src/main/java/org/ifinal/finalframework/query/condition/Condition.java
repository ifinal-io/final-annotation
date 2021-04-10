package org.ifinal.finalframework.query.condition;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import org.ifinal.finalframework.query.Criterion;
import org.ifinal.finalframework.query.CriterionAttributes;

import java.util.function.Consumer;

/**
 * Condition.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface Condition {

    default Criterion condition(@NonNull String expression, @Nullable Object value) {
        return condition(expression, value, null);
    }

    Criterion condition(@NonNull String expression, @Nullable Object value, @Nullable Consumer<CriterionAttributes> consumer);

}
