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

import lombok.Getter;

/**
 * SpiAction.
 *
 * @author ilikly
 * @version 1.4.3
 * @since 1.4.3
 */
@Getter
public enum SpiAction {
    CREATE("Insert"),
    PRE_CREATE("PreInsert"),
    POST_CREATE("PostInsert"),
    PRE_DELETE("PreDelete"),
    POST_DELETE("PostDelete"),
    PRE_UPDATE("PreUpdate"),
    POST_UPDATE("PostUpdate"),
    PRE_YN("PreUpdateYn"),
    POST_YN("PostUpdateYn"),
    PRE_STATUS("PreUpdateStatus"),
    POST_STATUS("PostUpdateStatus"),

    LIST("List","Query"),
    PRE_LIST("PreList", "PreQuery"),
    POST_LIST("PostList", "PostQuery"),

    DETAIL("Detail","Query"),
    PRE_DETAIL("PreDetail", "PreQuery"),
    POST_DETAIL("PostDetail", "PostQuery"),
    PRE_COUNT("PreCountQuery");

    private final String[] values;

    SpiAction(String... values) {
        this.values = values;
    }
}
