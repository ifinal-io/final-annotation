package org.ifinal.finalframework.query;

import org.springframework.lang.Nullable;

import org.ifinal.finalframework.query.annotation.Between;
import org.ifinal.finalframework.query.annotation.NotBetween;
import org.ifinal.finalframework.query.condition.BetweenCondition;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The value holder which have one {@code min} value and {@code max} value for {@code between} value.
 *
 * @author likly
 * @version 1.0.0
 * @see Between
 * @see NotBetween
 * @see BetweenCondition
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class BetweenValue<T> implements Serializable {

    private static final long serialVersionUID = 6194662646358531082L;

    @Nullable
    private T min;

    @Nullable
    private T max;

}

