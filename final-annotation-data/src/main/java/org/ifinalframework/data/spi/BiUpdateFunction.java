/*
 * Copyright 2020-2023 the original author or authors.
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

package org.ifinalframework.data.spi;

import java.util.List;

/**
 * BiUpdateFunction
 *
 * @author mik
 * @see UpdateFunction
 * @since 1.5.2
 **/
public interface BiUpdateFunction<T, P1, P2, V, U> {
    /**
     * Update or delete something with param and value by user.
     *
     * @param entities will update and delete entities.
     * @param param1   update or delete param, maybe null.
     * @param param2   update or delete param, maybe null.
     * @param value    update value.
     * @param user     operator user.
     * @return update or delete rows.
     */
    Integer update(List<T> entities, P1 param1, P2 param2, V value, U user);
}