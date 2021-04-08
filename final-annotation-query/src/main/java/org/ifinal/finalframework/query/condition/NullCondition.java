package org.ifinal.finalframework.query.condition;

import org.ifinal.finalframework.query.Criterion;
import org.ifinal.finalframework.query.CriterionExpression;

/**
 * NullCondition.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface NullCondition extends Condition {

    default Criterion isNull() {
        return condition(CriterionExpression.IS_NULL, Object.class);
    }

    default Criterion isNotNull() {
        return condition(CriterionExpression.IS_NOT_NULL, Object.class);
    }

}
