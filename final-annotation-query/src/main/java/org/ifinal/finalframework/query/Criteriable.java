package org.ifinal.finalframework.query;

import org.ifinal.finalframework.query.condition.BetweenCondition;
import org.ifinal.finalframework.query.condition.CompareCondition;
import org.ifinal.finalframework.query.condition.InCondition;
import org.ifinal.finalframework.query.condition.JsonCondition;
import org.ifinal.finalframework.query.condition.LikeCondition;
import org.ifinal.finalframework.query.condition.NullCondition;

/**
 * Criteriable.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Criteriable<V> extends NullCondition, CompareCondition<V>, BetweenCondition<V>, InCondition, LikeCondition
    , JsonCondition<V> {

}
