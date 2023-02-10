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

/**
 * @author ilikly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface QueryProvider {

    /**
     * return sql of where
     *
     * @return sql of where
     */
    String where();

    /**
     * return sql of group
     *
     * @return sql of group
     * @see org.ifinalframework.core.Groupable
     */
    String groups();

    /**
     * return sql of order
     *
     * @return sql of order
     * @see org.ifinalframework.core.Orderable
     */
    String orders();

    /**
     * return sql of limit
     *
     * @return sql of limit
     * @see org.ifinalframework.core.Limitable
     */
    String limit();

}
