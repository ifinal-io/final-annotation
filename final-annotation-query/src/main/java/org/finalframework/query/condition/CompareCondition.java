/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.finalframework.query.condition;

import org.springframework.lang.Nullable;

import org.finalframework.query.Criterion;
import org.finalframework.query.CriterionExpression;

/**
 * CompareCondition.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CompareCondition<V> extends Condition {

    /**
     * Build a {@code eq} criterion for {@code column = #{value}}.
     *
     * @param value value.
     * @return a {@code eq} criterion.
     */
    default Criterion eq(@Nullable V value) {
        return condition(CriterionExpression.EQUAL, value);
    }

    /**
     * Build a {@code neq} criterion for {@code column != #{value}}.
     *
     * @param value value.
     * @return a {@code neq} criterion.
     */
    default Criterion neq(@Nullable V value) {
        return condition(CriterionExpression.NOT_EQUAL, value);
    }

    /**
     * Build a {@code gt} criterion for {@code column > #{value}}.
     *
     * @param value value.
     * @return a {@code gt} criterion.
     */
    default Criterion gt(@Nullable V value) {
        return condition(CriterionExpression.GREAT_THAN, value);
    }

    /**
     * Build a {@code gte} criterion for {@code column >= #{value}}.
     *
     * @param value value.
     * @return a {@code gte} criterion.
     */
    default Criterion gte(@Nullable V value) {
        return condition(CriterionExpression.GREAT_THAN_EQUAL, value);
    }

    /**
     * Build a {@code lt} criterion for {@code column < #{value}}.
     *
     * @param value value
     * @return a {@code lt} criterion.
     */
    default Criterion lt(@Nullable V value) {
        return condition(CriterionExpression.LESS_THAN, value);
    }

    /**
     * Build a {@code lte} criterion for {@code column <= #{value}}.
     *
     * @param value value.
     * @return a {@code lte} criterion.
     */
    default Criterion lte(@Nullable V value) {
        return condition(CriterionExpression.LESS_THAN_EQUAL, value);
    }

    /**
     * Build a {@link Criterion} like {@link #lt(Object)}
     *
     * @param value value.
     * @return a criterion.
     * @see #lt(Object)
     */
    default Criterion before(@Nullable V value) {
        return lt(value);
    }

    /**
     * Build a {@link Criterion} like {@link #gt(Object)}
     *
     * @param value value.
     * @return a criterion.
     * @see #gt(Object)
     */
    default Criterion after(@Nullable V value) {
        return gt(value);
    }

}
