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
 * JsonCondition.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface JsonCondition<V> extends Condition {

    default Criterion jsonContains(@Nullable V value) {
        return jsonContains(value, null);
    }

    default Criterion jsonContains(@Nullable V value, @Nullable String path) {
        return condition(CriterionExpression.JSON_CONTAINS, value, criterionAttributes -> criterionAttributes.put("path", path));
    }

    default Criterion notJsonContains(@Nullable V value) {
        return notJsonContains(value, null);
    }

    default Criterion notJsonContains(@Nullable V value, @Nullable String path) {
        return condition(CriterionExpression.NOT_JSON_CONTAINS, value, criterionAttributes -> criterionAttributes.put("path", path));
    }

}
