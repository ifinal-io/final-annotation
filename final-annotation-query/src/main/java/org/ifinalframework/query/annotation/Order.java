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

package org.ifinalframework.query.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Order.
 *
 * @author ilikly
 * @version 1.0.0
 * @see org.ifinalframework.core.Orderable
 * @since 1.0.0
 * @deprecated replaced by {@link org.ifinalframework.core.Orderable}
 */

@Deprecated
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {

    /**
     * property name
     * @return property name
     */
    String property() default "";

    /**
     * order index
     * @return order index
     */
    int order() default 0;

    /**
     * value
     * @return value
     */
    String[] value() default {
            "<if test=\"${value} != null\">",
            "   ${column} \\${${value}},",
            "</if>"
    };

}
