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
import lombok.RequiredArgsConstructor;

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
    DELETE("Delete"),
    UPDATE("Update"),
    UPDATE_YN("UpdateYn"),
    UPDATE_LOCKED("UpdateLocked"),
    UPDATE_STATUS("UpdateStatus"),
    UPDATE_AUDIT_STATUS("UpdateAuditStatus"),
    LIST("List", "Query"),

    DETAIL("Detail", "Query"),
    COUNT("CountQuery", "Query");

    private final String[] values;

    SpiAction(String... values) {
        this.values = values;
    }

    @RequiredArgsConstructor
    @Getter
    public enum Advice {
        PRE("Pre"), POST("Post"),AFTER("After"), AFTER_THROWING("AfterThrowing"), AFTER_RETURNING("AfterReturning");

        private final String value;

    }
}
