/*
 * Copyright 2020-2021 the original author or authors.
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
 */

package org.ifinalframework.query;

import org.ifinalframework.core.IUpdate;

import java.util.*;
import java.util.function.Consumer;

/**
 * Update sql fragment in java.
 *
 * <h3>Usage</h3>
 *
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
 * <h4>Update With {@code JSON_SET}</h4>
 *
 * <pre class="code">
 * Update.update().jsonSet(column,&lt;path,val&gt;);
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
@SuppressWarnings("unused")
public final class Update extends LinkedList<Criterion> implements IUpdate {

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

    //    JSON_INSERT
    public Update jsonInsert(QProperty<?> property, String path, Object value) {
        return jsonInsert(property.getColumn(), path, value);
    }

    public Update jsonInsert(QProperty<?> property, Map<String, Object> values) {
        return jsonInsert(property.getColumn(), values);
    }

    public Update jsonInsert(String column, String path, Object value) {
        return jsonInsert(column, Collections.singletonMap(path, value));
    }

    /**
     * {@code column = JSON_INSERT(column,path,value[,path1,value1...])}
     *
     * @param column update column name.
     * @param values json insert path and values.
     * @return update.
     * @since 1.2.1
     */
    public Update jsonInsert(String column, Map<String, Object> values) {
        return update(CriterionExpression.JSON_INSERT, column, values, null);
    }

    //    JSON_REPLACE
    public Update jsonReplace(QProperty<?> property, String path, Object value) {
        return jsonReplace(property.getColumn(), path, value);
    }

    public Update jsonReplace(QProperty<?> property, Map<String, Object> values) {
        return jsonReplace(property.getColumn(), values);
    }

    public Update jsonReplace(String column, String path, Object value) {
        return jsonReplace(column, Collections.singletonMap(path, value));
    }

    public Update jsonReplace(String column, Map<String, Object> values) {
        return update(CriterionExpression.JSON_REPLACE, column, values, null);
    }

    //    JSON_SET
    public Update jsonSet(QProperty<?> property, String path, Object value) {
        return jsonSet(property.getColumn(), path, value);
    }

    public Update jsonSet(QProperty<?> property, Map<String, Object> values) {
        return jsonSet(property.getColumn(), values);
    }

    public Update jsonSet(String column, String path, Object value) {
        return jsonSet(column, Collections.singletonMap(path, value));
    }

    /**
     * @param column update column.
     * @param values value type only support {@code string、number and boolean}.
     * @return update.
     * @since 1.2.1
     */
    public Update jsonSet(String column, Map<String, Object> values) {
        return update(CriterionExpression.JSON_SET, column, values, null);
    }

    public Update jsonRemove(QProperty<?> property, String... path) {
        return jsonRemove(property.getColumn(), path);
    }

    public Update jsonRemove(QProperty<?> property, Collection<String> paths) {
        return jsonRemove(property.getColumn(), paths);
    }

    public Update jsonRemove(String column, String... path) {
        return jsonRemove(column, Arrays.asList(path));
    }

    public Update jsonRemove(String column, Collection<String> paths) {
        return update(CriterionExpression.JSON_REMOVE, column, paths, null);
    }

    public Update update(String expression, String column, Object value, Consumer<CriterionAttributes> consumer) {
        Criterion criterion = CriterionTarget.from(column)
                .condition(expression, value, consumer);
        this.add(criterion);
        return this;
    }

}
