/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.ifinalframework.query;

import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * Update sql fragment in java.
 *
 * <h3>Usage</h3>
 *
 * <pre class="code">
 *      Update update = Update.update();
 *      // set column value
 *      update.set(column,value);
 *      // incr or decr column value
 *      update.incr(column,number);
 *      update.decr(column,number);
 *      // custom update
 *      update.update(expression,column,value,consumer);
 * </pre>
 *
 * <h3>Support update sql fragments:</h3>
 * <ul>
 *     <li>set column with value like {@code column = #{value}},{@link #set(String, Object)}</li>
 *     <li>set column with value like {@code column = column +/- #{value}},see {@link #incr(String, Number)} and {@link #decr(String, Number)}</li>
 *     <li>set column with custom sql, see {@link #update(String, String, Object, Consumer)}</li>
 * </ul>
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Update extends LinkedList<Criterion> {

    public static Update update() {
        return new Update();
    }

    public Update set(QProperty<?> property, Object value) {
        return set(property.getColumn(), value);
    }

    /**
     * Update {@code column} with {@code value} use sql like {@code column = #{value}}.
     *
     * @param column the column to update
     * @param value  the update value
     * @return update
     * @see CriterionExpression#UPDATE_SET
     */
    public Update set(String column, Object value) {
        return update(CriterionExpression.UPDATE_SET, column, value, null);
    }

    public Update inc(QProperty<?> property) {
        return inc(property.getColumn());
    }

    public Update inc(String column) {
        return incr(column, 1);
    }

    public Update incr(QProperty<?> property, Number value) {
        return incr(property.getColumn(), value);
    }

    public Update incr(String column, Number value) {
        return update(CriterionExpression.UPDATE_INCR, column, value, null);
    }

    public Update dec(QProperty<?> property) {
        return dec(property.getColumn());
    }

    public Update dec(String column) {
        return decr(column, 1);
    }

    public Update decr(QProperty<?> property, Number value) {
        return decr(property.getColumn(), value);
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
