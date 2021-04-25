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
import org.springframework.data.annotation.CreatedDate;

import org.ifinal.finalframework.core.lang.Default;
import org.ifinal.finalframework.core.lang.Final;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * Annotate the {@link Field property} is a {@code created} column which is have a {@link Default} value of {@code NOW()} and it is {@link
 * Final} and {@link ReadOnly}.
 *
 * <ul>
 *     <li>define default value with {@code DEFAULT NOW()}.</li>
 *     <li>would not be generated sql when {@code insert} and {@code update}.</li>
 * </ul>
 *
 * @author likly
 * @version 1.0.0
 * @see Column
 * @see Default NOW()
 * @see Final can not update
 * @since 1.0.0
 */
@Column
@Default
@Final
@ReadOnly
@CreatedDate
@Documented
@Order(Integer.MAX_VALUE - 120)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Created {

    @AliasFor(annotation = Column.class)
    String value() default "";

    @AliasFor(annotation = Column.class)
    String name() default "";

}
