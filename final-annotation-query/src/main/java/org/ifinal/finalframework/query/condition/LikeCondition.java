package org.ifinal.finalframework.query.condition;

import org.springframework.lang.Nullable;

import org.ifinal.finalframework.query.Criterion;
import org.ifinal.finalframework.query.CriterionExpression;

/**
 * LikeCondition.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface LikeCondition extends Condition {

    default Criterion startWith(@Nullable String value) {
        return condition(CriterionExpression.START_WITH, value);
    }

    default Criterion notStartWith(@Nullable String value) {
        return condition(CriterionExpression.NOT_START_WITH, value);
    }

    default Criterion endWith(@Nullable String value) {
        return condition(CriterionExpression.END_WITH, value);
    }

    default Criterion notEndWith(@Nullable String value) {
        return condition(CriterionExpression.NOT_END_WITH, value);
    }

    default Criterion contains(@Nullable String value) {
        return condition(CriterionExpression.CONTAINS, value);
    }

    default Criterion notContains(@Nullable String value) {
        return condition(CriterionExpression.NOT_CONTAINS, value);
    }

    default Criterion like(@Nullable String value) {
        return condition(CriterionExpression.LIKE, value);
    }

    default Criterion notLike(@Nullable String value) {
        return condition(CriterionExpression.NOT_LIKE, value);
    }

}
