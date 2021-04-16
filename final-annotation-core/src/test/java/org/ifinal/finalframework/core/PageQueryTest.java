package org.ifinal.finalframework.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * PageQueryTest.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
class PageQueryTest {

    @Test
    void defaultPageable() {
        Pageable query = new PageQuery();
        assertEquals(1, query.getPage());
        assertEquals(20, query.getSize());
        assertEquals(true, query.getCount());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {-1, 10, 100})
    void page(Integer page) {
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPage(page);

        if (Objects.isNull(page)) {
            assertNull(pageQuery.getPage());
        } else if (page < 1) {
            assertEquals(1, pageQuery.getPage());
        } else {
            assertEquals(page, pageQuery.getPage());
        }

    }

    @ParameterizedTest
    @NullSource
    @ValueSource(longs = {-1L, 10L, 100L})
    void limitable(Long offsetOrLimit) {
        PageQuery limitable = new PageQuery();
        limitable.setOffset(offsetOrLimit);
        limitable.setLimit(offsetOrLimit);

        assertEquals(offsetOrLimit, limitable.getOffset());
        assertEquals(offsetOrLimit, limitable.getLimit());

    }

}
