/*
 * Copyright 2020-2021 the original author or authors.
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
 */

package org.ifinalframework.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * QueryTest.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
class QueryTest {

    @Test
    void defaultQuery() {
        Query query = new Query();
        assertNull(query.getPage());
        assertNull(query.getSize());
        assertEquals(Boolean.TRUE, query.getCount());
        assertNull(query.getOffset());
        assertNull(query.getLimit());

        assertEquals(0, query.getCriteria().size());
        assertEquals(0, query.getGroups().size());
        assertEquals(0, query.getOrders().size());
    }

    @Test
    void pageAndSize() {
        Query query = new Query();

        query.page(2);
        assertEquals(2, query.getPage());
        query.setPage(4);
        assertEquals(4, query.getPage());
        query.setSize(10);
        assertEquals(10, query.getSize());
        query.size(5);
        assertEquals(5, query.getSize());

        query.page(1, 20);
        assertEquals(1, query.getPage());
        assertEquals(20, query.getSize());
    }

    @Test
    void limit() {
        Query query = new Query();

        query.limit(1);
        assertEquals(1, query.getLimit());

        query.limit(2, 10);
        assertEquals(2, query.getOffset());
        assertEquals(10, query.getLimit());

    }

}
