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

import org.ifinalframework.velocity.Velocities;

import org.junit.jupiter.api.Test;

/**
 * CriterionExpressionTest.
 *
 * @author likly
 * @version 1.2.1
 * @since 1.2.1
 */
class CriterionExpressionTest {

    @Test
    void isNull() {
        final Criterion criterion = CriterionTarget.from("name").isNull();
        assertEquals("<![CDATA[ AND name IS NULL ]]>", Velocities.getValue(CriterionExpression.IS_NULL, criterion));
    }

    @Test
    void isNotNull() {
        final Criterion criterion = CriterionTarget.from("name").isNotNull();
        assertEquals("<![CDATA[ AND name IS NOT NULL ]]>",
            Velocities.getValue(CriterionExpression.IS_NOT_NULL, criterion));
    }

    @Test
    void eq() {
        final Criterion criterion = CriterionTarget.from("name").eq(null);
        appendValue(criterion);
        assertEquals("<if test=\"value != null\"><![CDATA[ AND name = #{value} ]]></if>",
            Velocities.getValue(CriterionExpression.EQUAL, criterion));
    }

    @Test
    void neq() {
        final Criterion criterion = CriterionTarget.from("name").neq(null);
        appendValue(criterion);
        assertEquals("<if test=\"value != null\"><![CDATA[ AND name != #{value} ]]></if>",
            Velocities.getValue(CriterionExpression.NOT_EQUAL, criterion));
    }

    @Test
    void gt() {
        final Criterion criterion = CriterionTarget.from("name").gt(null);
        appendValue(criterion);
        assertEquals("<if test=\"value != null\"><![CDATA[ AND name > #{value} ]]></if>",
            Velocities.getValue(CriterionExpression.GREAT_THAN, criterion));
    }

    @Test
    void gte() {
        final Criterion criterion = CriterionTarget.from("name").gte(null);
        appendValue(criterion);
        assertEquals("<if test=\"value != null\"><![CDATA[ AND name >= #{value} ]]></if>",
            Velocities.getValue(CriterionExpression.GREAT_THAN_EQUAL, criterion));
    }

    @Test
    void lt() {
        final Criterion criterion = CriterionTarget.from("name").lt(null);
        appendValue(criterion);
        assertEquals("<if test=\"value != null\"><![CDATA[ AND name < #{value} ]]></if>",
            Velocities.getValue(CriterionExpression.LESS_THAN, criterion));
    }

    @Test
    void lte() {
        final Criterion criterion = CriterionTarget.from("name").lte(null);
        appendValue(criterion);
        assertEquals("<if test=\"value != null\"><![CDATA[ AND name <= #{value} ]]></if>",
            Velocities.getValue(CriterionExpression.LESS_THAN_EQUAL, criterion));
    }

    @Test
    void between() {
        final Criterion criterion = CriterionTarget.from("name").between(null, null);
        appendValue(criterion);
        assertEquals(
            "<if test=\"value != null and value.min != null and value.max != null\"><![CDATA[ AND name BETWEEN #{value.min} AND #{value.max} ]]></if>",
            Velocities.getValue(CriterionExpression.BETWEEN, criterion));
    }

    @Test
    void notBetween() {
        final Criterion criterion = CriterionTarget.from("name").between(null, null);
        appendValue(criterion);
        assertEquals(
            "<if test=\"value != null and value.min != null and value.max != null\"><![CDATA[ AND name NOT BETWEEN #{value.min} AND #{value.max} ]]></if>",
            Velocities.getValue(CriterionExpression.NOT_BETWEEN, criterion));
    }

    private void appendValue(Criterion criterion) {
        ((CriterionAttributes) criterion).put("value", "value");
    }

}
