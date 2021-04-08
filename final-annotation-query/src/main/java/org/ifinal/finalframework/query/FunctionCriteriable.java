package org.ifinal.finalframework.query;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import org.ifinal.finalframework.query.function.DateFunction;
import org.ifinal.finalframework.query.function.LogicFunction;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * FunctionCriteriable.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface FunctionCriteriable<V> extends Criteriable<V>, DateFunction<V>, LogicFunction<V> {

    Criteriable<V> apply(@NonNull UnaryOperator<String> column, @Nullable Consumer<CriterionAttributes> consumer);

}
