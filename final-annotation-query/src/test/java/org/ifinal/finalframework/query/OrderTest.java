package org.ifinal.finalframework.query;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * OrderTest.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
class OrderTest {

    @Test
    void testToString() {

        assertEquals("name ASC", Order.asc("name").toString());
        assertEquals("name DESC", Order.desc("name").toString());
    }

}
