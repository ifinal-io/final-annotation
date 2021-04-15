package org.ifinal.finalframework.query.function;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ifinal.finalframework.query.CriterionAttributes;
import org.ifinal.finalframework.query.CriterionExpression;
import org.ifinal.finalframework.query.CriterionTarget;

import org.junit.jupiter.api.Test;

/**
 * DateFunctionTest.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
class DateFunctionTest {

    private static final String COLUMN = "name";

    @Test
    void date() {
        CriterionAttributes criterion = (CriterionAttributes) CriterionTarget.from(COLUMN).date().eq(2);
        assertEquals(2, criterion.getValue());
        assertEquals(CriterionExpression.EQUAL, criterion.getExpression());
    }

}
