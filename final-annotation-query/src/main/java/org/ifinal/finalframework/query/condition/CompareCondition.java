package org.ifinal.finalframework.query.condition;

import org.springframework.lang.Nullable;

import org.ifinal.finalframework.query.Criterion;
import org.ifinal.finalframework.query.CriterionExpression;

/**
 * CompareCondition.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CompareCondition<V> extends Condition {

    default Criterion eq(@Nullable V value) {
        return condition(CriterionExpression.EQUAL, value);
    }

    default Criterion neq(@Nullable V value) {
        return condition(CriterionExpression.NOT_EQUAL, value);
    }

    default Criterion gt(@Nullable V value) {
        return condition(CriterionExpression.GREAT_THAN, value);
    }

    default Criterion gte(@Nullable V value) {
        return condition(CriterionExpression.GREAT_THAN_EQUAL, value);
    }

    default Criterion lt(@Nullable V value) {
        return condition(CriterionExpression.LESS_THAN, value);
    }

    default Criterion lte(@Nullable V value) {
        return condition(CriterionExpression.LESS_THAN_EQUAL, value);
    }

    default Criterion before(@Nullable V value) {
        return lt(value);
    }

    default Criterion after(@Nullable V value) {
        return gt(value);
    }

}
