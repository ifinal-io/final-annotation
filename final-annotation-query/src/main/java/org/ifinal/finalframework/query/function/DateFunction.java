package org.ifinal.finalframework.query.function;

import org.ifinal.finalframework.query.Criteriable;

/**
 * DateFunction.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface DateFunction<V> extends Function<V> {

    default Criteriable<V> date() {
        return apply(column -> String.format("DATE(%s)", column), null);
    }

}
