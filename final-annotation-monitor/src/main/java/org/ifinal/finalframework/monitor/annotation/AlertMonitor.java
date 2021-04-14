package org.ifinal.finalframework.monitor.annotation;

import org.springframework.core.annotation.AliasFor;

import org.ifinal.finalframework.core.annotation.aop.AopAnnotation;
import org.ifinal.finalframework.core.annotation.aop.JoinPoint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@AopAnnotation
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AlertMonitor {

    String[] name();

    String[] key();

    MonitorLevel level() default MonitorLevel.INFO;

    String[] message() default "";

    String[] target() default "";

    @AliasFor("when")
    String condition() default "";

    @AliasFor("condition")
    String when() default "";

    JoinPoint point() default JoinPoint.AFTER_THROWING;

}
