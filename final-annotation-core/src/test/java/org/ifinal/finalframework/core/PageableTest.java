package org.ifinal.finalframework.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.Test;

/**
 * PageableTest.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
class PageableTest {

    @Test
    void getCount() {
        Pageable pageable = spy(Pageable.class);
        assertEquals(true, pageable.getCount());
    }

}
