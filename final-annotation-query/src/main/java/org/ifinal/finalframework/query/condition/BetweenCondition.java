package org.ifinal.finalframework.query.condition;

import org.springframework.lang.Nullable;

import org.ifinal.finalframework.query.BetweenValue;
import org.ifinal.finalframework.query.Criterion;
import org.ifinal.finalframework.query.CriterionExpression;

/**
 * BetweenCondition.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BetweenCondition<V> extends Condition {

    default Criterion between(@Nullable V min, @Nullable V max) {
        return condition(CriterionExpression.BETWEEN, new BetweenValue<>(min, max));
    }

    default Criterion notBetween(@Nullable V min, @Nullable V max) {
        return condition(CriterionExpression.NOT_BETWEEN, new BetweenValue<>(min, max));
    }

}
