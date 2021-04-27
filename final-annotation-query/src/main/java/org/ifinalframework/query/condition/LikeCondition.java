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

package org.ifinalframework.query.condition;

import org.springframework.lang.Nullable;

import org.ifinalframework.query.Criterion;
import org.ifinalframework.query.CriterionExpression;

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
