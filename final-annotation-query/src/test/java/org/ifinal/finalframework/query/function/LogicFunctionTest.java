package org.ifinal.finalframework.query.function;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ifinal.finalframework.query.CriterionAttributes;
import org.ifinal.finalframework.query.CriterionExpression;
import org.ifinal.finalframework.query.CriterionTarget;

import org.junit.jupiter.api.Test;

/**
 * LogicFunctionTest.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
class LogicFunctionTest {

    private static final String COLUMN = "name";

    private static final String LOGIC_VALUE = "logicValue";

    @Test
    void and() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).and(2).eq(2);
        assertEquals(2, criterion.getValue());
        assertEquals(2, criterion.get(LOGIC_VALUE));
        assertEquals(CriterionExpression.EQUAL, criterion.getExpression());
    }

    @Test
    void or() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).or(2).eq(2);
        assertEquals(2, criterion.getValue());
        assertEquals(2, criterion.get(LOGIC_VALUE));
        assertEquals(CriterionExpression.EQUAL, criterion.getExpression());
    }

}
