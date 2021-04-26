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

package org.finalframework.data.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.data.annotation.Persistent;

import org.finalframework.core.lang.Transient;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Annotate a property of {@linkplain Field field} or {@linkplain Method method} mapping to a column of data table.
 *
 * @author likly
 * @version 1.0.0
 * @see NameConverter
 * @see Table
 * @see Reference
 * @see Json
 * @see Virtual
 * @see Version
 * @see Created
 * @see Creator
 * @see LastModified
 * @see LastModifier
 * @see Transient
 * @since 1.0.0
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Persistent
public @interface Column {

    /**
     * return the column name of {@code property} mapped.
     *
     * @return column name
     * @see #name()
     */
    @AliasFor("name")
    String value() default "";

    /**
     * @return column name
     * @see #value()
     */
    @AliasFor("value")
    String name() default "";

    /**
     * return the column writer expression
     *
     * <pre class="code">
     *      #{value,javaType=,typeHandler}
     * </pre>
     *
     * @return the column writer
     */
    String writer() default "#{${value}#if($typeHandler)"
        + "#if($javaType), javaType=$!{javaType.canonicalName}#end"
        + ", typeHandler=$!{typeHandler.canonicalName}#end}";

    /**
     * <pre class="code">
     *      column
     * </pre>
     *
     * @return the column reader
     */
    String reader() default "${column}";

    /**
     * return the property java type
     *
     * @return the property java type
     */
    Class<?> javaType() default Object.class;

}
