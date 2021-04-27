/*
 * Copyright 2020-2021 the original author or authors.
 *
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
 *
 */

package org.ifinalframework.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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

        Mockito.when(result.getStatus()).thenReturn(ResponseStatus.SUCCESS.getCode());
        Assertions.assertTrue(result.isSuccess());

    }

    @Test
    void should_not_hasMore_when_pagination_is_null() {
        Mockito.when(result.getPagination()).thenReturn(null);
        Assertions.assertFalse(result.hasMore());
    }

    @Test
    void should_hasMore_when_pagination_is_not_lastPage() {

        Mockito.when(pagination.getLastPage()).thenReturn(null);
        Mockito.when(result.getPagination()).thenReturn(pagination);
        Assertions.assertTrue(result.hasMore());

    }

    @Test
    void should_not_hasMore_when_pagination_is_lastPage() {
        Mockito.when(pagination.getLastPage()).thenReturn(true);
        Mockito.when(result.getPagination()).thenReturn(pagination);
        Assertions.assertFalse(result.hasMore());
    }

}
