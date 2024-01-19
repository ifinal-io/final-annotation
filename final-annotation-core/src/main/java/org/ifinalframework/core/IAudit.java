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

package org.ifinalframework.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * IAudit.
 *
 * @author iimik
 * @version 1.5.1
 * @since 1.5.1
 */
public interface IAudit<T extends IUser<?>> {
    void setAuditStatus(AuditStatus status);

    AuditStatus getAuditStatus();

    void setAuditContent(String auditContent);

    String getAuditContent();

    void setAuditDateTime(LocalDateTime auditDateTime);

    LocalDateTime getAuditDateTime();

    void setAuditor(T auditor);

    T getAuditor();

    @Getter
    @RequiredArgsConstructor
    enum AuditStatus implements IEnum<Integer> {
        NONE(0, "无"),
        PENDING(10, "待审核"),
        CANCELED(21, "已取消"),
        AUDITED(22, "已审核"),
        REJECTED(23, "驳回"),
        ;
        private final Integer code;
        private final String desc;

    }

}
