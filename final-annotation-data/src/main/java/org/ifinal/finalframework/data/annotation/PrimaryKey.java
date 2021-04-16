package org.ifinal.finalframework.data.annotation;

import org.springframework.core.annotation.AliasFor;

import org.ifinal.finalframework.core.IEntity;
import org.ifinal.finalframework.core.lang.Default;
import org.ifinal.finalframework.core.lang.Final;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marked the element is a primary key.
 *
 * @author likly
 * @version 1.0.0
 * @see org.springframework.data.annotation.Id
 * @see IEntity
 * @see AutoInc
 * @since 1.0.0
 */
@Final
@Column
@Default
@Documented
@Order(Integer.MIN_VALUE)
@org.springframework.data.annotation.Id
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrimaryKey {

    @AliasFor(annotation = Column.class, value = "value")
    String value() default "";

    @AliasFor(annotation = Column.class, value = "name")
    String name() default "";

}
