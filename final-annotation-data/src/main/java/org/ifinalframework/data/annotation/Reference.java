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

package org.ifinalframework.data.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

import org.springframework.core.annotation.AliasFor;

import org.ifinalframework.core.IEntity;

/**
 * Annotate the {@linkplain Field property} is a {@literal reference} column which mapping multi columns in datasource,
 * and the {@linkplain Class type} of this {@linkplain Field property} must {@literal implements} the {@link IEntity
 * entity} interface.
 *
 * @author ilikly
 * @version 1.0.0
 * @see IEntity
 * @since 1.0.0
 */
@Column
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@org.springframework.data.annotation.Reference
public @interface Reference {

    @AliasFor(annotation = Column.class)
    String value() default "";

    @AliasFor(annotation = Column.class)
    String name() default "";

    ReferenceMode mode() default ReferenceMode.SIMPLE;

    String[] properties();

    /**
     * @return
     * @since 1.4.0
     */
    Column[] columns() default {};

    String delimiter() default ":";

}
