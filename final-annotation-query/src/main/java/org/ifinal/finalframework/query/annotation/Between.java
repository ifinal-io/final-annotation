package org.ifinal.finalframework.query.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre class="code">
 *     column BETWEEN #{min} AND #{max}
 * </pre>
 *
 * @author likly
 * @version 1.0.0
 * @see org.ifinal.finalframework.query.QProperty#between(Object, Object)
 * @since 1.0.0
 */
@Documented
@Criterion(Between.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Between {

    String property() default "";

    String[] value() default {
        "<if test=\"${value} != null and ${value}.min != null and ${value}.max != null\">",
        "    <![CDATA[",
        "       ${andOr} ${column} BETWEEN #{${value}.min",
        "           #if($javaType),javaType=$!{javaType.canonicalName}#end",
        "           #if($typeHandler),typeHandler=$!{typeHandler.canonicalName}#end}",
        "       AND #{${value}.max",
        "           #if($javaType),javaType=$!{javaType.canonicalName}#end",
        "           #if($typeHandler),typeHandler=$!{typeHandler.canonicalName}#end}",
        "       ]]>",
        "</if>"
    };

    Class<?> javaType() default Object.class;

}
