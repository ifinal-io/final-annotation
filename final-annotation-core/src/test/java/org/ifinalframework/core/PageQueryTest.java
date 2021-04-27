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

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals(1, query.getPage());
        Assertions.assertEquals(20, query.getSize());
        Assertions.assertEquals(true, query.getCount());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {-1, 10, 100})
    void page(Integer page) {
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPage(page);

        if (Objects.isNull(page)) {
            Assertions.assertNull(pageQuery.getPage());
        } else if (page < 1) {
            Assertions.assertEquals(1, pageQuery.getPage());
        } else {
            Assertions.assertEquals(page, pageQuery.getPage());
        }

    }

    @ParameterizedTest
    @NullSource
    @ValueSource(longs = {-1L, 10L, 100L})
    void limitable(Long offsetOrLimit) {
        PageQuery limitable = new PageQuery();
        limitable.setOffset(offsetOrLimit);
        limitable.setLimit(offsetOrLimit);

        Assertions.assertEquals(offsetOrLimit, limitable.getOffset());
        Assertions.assertEquals(offsetOrLimit, limitable.getLimit());

    }

}
