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

package org.ifinal.finalframework.data.annotation;

import org.ifinal.finalframework.core.IEntity;
import org.ifinal.finalframework.core.IView;
import org.ifinal.finalframework.core.lang.Default;
import org.ifinal.finalframework.core.lang.Transient;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * The build-in base impl of {@linkplain IEntity entity} which have the common property. such as {@link #id}, {@link #version},{@link
 * #created},{@link #lastModified},{@link #yn}.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Setter
@Getter
@Transient
public class AbsEntity implements IEntity<Long> {

    private static final long serialVersionUID = -3500516904657883963L;

    /**
     * 主键，流水号
     */
    @AutoInc
    @PrimaryKey
    @View(IView.class)
    private Long id;

    /**
     * 版本号
     */
    @Version
    @View(IView.class)
    private Long version;

    /**
     * 创建时间
     */
    @Created
    @View(IView.class)
    private LocalDateTime created;

    /**
     * 最后修改时间
     */
    @LastModified
    @View(IView.class)
    private LocalDateTime lastModified;

    /**
     * 有效标记
     */
    @Order(Integer.MAX_VALUE)
    @Default
    @Column
    @View(IView.class)
    private YN yn;

}

    


