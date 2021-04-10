package org.ifinal.finalframework.query;

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

    private static final String TEST_VALUE_NOT_NULL = "${value} != null";

    private static final String FRAGMENT_JAVA_TYPE = "#if($javaType), javaType=$!{javaType.canonicalName}#end";

    private static final String FRAGMENT_TYPE_HANDLER = "#if($typeHandler), typeHandler=$!{typeHandler.canonicalName}#end";

    /**
     * {@code #{${value},javaType=,typeHandler=}}
     */
    private static final String FRAGMENT_VALUE = "#{${value}" + FRAGMENT_JAVA_TYPE + FRAGMENT_TYPE_HANDLER + "}";

    /**
     * {@code #{${value}.min,javaType=,typeHandler=}}
     */
    private static final String FRAGMENT_VALUE_MIN = "#{${value}.min" + FRAGMENT_JAVA_TYPE + FRAGMENT_TYPE_HANDLER + "}";

    /**
     * {@code #{${value}.max,javaType=,typeHandler=}}
     */
    private static final String FRAGMENT_VALUE_AMX = "#{${value}.max" + FRAGMENT_JAVA_TYPE + FRAGMENT_TYPE_HANDLER + "}";

    // NULL

    public static final String IS_NULL = expression(null,
        "${column} IS NULL");

    public static final String IS_NOT_NULL = expression(null,
        "${column} IS NOT NULL");

    // COMPARE

    public static final String EQUAL = expression(TEST_VALUE_NOT_NULL,
        "${column} = ", FRAGMENT_VALUE);

    public static final String NOT_EQUAL = expression(TEST_VALUE_NOT_NULL,
        "${column} != ", FRAGMENT_VALUE);

    public static final String GREAT_THAN = expression(TEST_VALUE_NOT_NULL,
        "${column} > ", FRAGMENT_VALUE);

    public static final String GREAT_THAN_EQUAL = expression(TEST_VALUE_NOT_NULL,
        "${column} >= ", FRAGMENT_VALUE);

    public static final String LESS_THAN = expression(TEST_VALUE_NOT_NULL,
        "${column} < ", FRAGMENT_VALUE);

    public static final String LESS_THAN_EQUAL = expression(TEST_VALUE_NOT_NULL,
        "${column} <= ", FRAGMENT_VALUE);

    // BETWEEN

    private static final String TEST_BETWEEN_VALUE_NOT_NULL = "${value} != null and ${value}.min != null and ${value}.max != null";

    public static final String BETWEEN = expression(TEST_BETWEEN_VALUE_NOT_NULL,
        "${column} BETWEEN #{${value}.min", FRAGMENT_JAVA_TYPE, FRAGMENT_TYPE_HANDLER,
        "AND #{${value}.max", FRAGMENT_JAVA_TYPE, FRAGMENT_TYPE_HANDLER);

    public static final String NOT_BETWEEN = expression(TEST_BETWEEN_VALUE_NOT_NULL,
        "${column} NOT BETWEEN #{${value}.min", FRAGMENT_JAVA_TYPE, FRAGMENT_TYPE_HANDLER,
        "AND #{${value}.max", FRAGMENT_JAVA_TYPE, FRAGMENT_TYPE_HANDLER);

    // LIKE

    private static final String TEST_LIKE_VALUE_NOT_NULL = "${value} != null and ${value} != ''";

    public static final String LIKE = expression(TEST_LIKE_VALUE_NOT_NULL, "${column} LIKE #{${value}}");

    public static final String NOT_LIKE = expression(TEST_LIKE_VALUE_NOT_NULL, "${column} NOT LIKE #{${value}}");

    public static final String START_WITH = expression(TEST_LIKE_VALUE_NOT_NULL, "${column} LIKE CONCAT('%',#{${value}})");

    public static final String NOT_START_WITH = expression(TEST_LIKE_VALUE_NOT_NULL, "${column} NOT LIKE CONCAT('%',#{${value}})");

    public static final String END_WITH = expression(TEST_LIKE_VALUE_NOT_NULL, "${column} LIKE CONCAT(#{${value}},'%')");

    public static final String NOT_END_WITH = expression(TEST_LIKE_VALUE_NOT_NULL, "${column} NOT LIKE CONCAT(#{${value}},'%')");

    public static final String CONTAINS = expression(TEST_LIKE_VALUE_NOT_NULL, "${column} LIKE CONCAT('%',#{${value}},'%')");

    public static final String NOT_CONTAINS = expression(TEST_LIKE_VALUE_NOT_NULL, "${column} NOT LIKE CONCAT('%',#{${value}},'%')");

    // IN

    public static final String IN = expression(TEST_VALUE_NOT_NULL,
        "<foreach collection=\"${value}\" item=\"item\" open=\"${column} IN (\" close=\")\" separator=\",\">",
        "#{item}",
        "</foreach>");

    public static final String NOT_IN = expression(TEST_VALUE_NOT_NULL,
        "<foreach collection=\"${value}\" item=\"item\" open=\"${column} NOT IN (\" close=\")\" separator=\",\">",
        "#{item}",
        "</foreach>");

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
        "${column} = ", FRAGMENT_VALUE);

    /**
     * {@code column = column + #{value,javaType=,typeHandler=}}
     */
    public static final String UPDATE_INCR = update(TEST_VALUE_NOT_NULL,
        "${column} = ${column} + ", FRAGMENT_VALUE);

    /**
     * {@code column = column - #{value,javaType=,typeHandler=}}
     */
    public static final String UPDATE_DECR = update(TEST_VALUE_NOT_NULL,
        "${column} = ${column} - ", FRAGMENT_VALUE);

}
