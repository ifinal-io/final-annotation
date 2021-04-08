package org.ifinal.finalframework.query;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * CriterionTarget.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public class CriterionTarget implements FunctionCriteriable<Object> {

    private String column;

    private final CriterionAttributes criterion;

    private CriterionTarget(final String column) {
        this.column = column;
        this.criterion = new CriterionAttributes();
    }

    public static CriterionTarget from(String column) {
        return new CriterionTarget(column);
    }

    @Override
    public Criterion condition(@NonNull final String expression, @Nullable final Object value,
        @Nullable final Consumer<CriterionAttributes> consumer) {

        criterion.setExpression(expression);
        criterion.setColumn(column);
        criterion.setValue(value);

        if (Objects.nonNull(consumer)) {
            consumer.accept(criterion);
        }

        return criterion;
    }

    @Override
    public Criteriable<Object> apply(@NonNull final UnaryOperator<String> column,
        @Nullable final Consumer<CriterionAttributes> consumer) {

        this.column = column.apply(this.column);

        if (Objects.nonNull(consumer)) {
            consumer.accept(criterion);
        }

        return this;
    }

}
