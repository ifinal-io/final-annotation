package org.ifinal.finalframework.query.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Generate sql fragment like {@code JSON_CONTAINS(${column},'${value}'[,'${path}']})}
 *
 * @author likly
 * @version 1.0.0
 * @see NotJsonContains
 * @since 1.0.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Criterion(JsonContains.class)
public @interface JsonContains {

    String property() default "";

    String[] value() default {
        "<if test=\"${value} != null\">",
        "   <![CDATA[",
        "       ${andOr} JSON_CONTAINS( ${column}, #{${value}",
        "           #if($javaType), javaType=$!{javaType.canonicalName}#end",
        "           #if($typeHandler), typeHandler=$!{typeHandler.canonicalName}#end}",
        "       #if($path), '${path}'#end)",
        "   ]]>",
        "</if>"
    };

    String path() default "";

    Class<?> javaType() default Object.class;

}
