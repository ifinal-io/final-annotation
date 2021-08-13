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

package org.ifinalframework.core;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * IRepository.
 *
 * @author likly
 * @version 1.2.2
 * @since 1.2.2
 */
public interface IRepository<I extends Serializable, T extends IEntity<I>> {

    int insert(Map<String, Object> params);

    int replace(Map<String, Object> params);

    int save(Map<String, Object> params);

    int update(Map<String, Object> params);

    int delete(Map<String, Object> params);

    List<T> select(Map<String, Object> params);

    List<I> selectIds(Map<String, Object> params);

    T selectOne(Map<String, Object> params);

    long selectCount(Map<String, Object> params);

    void truncate(Map<String, Object> params);


}
