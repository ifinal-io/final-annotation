package org.ifinal.finalframework.query.condition;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import org.ifinal.finalframework.query.Criterion;
import org.ifinal.finalframework.query.CriterionAttributes;

import java.util.function.Consumer;

/**
 * A {@link Criterion} builder from {@link Condition}.
 *
 * @author likly
 * @version 1.0.0
 * @see CompareCondition
 * @see InCondition
 * @see LikeCondition
 * @see BetweenCondition
 * @since 1.0.0
 */
@FunctionalInterface
public interface Condition {

    @NonNull
    default Criterion condition(@NonNull String expression, @Nullable Object value) {
        return condition(expression, value, null);
    }

    /**
     * @param expression criterion expression
     * @param value      criterion value
     * @param consumer   criterion consumer
     * @return a {@link Criterion} from {@link Condition}.
     */
    @NonNull
    Criterion condition(@NonNull String expression, @Nullable Object value, @Nullable Consumer<CriterionAttributes> consumer);

}
