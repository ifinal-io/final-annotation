package org.ifinal.finalframework.data.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.data.annotation.LastModifiedDate;

import org.ifinal.finalframework.core.lang.Default;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <ul>
 *     <li>define default value with ddl {@code DEFAULT NULL ON UPDATE NOW}.</li>
 *     <li>would not be generated sql when {@code insert} and {@code update}.</li>
 * </ul>
 *
 * @author likly
 * @version 1.0.0
 * @see Created
 * @see LastModifier
 * @see Default DEFAULT NULL ON UPDATE NOW()
 * @since 1.0.0
 */
@Documented
@ReadOnly
@Column
@LastModifiedDate
@Order(Integer.MAX_VALUE - 100)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LastModified {

    @AliasFor(annotation = Column.class, value = "name")
    String value() default "";

    @AliasFor(annotation = Column.class, value = "value")
    String name() default "";

}
