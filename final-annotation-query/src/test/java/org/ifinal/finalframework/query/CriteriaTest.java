package org.ifinal.finalframework.query;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * CriteriaTest.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
class CriteriaTest {

    @Test
    void and() {
        Criteria criteria = Criteria.and(CriterionTarget.from("name").eq("hah"));
        assertEquals(AndOr.AND, criteria.getAndOr());
        CriterionAttributes criterion = (CriterionAttributes) criteria.get(0);
        assertEquals("name", criterion.getColumn());
        assertEquals(CriterionExpression.EQUAL, criterion.getExpression());
    }

    @Test
    void or() {
        Criteria criteria = Criteria.or(CriterionTarget.from("name").eq("hah"));
        assertEquals(AndOr.OR, criteria.getAndOr());
        CriterionAttributes criterion = (CriterionAttributes) criteria.get(0);
        assertEquals("name", criterion.getColumn());
        assertEquals(CriterionExpression.EQUAL, criterion.getExpression());
    }

}
