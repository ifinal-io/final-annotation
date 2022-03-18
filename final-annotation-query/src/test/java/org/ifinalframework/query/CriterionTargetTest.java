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

package org.ifinalframework.query;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    // null condition

    @Test
    void isNull() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).isNull();
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(Object.class, criterion.getValue());
        assertEquals(CriterionExpression.IS_NULL, criterion.getExpression());
    }

    @Test
    void isNotNull() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).isNotNull();
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(Object.class, criterion.getValue());
        assertEquals(CriterionExpression.IS_NOT_NULL, criterion.getExpression());
    }

    // compare condition

    @Test
    void eq() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).eq(VALUE);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals("haha", criterion.getValue());
        assertEquals(CriterionExpression.EQUAL, criterion.getExpression());
    }

    @Test
    void neq() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).neq("haha");
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals("haha", criterion.getValue());
        assertEquals(CriterionExpression.NOT_EQUAL, criterion.getExpression());
    }

    @Test
    void gt() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).gt("haha");
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals("haha", criterion.getValue());
        assertEquals(CriterionExpression.GREAT_THAN, criterion.getExpression());
    }

    @Test
    void gte() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).gte("haha");
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals("haha", criterion.getValue());
        assertEquals(CriterionExpression.GREAT_THAN_EQUAL, criterion.getExpression());
    }

    @Test
    void lt() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).lt("haha");
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals("haha", criterion.getValue());
        assertEquals(CriterionExpression.LESS_THAN, criterion.getExpression());
    }

    @Test
    void lte() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).lte("haha");
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals("haha", criterion.getValue());
        assertEquals(CriterionExpression.LESS_THAN_EQUAL, criterion.getExpression());
    }

    @Test
    void before() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).before("haha");
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals("haha", criterion.getValue());
        assertEquals(CriterionExpression.LESS_THAN, criterion.getExpression());
    }

    @Test
    void after() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).after("haha");
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals("haha", criterion.getValue());
        assertEquals(CriterionExpression.GREAT_THAN, criterion.getExpression());
    }

    // between condition

    @Test
    void between() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).between(MIN, MAX);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(BETWEEN_VALUE, criterion.getValue());
        assertEquals(CriterionExpression.BETWEEN, criterion.getExpression());
    }

    @Test
    void notBetween() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).notBetween(MIN, MAX);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(BETWEEN_VALUE, criterion.getValue());
        assertEquals(CriterionExpression.NOT_BETWEEN, criterion.getExpression());
    }

    // contains condition

    @Test
    void in() {

        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).in(IN_VALUE);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(IN_VALUE, criterion.getValue());
        assertEquals(CriterionExpression.IN, criterion.getExpression());
    }

    @Test
    void nin() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).nin(IN_VALUE);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(IN_VALUE, criterion.getValue());
        assertEquals(CriterionExpression.NOT_IN, criterion.getExpression());
    }

    // link condition

    @Test
    void like() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).like(VALUE);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(VALUE, criterion.getValue());
        assertEquals(CriterionExpression.LIKE, criterion.getExpression());
    }

    @Test
    void notLike() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).notLike(VALUE);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(VALUE, criterion.getValue());
        assertEquals(CriterionExpression.NOT_LIKE, criterion.getExpression());
    }

    @Test
    void startWith() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).startWith(VALUE);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(VALUE, criterion.getValue());
        assertEquals(CriterionExpression.STARTS_WITH, criterion.getExpression());
    }

    @Test
    void notStartWith() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).notStartWith(VALUE);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(VALUE, criterion.getValue());
        assertEquals(CriterionExpression.NOT_STARTS_WITH, criterion.getExpression());
    }

    @Test
    void endWith() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).endWith(VALUE);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(VALUE, criterion.getValue());
        assertEquals(CriterionExpression.ENDS_WITH, criterion.getExpression());
    }

    @Test
    void notEndWith() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).notEndWith(VALUE);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(VALUE, criterion.getValue());
        assertEquals(CriterionExpression.NOT_ENDS_WITH, criterion.getExpression());
    }

    @Test
    void contains() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).contains(VALUE);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(VALUE, criterion.getValue());
        assertEquals(CriterionExpression.CONTAINS, criterion.getExpression());
    }

    @Test
    void notContains() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).notContains(VALUE);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(VALUE, criterion.getValue());
        assertEquals(CriterionExpression.NOT_CONTAINS, criterion.getExpression());
    }

    // json condition

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = "path")
    void jsonContains(String path) {
        CriterionAttributes criterion =
            Objects.isNull(path) ?
                (CriterionAttributes) CriterionTarget.from(COLUMN).jsonContains(VALUE)
                : (CriterionAttributes) CriterionTarget.from(COLUMN).jsonContains(VALUE, path);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(path, criterion.get("path"));
        assertEquals(VALUE, criterion.getValue());
        assertEquals(CriterionExpression.JSON_CONTAINS, criterion.getExpression());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = "path")
    void notJsonContains(String path) {
        CriterionAttributes criterion =
            Objects.isNull(path) ?
                (CriterionAttributes) CriterionTarget.from(COLUMN).notJsonContains(VALUE)
                : (CriterionAttributes) CriterionTarget.from(COLUMN).notJsonContains(VALUE, path);
        assertEquals(COLUMN, criterion.getColumn());
        assertEquals(path, criterion.get("path"));
        assertEquals(VALUE, criterion.getValue());
        assertEquals(CriterionExpression.NOT_JSON_CONTAINS, criterion.getExpression());
    }

}
