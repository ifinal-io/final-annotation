package org.ifinal.finalframework.query.condition;

import org.springframework.lang.Nullable;

import org.ifinal.finalframework.query.Criterion;
import org.ifinal.finalframework.query.CriterionExpression;

/**
 * JsonCondition.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface JsonCondition<V> extends Condition {

    default Criterion jsonContaions(@Nullable V value) {
        return jsonContains(value, null);
    }

    default Criterion jsonContains(@Nullable V value, @Nullable String path) {
        return condition(CriterionExpression.JSON_CONTAINS, value, criterionAttributes -> criterionAttributes.put("path", path));
    }

    default Criterion notJsonContaions(@Nullable V value) {
        return jsonContains(value, null);
    }

    default Criterion notJsonContaions(@Nullable V value, @Nullable String path) {
        return condition(CriterionExpression.NOT_JSON_CONTAINS, value, criterionAttributes -> criterionAttributes.put("path", path));
    }

}
