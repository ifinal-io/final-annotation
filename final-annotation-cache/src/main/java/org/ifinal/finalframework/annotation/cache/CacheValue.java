package org.ifinal.finalframework.annotation.cache;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作用在方法参数 {@link java.lang.reflect.Parameter} 上，实现在方法执行之前，从缓存中获取值，并将该值赋于该参数。
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheValue {

    String[] key();

    String[] field() default {};

    String delimiter() default ":";

    @AliasFor("when")
    String condition() default "";

    @AliasFor("condition")
    String when() default "";

}
