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

package org.ifinalframework.query.expression.velocity.criterion;

import org.springframework.lang.NonNull;

import org.ifinalframework.query.CriterionExpression;
import org.ifinalframework.query.Expression;

/**
 * IsNullExpression.
 *
 * @author likly
 * @version 1.2.1
 * @see org.ifinalframework.query.annotation.IsNull
 * @since 1.2.1
 */
public class IsNullExpression implements Expression {

    @NonNull
    @Override
    public String key() {
        return IS_NULL;
    }

    @NonNull
    @Override
    public String value() {
        return CriterionExpression.IS_NULL;
    }

}
