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
import org.springframework.data.annotation.LastModifiedDate;

import org.ifinal.finalframework.core.lang.Default;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <ul>
 *     <li>define default value with ddl {@code DEFAULT NULL ON UPDATE NOW}.</li>
 *     <li>would not be generated sql when {@code insert} and {@code update}.</li>
 * </ul>
 *
 * @author likly
 * @version 1.0.0
 * @see Created
 * @see LastModifier
 * @see Default DEFAULT NULL ON UPDATE NOW()
 * @since 1.0.0
 */
@Documented
@ReadOnly
@Column
@LastModifiedDate
@Order(Integer.MAX_VALUE - 100)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LastModified {

    @AliasFor(annotation = Column.class, value = "name")
    String value() default "";

    @AliasFor(annotation = Column.class, value = "value")
    String name() default "";

}
