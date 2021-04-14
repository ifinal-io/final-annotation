package org.ifinal.finalframework.query.condition;

import org.springframework.lang.Nullable;

import org.ifinal.finalframework.query.Criterion;
import org.ifinal.finalframework.query.CriterionExpression;

import java.util.Collection;

/**
 * InCondition.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface InCondition extends Condition {

    default Criterion in(@Nullable Collection<?> value) {
        return condition(CriterionExpression.IN, value);
    }

    default Criterion nin(@Nullable Collection<?> value) {
        return condition(CriterionExpression.NOT_IN, value);
    }

}
