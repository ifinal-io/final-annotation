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

package org.ifinal.finalframework.cache.annotation;

import org.ifinal.finalframework.cache.annotation.CacheDel.CacheDels;
import org.ifinal.finalframework.core.aop.JoinPoint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在方法 {@link java.lang.reflect.Method} 执行的生命周期 {@link JoinPoint}中删除命中的缓存 {@link Cache#del(Object, Object)}。
 *
 * @author likly
 * @version 1.0.0
 * @see Cache#del(Object, Object)
 * @since 1.0.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(CacheDels.class)
public @interface CacheDel {

    /**
     * 缓存区表达式
     *
     * @return key
     */
    String[] key();

    /**
     * 缓存域表达式
     *
     * @return field
     */
    String[] field() default {};

    /**
     * 缓存区域表达式分隔符
     *
     * @return delimiter
     */
    String delimiter() default ":";

    /**
     * 执行条件
     *
     * @return condition
     */
    String condition() default "";

    /**
     * 重试次数
     *
     * @return retry
     */
    int retry() default 0;

    /**
     * 重试间隔
     *
     * @return sleep
     */
    long sleep() default 1000;

    JoinPoint point() default JoinPoint.AFTER_RETURNING;

    /**
     * Defines several {@link CacheDel } annotations on the same element.
     *
     * @see CacheDel
     */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface CacheDels {

        CacheDel[] value();

    }

}
