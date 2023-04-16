/*
 * Copyright 2020-2023 the original author or authors.
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

package org.ifinalframework.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import org.ifinalframework.data.annotation.Metadata;
import org.ifinalframework.data.query.BetweenValue;
import org.ifinalframework.data.query.CriterionAttributes;
import org.ifinalframework.data.query.CriterionExpression;
import org.ifinalframework.data.query.CriterionTarget;
import org.ifinalframework.velocity.Velocities;

/**
 * CriterionTargetTest.
 *
 * @author ilikly
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
class CriterionTargetTest {

    public static final String COLUMN = "name";

    public static final String VALUE = "haha";

    private static final int MIN = 1;

    private static final int MAX = 10;

    private static final BetweenValue<Integer> BETWEEN_VALUE = new BetweenValue<>(MIN, MAX);

    private static final List<Integer> IN_VALUE = Arrays.asList(MIN, MAX);

}
