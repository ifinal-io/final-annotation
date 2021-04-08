package org.ifinal.finalframework.query.function;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import org.ifinal.finalframework.query.Criteriable;
import org.ifinal.finalframework.query.CriterionAttributes;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * Function.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface Function<V> {

    Criteriable<V> apply(@NonNull UnaryOperator<String> function, @Nullable Consumer<CriterionAttributes> consumer);

}
