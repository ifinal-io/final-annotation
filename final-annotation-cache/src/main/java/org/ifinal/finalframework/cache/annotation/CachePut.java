package org.ifinal.finalframework.cache.annotation;

import org.ifinal.finalframework.cache.annotation.CachePut.CachePuts;
import org.ifinal.finalframework.core.aop.JoinPoint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * CachePut.
 *
 * @author likly
 * @version 1.0.0
 * @see Cache#set(Object, Object, Object, Long, TimeUnit, Class)
 * @since 1.0.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(CachePuts.class)
public @interface CachePut {

    String[] key();

    String[] field() default {};

    String value() default "";

    String delimiter() default ":";

    JoinPoint point() default JoinPoint.AFTER_RETURNING;

    String condition() default "";

    String expire() default "";

    long ttl() default -1L;

    TimeUnit timeunit() default TimeUnit.MILLISECONDS;

    /**
     * CachePuts.
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface CachePuts {

        CachePut[] value();

    }

}
