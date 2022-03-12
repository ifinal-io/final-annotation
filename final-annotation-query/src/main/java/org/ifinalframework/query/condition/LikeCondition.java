/*
 * Copyright 2020-2021 the original author or authors.
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
 */

package org.ifinalframework.query.condition;

import org.springframework.lang.Nullable;

import org.ifinalframework.query.Criterion;
import org.ifinalframework.query.CriterionExpression;

/**
 * LikeCondition.
 *
 * @author likly
 * @version 1.0.0
 * @see org.ifinalframework.query.annotation.Like
 * @see org.ifinalframework.query.annotation.NotLike
 * @see org.ifinalframework.query.annotation.StartsWith
 * @see org.ifinalframework.query.annotation.NotStartsWith
 * @see org.ifinalframework.query.annotation.EndsWith
 * @see org.ifinalframework.query.annotation.NotEndsWith
 * @see org.ifinalframework.query.annotation.Contains
 * @see org.ifinalframework.query.annotation.NotContains
 * @since 1.0.0
 */
public interface LikeCondition extends Condition {

    /**
     * @param value value
     * @return criterion
     * @see org.ifinalframework.query.annotation.StartsWith
     * @since 1.2.1
     */
    default Criterion startsWith(@Nullable String value) {
        return condition(CriterionExpression.STARTS_WITH, value);
    }

    /**
     * @param value value
     * @return criterion
     * @see org.ifinalframework.query.annotation.NotStartsWith
     * @since 1.2.1
     */
    default Criterion notStartsWith(@Nullable String value) {
        return condition(CriterionExpression.NOT_STARTS_WITH, value);
    }

    /**
     * @param value value
     * @return criterion
     * @see org.ifinalframework.query.annotation.EndsWith
     * @since 1.2.1
     */
    default Criterion endsWith(@Nullable String value) {
        return condition(CriterionExpression.ENDS_WITH, value);
    }

    /**
     * @param value value
     * @return criterion
     * @see org.ifinalframework.query.annotation.NotEndsWith
     * @since 1.2.1
     */
    default Criterion notEndsWith(@Nullable String value) {
        return condition(CriterionExpression.NOT_ENDS_WITH, value);
    }

    /**
     * @see #startsWith(String)
     * @deprecated rename to {@code startsWith} since 1.2.1
     */
    @Deprecated
    default Criterion startWith(@Nullable String value) {
        return startsWith(value);
    }

    /**
     * @param value value
     * @return criterion
     * @see #notStartsWith(String)
     * @deprecated rename to {@code notStartsWith} since 1.2.1
     */
    @Deprecated
    default Criterion notStartWith(@Nullable String value) {
        return notStartsWith(value);
    }

    /**
     * @param value value
     * @return criterion
     * @see #endsWith(String)
     * @deprecated rename to {@code endsWith} since 1.2.1
     */
    @Deprecated
    default Criterion endWith(@Nullable String value) {
        return endsWith(value);
    }

    /**
     * @param value value
     * @return criterion
     * @see #notEndsWith(String)
     * @deprecated rename to {@code notEndsWith} since 1.2.1
     */
    @Deprecated
    default Criterion notEndWith(@Nullable String value) {
        return notEndsWith(value);
    }

    /**
     * @param value value
     * @return criterion
     */
    default Criterion contains(@Nullable String value) {
        return condition(CriterionExpression.CONTAINS, value);
    }

    /**
     *
     * @param value value
     * @return criterion
     */
    default Criterion notContains(@Nullable String value) {
        return condition(CriterionExpression.NOT_CONTAINS, value);
    }

    /**
     * @param value value
     * @return criterion
     */
    default Criterion like(@Nullable String value) {
        return condition(CriterionExpression.LIKE, value);
    }
    /**
     * @param value value
     * @return criterion
     */
    default Criterion notLike(@Nullable String value) {
        return condition(CriterionExpression.NOT_LIKE, value);
    }

}
