package org.ifinal.finalframework.query.function;

import org.springframework.lang.NonNull;

import org.ifinal.finalframework.query.Criteriable;

/**
 * LogicFunction.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface LogicFunction<V> extends Function<V> {

    default Criteriable<V> and(@NonNull Object value) {
        return apply(column -> String.format("%s & #{${criterion}.logicValue}", column), criterion -> criterion.put("logicValue", value));
    }

    default Criteriable<V> or(@NonNull Object value) {
        return apply(column -> String.format("%s | #{${criterion}.logicValue}", column), criterion -> criterion.put("logicValue", value));
    }

}
