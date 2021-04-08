package org.ifinal.finalframework.query.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Generate sql fragment like {@code column IS NOT NULL} when the target {@link java.lang.reflect.Field} value is not null.
 *
 * @author likly
 * @version 1.0.0
 * @see IsNull
 * @since 1.0.0
 */
@Documented
@Criterion(IsNotNull.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsNotNull {

    String property() default "";

    String[] value() default {
        "<if test=\"${value} != null\">",
        "   <![CDATA[ ${andOr} ${column} IS NOT NULL]]>",
        "</if>"
    };

    Class<?> javaType() default Object.class;

}
