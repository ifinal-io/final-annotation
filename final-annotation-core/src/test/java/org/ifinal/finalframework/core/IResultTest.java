package org.ifinal.finalframework.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * IResultTest.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class IResultTest {

    @Spy
    private IResult<?> result;

    @Mock
    private IPagination pagination;

    @Test
    void isSuccess() {

        when(result.getStatus()).thenReturn(ResponseStatus.SUCCESS.getCode());
        assertTrue(result.isSuccess());

    }

    @Test
    void should_not_hasMore_when_pagination_is_null() {
        when(result.getPagination()).thenReturn(null);
        assertFalse(result.hasMore());
    }

    @Test
    void should_hasMore_when_pagination_is_not_lastPage() {

        when(pagination.getLastPage()).thenReturn(null);
        when(result.getPagination()).thenReturn(pagination);
        assertTrue(result.hasMore());

    }

    @Test
    void should_not_hasMore_when_pagination_is_lastPage() {
        when(pagination.getLastPage()).thenReturn(true);
        when(result.getPagination()).thenReturn(pagination);
        assertFalse(result.hasMore());
    }

}
