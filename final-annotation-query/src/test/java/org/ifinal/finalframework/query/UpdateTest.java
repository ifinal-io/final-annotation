package org.ifinal.finalframework.query;

import static org.mockito.Mockito.when;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * UpdateTest.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@ExtendWith(MockitoExtension.class)
class UpdateTest {

    private static final String COLUMN = "name";

    @Mock
    private QProperty<?> property;

    @BeforeEach
    void beforeEach() {
        when(property.getColumn()).thenReturn(COLUMN);
    }

    @Test
    void set() {

        String value = "haha";
        Update update = Update.update().set(property, value);

        Criterion criterion = update.get(0);

        Assertions.assertTrue(criterion instanceof CriterionAttributes);

        CriterionAttributes attributes = (CriterionAttributes) criterion;

        Assertions.assertEquals(COLUMN, attributes.getColumn());
        Assertions.assertEquals(value, attributes.getValue());
        Assertions.assertEquals(CriterionExpression.UPDATE_SET, attributes.getExpression());

        logger.info(attributes.getExpression());

    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {2, 4})
    void incr(Integer value) {

        Update update = Update.update();

        if (Objects.isNull(value)) {
            update.inc(property);
        } else {
            update.incr(property, value);
        }

        Criterion criterion = update.get(0);

        Assertions.assertTrue(criterion instanceof CriterionAttributes);

        CriterionAttributes attributes = (CriterionAttributes) criterion;

        Assertions.assertEquals(COLUMN, attributes.getColumn());
        if (Objects.isNull(value)) {
            Assertions.assertEquals(1, attributes.getValue());
        } else {
            Assertions.assertEquals(value, attributes.getValue());
        }
        Assertions.assertEquals(CriterionExpression.UPDATE_INCR, attributes.getExpression());

        logger.info(attributes.getExpression());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {2, 4})
    void decr(Integer value) {

        Update update = Update.update();

        if (Objects.isNull(value)) {
            update.dec(property);
        } else {
            update.decr(property, value);
        }

        Criterion criterion = update.get(0);

        Assertions.assertTrue(criterion instanceof CriterionAttributes);

        CriterionAttributes attributes = (CriterionAttributes) criterion;

        Assertions.assertEquals(COLUMN, attributes.getColumn());
        if (Objects.isNull(value)) {
            Assertions.assertEquals(1, attributes.getValue());
        } else {
            Assertions.assertEquals(value, attributes.getValue());
        }
        Assertions.assertEquals(CriterionExpression.UPDATE_DECR, attributes.getExpression());

        logger.info(attributes.getExpression());
    }

}
