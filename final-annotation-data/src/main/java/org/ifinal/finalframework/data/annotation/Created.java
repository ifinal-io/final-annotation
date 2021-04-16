package org.ifinal.finalframework.data.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.data.annotation.CreatedDate;

import org.ifinal.finalframework.core.lang.Default;
import org.ifinal.finalframework.core.lang.Final;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * Annotate the {@link Field property} is a {@code created} column which is have a {@link Default} value of {@code NOW()} and it is {@link
 * Final} and {@link ReadOnly}.
 *
 * <ul>
 *     <li>define default value with {@code DEFAULT NOW()}.</li>
 *     <li>would not be generated sql when {@code insert} and {@code update}.</li>
 * </ul>
 *
 * @author likly
 * @version 1.0.0
 * @see Column
 * @see Default NOW()
 * @see Final can not update
 * @since 1.0.0
 */
@Column
@Default
@Final
@ReadOnly
@CreatedDate
@Documented
@Order(Integer.MAX_VALUE - 120)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Created {

    @AliasFor(annotation = Column.class)
    String value() default "";

    @AliasFor(annotation = Column.class)
    String name() default "";

}
