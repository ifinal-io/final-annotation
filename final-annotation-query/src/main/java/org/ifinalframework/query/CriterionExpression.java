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

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

import lombok.Getter;

/**
 * CriterionExpression.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
public final class CriterionExpression {

    private CriterionExpression() {
    }

    private static final String DELIMITER = " ";

    private static final String CDATA_OPEN = "<![CDATA[ ";

    private static final String CDATA_CLOSE = " ]]>";

    private static final String AND_OR = "${andOr} ";

    private static String expression(@Nullable String test, @NonNull String... fragments) {
        if (Objects.isNull(test)) {
            return CDATA_OPEN + AND_OR + String.join(DELIMITER, fragments) + CDATA_CLOSE;
        }

        return "<if test=\"" + test + "\">"
            + CDATA_OPEN + AND_OR + String.join(DELIMITER, fragments) + CDATA_CLOSE
            + "</if>";

    }

    private static String expression2(@Nullable String test, String prefix, String suffix,
        @NonNull String... fragments) {
        if (Objects.isNull(test)) {
            return AND_OR + prefix + CDATA_OPEN + String.join(DELIMITER, fragments) + CDATA_CLOSE + suffix;
        }

        return "<if test=\"" + test + "\">"
            + AND_OR + prefix
            + CDATA_OPEN + String.join(DELIMITER, fragments) + CDATA_CLOSE
            + suffix
            + "</if>";

    }

    private static final String TEST_VALUE_NOT_NULL = "${value} != null";

    private static final String TEST_VALUE_NOT_EMPTY = "${value} != null and ${value}.size() > 0";

    private static final String FRAGMENT_JAVA_TYPE = "#if($javaType), javaType=$!{javaType.canonicalName}#end";

    private static final String FRAGMENT_TYPE_HANDLER = "#if($typeHandler), typeHandler=$!{typeHandler.canonicalName}#end";

    /**
     * {@code #{${value},javaType=,typeHandler=}}
     */
    private static final String FRAGMENT_VALUE = "#{${value}" + FRAGMENT_JAVA_TYPE + FRAGMENT_TYPE_HANDLER + "}";

    private static final String FRAGMENT_CRITERION_VALUE =
        "#{${value}.value" + FRAGMENT_JAVA_TYPE + FRAGMENT_TYPE_HANDLER + "}";

    /**
     * {@code #{${value}.min,javaType=,typeHandler=}}
     */
    private static final String FRAGMENT_MIN_VALUE =
        "#{${value}.min" + FRAGMENT_JAVA_TYPE + FRAGMENT_TYPE_HANDLER + "}";

    /**
     * {@code #{${value}.max,javaType=,typeHandler=}}
     */
    private static final String FRAGMENT_MAX_VALUE =
        "#{${value}.max" + FRAGMENT_JAVA_TYPE + FRAGMENT_TYPE_HANDLER + "}";

    /**
     * <pre class="code">
     * ${andOr} ${column} IS NULL
     * </pre>
     */
    // NULL
    public static final String IS_NULL = expression(null,
        "${column} IS NULL");

    /**
     * <pre class="code">
     *     ${andOr} ${column} IS NOT NULL
     * </pre>
     */
    public static final String IS_NOT_NULL = expression(null,
        "${column} IS NOT NULL");

    // COMPARE

    /**
     * <pre class="code">
     * &lt;if test="${value} != null"&gt;
     *      ${andOr} ${column} = #{value,javaType=,typeHandler=}
     * &lt;/if&gt;
     * </pre>
     */
    public static final String EQUAL = expression(TEST_VALUE_NOT_NULL,
        "${column} =", FRAGMENT_VALUE);

    /**
     * <pre class="code">
     * &lt;if test="${value} != null"&gt;
     *     ${andOr} ${column} != #{value,javaType=,typeHandler=}
     * &lt;/if&gt;
     * </pre>
     */
    public static final String NOT_EQUAL = expression(TEST_VALUE_NOT_NULL,
        "${column} !=", FRAGMENT_VALUE);

    /**
     * {@code <if test="${value} != null"> ${andOr}
     * </if>
     * }
     */
    public static final String GREAT_THAN = expression(TEST_VALUE_NOT_NULL,
        "${column} >", FRAGMENT_VALUE);

    public static final String GREAT_THAN_EQUAL = expression(TEST_VALUE_NOT_NULL,
        "${column} >=", FRAGMENT_VALUE);

    public static final String LESS_THAN = expression(TEST_VALUE_NOT_NULL,
        "${column} <", FRAGMENT_VALUE);

    public static final String LESS_THAN_EQUAL = expression(TEST_VALUE_NOT_NULL,
        "${column} <=", FRAGMENT_VALUE);

    // BETWEEN

    private static final String TEST_BETWEEN_VALUE_NOT_NULL = "${value} != null and ${value}.min != null and ${value}.max != null";

    public static final String BETWEEN = expression(TEST_BETWEEN_VALUE_NOT_NULL,
        "${column} BETWEEN", FRAGMENT_MIN_VALUE, "AND", FRAGMENT_MAX_VALUE);

    public static final String NOT_BETWEEN = expression(TEST_BETWEEN_VALUE_NOT_NULL,
        "${column} NOT BETWEEN", FRAGMENT_MIN_VALUE, "AND", FRAGMENT_MAX_VALUE);

    // LIKE

    private static final String TEST_LIKE_VALUE_NOT_NULL = "${value} != null and ${value} != ''";

    public static final String LIKE = expression(TEST_LIKE_VALUE_NOT_NULL, "${column} LIKE #{${value}}");

    public static final String NOT_LIKE = expression(TEST_LIKE_VALUE_NOT_NULL, "${column} NOT LIKE #{${value}}");

    public static final String STARTS_WITH = expression(TEST_LIKE_VALUE_NOT_NULL,
        "${column} LIKE CONCAT('%',#{${value}})");

    public static final String NOT_STARTS_WITH = expression(TEST_LIKE_VALUE_NOT_NULL,
        "${column} NOT LIKE CONCAT('%',#{${value}})");

    public static final String ENDS_WITH = expression(TEST_LIKE_VALUE_NOT_NULL,
        "${column} LIKE CONCAT(#{${value}},'%')");

    public static final String NOT_ENDS_WITH = expression(TEST_LIKE_VALUE_NOT_NULL,
        "${column} NOT LIKE CONCAT(#{${value}},'%')");

    public static final String CONTAINS = expression(TEST_LIKE_VALUE_NOT_NULL,
        "${column} LIKE CONCAT('%',#{${value}},'%')");

    public static final String NOT_CONTAINS = expression(TEST_LIKE_VALUE_NOT_NULL,
        "${column} NOT LIKE CONCAT('%',#{${value}},'%')");

    // IN

    public static final String IN = expression2(TEST_VALUE_NOT_EMPTY,
        "<foreach collection=\"${value}\" item=\"item\" open=\"${column} IN (\" close=\")\" separator=\",\">",
        "</foreach>",
        "#{item}");

    public static final String NOT_IN = expression2(TEST_VALUE_NOT_EMPTY,
        "<foreach collection=\"${value}\" item=\"item\" open=\"${column} NOT IN (\" close=\")\" separator=\",\">",
        "</foreach>",
        "#{item}");

    // JSON

    /**
     * {@code JSON_CONTAINS(column,value[,path])}
     */
    public static final String JSON_CONTAINS = expression(TEST_VALUE_NOT_NULL,
        "JSON_CONTAINS( ${column},", FRAGMENT_VALUE,
        "       #if($path), '${path}'#end )");

    public static final String NOT_JSON_CONTAINS = expression(TEST_VALUE_NOT_NULL,
        "!JSON_CONTAINS( ${column},", FRAGMENT_VALUE,
        "       #if($path), '${path}'#end )");

    public static final String JSON_CONTAINS_PATH = expression(TEST_VALUE_NOT_EMPTY,
        "JSON_CONTAINS_PATH( ${column}, '${oneOrAll}', ",
        "<foreach collection=\"${value}\" item=\"item\" separator=\",\">#{item}</foreach>",
        ")");
    // UPDATE

    private static String update(String test, String... fragments) {
        if (Objects.isNull(test)) {
            return CDATA_OPEN + String.join(DELIMITER, fragments) + "," + CDATA_CLOSE;
        }

        return "<if test=\"" + test + "\">"
            + CDATA_OPEN + String.join(DELIMITER, fragments) + "," + CDATA_CLOSE
            + "</if>";
    }

    /**
     * {@code column = #{value,javaType=,typeHandler=}}
     */
    public static final String UPDATE_SET = update(TEST_VALUE_NOT_NULL,
        "${column} = ", FRAGMENT_CRITERION_VALUE);

    /**
     * {@code column = column + #{value,javaType=,typeHandler=}}
     */
    public static final String UPDATE_INCR = update(TEST_VALUE_NOT_NULL,
        "${column} = ${column} + ", FRAGMENT_CRITERION_VALUE);

    /**
     * {@code column = column - #{value,javaType=,typeHandler=}}
     */
    public static final String UPDATE_DECR = update(TEST_VALUE_NOT_NULL,
        "${column} = ${column} - ", FRAGMENT_CRITERION_VALUE);

    /**
     * {@code column = JSON_INSERT(column, path,val[,path,val]...))}
     *
     * @see #JSON_REPLACE
     * @see #JSON_SET
     */
    public static final String JSON_INSERT = update(TEST_VALUE_NOT_EMPTY,
        "${column} = JSON_INSERT(${column},<foreach collection=\"${value}.entrySet()\" index=\"key\" item=\"val\" separator=\",\">#{key},#{val}</foreach>)");

    /**
     * {@code column = JSON_REPLACE(column, path,val[,path,val]...))}
     *
     * @see #JSON_INSERT
     * @see #JSON_SET
     */
    public static final String JSON_REPLACE = update(TEST_VALUE_NOT_EMPTY,
        "${column} = JSON_REPLACE(${column},<foreach collection=\"${value}.entrySet()\" index=\"key\" item=\"val\" separator=\",\">#{key},#{val}</foreach>)");

    /**
     * {@code column = JSON_SET(column, path,val[,path,val]...))}
     *
     * @see #JSON_INSERT
     * @see #JSON_REPLACE
     */
    public static final String JSON_SET = update(TEST_VALUE_NOT_EMPTY,
        "${column} = JSON_SET(${column},<foreach collection=\"${value}.entrySet()\" index=\"key\" item=\"val\" separator=\",\">#{key},#{val}</foreach>)");

    /**
     * {@code column = JSON_REMOVE(column, path[,path...])}
     */
    public static final String JSON_REMOVE = update(TEST_VALUE_NOT_EMPTY,
        "${column} = JSON_REMOVE(${column},<foreach collection=\"${value}\" item=\"item\" separator=\",\">#{item}</foreach>)");

}
