package org.ifinal.finalframework.query;

import org.ifinal.finalframework.query.annotation.Between;
import org.ifinal.finalframework.query.annotation.NotBetween;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author likly
 * @version 1.0.0
 * @see Between
 * @see NotBetween
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class BetweenValue<T> implements Serializable {

    private static final long serialVersionUID = 6194662646358531082L;

    private T min;

    private T max;

}

