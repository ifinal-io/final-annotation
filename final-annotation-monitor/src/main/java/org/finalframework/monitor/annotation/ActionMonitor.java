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

package org.finalframework.monitor.annotation;

import org.springframework.core.annotation.AliasFor;

import org.finalframework.core.aop.AopAnnotation;
import org.finalframework.core.aop.JoinPoint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author likly
 * @version 1.1.2-SNAPSHOT
 * @since 1.1.2-SNAPSHOT
 */

@Documented
@AopAnnotation(expressions = {"name", "target"})
@Repeatable(ActionMonitor.ActionMonitors.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionMonitor {

    /**
     * action name
     *
     * @see #value()
     */
    @AliasFor("value")
    String[] name() default {};

    /**
     * action name
     *
     * @see #name()
     */
    @AliasFor("name")
    String[] value() default {};

    /**
     * 操作类型
     */
    String type() default "";

    /**
     * 操作动作
     */
    String code() default "code";

    /**
     * 操作目标
     */
    String target() default "";

    /**
     * 级别
     */
    MonitorLevel level() default MonitorLevel.INFO;

    JoinPoint point() default JoinPoint.AFTER_RETURNING;

    /**
     * ActionMonitors.
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface ActionMonitors {

        ActionMonitor[] value();

    }

}
