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

import org.springframework.core.annotation.AliasFor;
import org.springframework.data.annotation.CreatedBy;

import org.ifinal.finalframework.core.IUser;
import org.ifinal.finalframework.core.lang.Final;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotate the {@linkplain java.lang.reflect.Field property} represent the {@linkplain IUser creator} which is
 * {@linkplain Final}.
 *
 * @author likly
 * @version 1.0.0
 * @see Column
 * @see Created
 * @see LastModifier
 * @see LastModified
 * @see IUser
 * @since 1.0.0
 */
@Final
@Column
@Documented
@CreatedBy
@Order(Integer.MAX_VALUE - 130)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Creator {

    @AliasFor(annotation = Column.class)
    String value() default "";

    @AliasFor(annotation = Column.class)
    String name() default "";

}
