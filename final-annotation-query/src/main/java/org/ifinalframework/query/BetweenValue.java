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

package org.ifinalframework.query;

import org.springframework.lang.Nullable;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ifinalframework.query.annotation.Between;
import org.ifinalframework.query.annotation.NotBetween;
import org.ifinalframework.query.condition.BetweenCondition;

/**
 * The value holder which have one {@code min} value and {@code max} value for {@code between} value.
 *
 * @author likly
 *
 * @version 1.0.0
 * @see Between
 * @see NotBetween
 * @see BetweenCondition
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class BetweenValue<T> implements Serializable {

    private static final long serialVersionUID = 6194662646358531082L;

    @Nullable
    private T min;

    @Nullable
    private T max;

}

