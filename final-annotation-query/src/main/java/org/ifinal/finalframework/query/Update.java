package org.ifinal.finalframework.query;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Update.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Update extends ArrayList<Criterion> {

    public static Update update() {
        return new Update();
    }

    public Update set(String column, Object value) {
        return update(CriterionExpression.UPDATE_SET, column, value, null);
    }

    public Update inc(String column) {
        return incr(column, 1);
    }

    public Update incr(String column, Number value) {
        return update(CriterionExpression.UPDATE_INCR, column, value, null);
    }

    public Update dec(String column) {
        return decr(column, 1);
    }

    public Update decr(String column, Number value) {
        return update(CriterionExpression.UPDATE_DECR, column, value, null);
    }

    public Update update(String expression, String column, Object value, Consumer<CriterionAttributes> consumer) {
        Criterion criterion = CriterionTarget.from(column)
            .condition(expression, value, consumer);
        this.add(criterion);
        return this;
    }

}
