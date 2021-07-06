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

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import org.ifinalframework.query.Criterion;
import org.ifinalframework.query.CriterionExpression;

import java.util.Collection;

/**
 * JsonCondition.
 *
 * @author likly
 * @version 1.0.0
 * @see org.ifinalframework.query.annotation.JsonContains
 * @see org.ifinalframework.query.annotation.NotJsonContains
 * @since 1.0.0
 */
public interface JsonCondition<V> extends Condition {

    /**
     * @param value value
     * @return criterion
     * @see #jsonContains(Object, String)
     */
    default Criterion jsonContains(@Nullable V value) {
        return jsonContains(value, null);
    }

    /**
     * @param value value
     * @param path  path
     * @return criterion
     * @see org.ifinalframework.query.annotation.JsonContains
     */
    default Criterion jsonContains(@Nullable V value, @Nullable String path) {
        return condition(CriterionExpression.JSON_CONTAINS, value,
            criterionAttributes -> criterionAttributes.put("path", path));
    }

    default Criterion notJsonContains(@Nullable V value) {
        return notJsonContains(value, null);
    }

    /**
     * @param value value
     * @param path  path
     * @return criterion
     * @see org.ifinalframework.query.annotation.NotJsonContains
     */
    default Criterion notJsonContains(@Nullable V value, @Nullable String path) {
        return condition(CriterionExpression.NOT_JSON_CONTAINS, value,
            criterionAttributes -> criterionAttributes.put("path", path));
    }

    /**
     * JSON_CONTAINS_PATH(doc,'oneOrAll',path[,path ...])
     *
     * @param oneOrAll one or all, required not null
     * @param paths    paths, requited not empty
     * @return json contains path criterion
     */
    default Criterion jsonContainsPath(@NonNull String oneOrAll, Collection<String> paths) {
        return condition(CriterionExpression.JSON_CONTAINS_PATH, paths,
            criterionAttributes -> criterionAttributes.put("oneOrAll", oneOrAll));
    }

}
