package org.ifinal.finalframework.query;

import org.springframework.core.annotation.AnnotationAttributes;

import org.ifinal.finalframework.query.annotation.CriterionSqlProvider;

/**
 * @author likly
 * @version 1.0.0
 * @see CriterionSqlProvider
 * @since 1.0.0
 */
public class CriterionAttributes extends AnnotationAttributes implements Criterion {

    public static final String ATTRIBUTE_NAME_AND_OR = "andOr";

    public static final String ATTRIBUTE_NAME_PROPERTY = "property";

    public static final String ATTRIBUTE_NAME_COLUMN = "column";

    public static final String ATTRIBUTE_NAME_VALUE = "value";

    public static final String ATTRIBUTE_NAME_JAVA_TYPE = "javaType";

    public static final String ATTRIBUTE_NAME_TYPE_HANDLER = "typeHandler";

    public static final String ATTRIBUTE_NAME_QUERY = "query";

    public static final String ATTRIBUTE_NAME_EXPRESSION = "expression";

    public AndOr getAndor() {
        return getEnum(ATTRIBUTE_NAME_AND_OR);
    }

    public String getProperty() {
        return getString(ATTRIBUTE_NAME_PROPERTY);
    }

    public String getColumn() {
        return getString(ATTRIBUTE_NAME_COLUMN);
    }

    public Object getValue() {
        return get(ATTRIBUTE_NAME_VALUE);
    }

    public Class<?> getJavaType() {
        return getClass(ATTRIBUTE_NAME_JAVA_TYPE);
    }

    public Class<?> getTypeHandler() {
        return getClass(ATTRIBUTE_NAME_TYPE_HANDLER);
    }

    public void setExpression(String expression) {
        put(ATTRIBUTE_NAME_EXPRESSION, expression);
    }

    public void setColumn(String column) {
        put(ATTRIBUTE_NAME_COLUMN, column);
    }

    public void setValue(Object value) {
        put(ATTRIBUTE_NAME_VALUE, value);
    }

    public String getExpression() {
        return getString(ATTRIBUTE_NAME_EXPRESSION);
    }

    public static Builder builder(String expression) {
        return new Builder(expression);
    }

    public static class Builder {

        private final CriterionAttributes criterion = new CriterionAttributes();

        private Builder(String expression) {
            criterion.put(ATTRIBUTE_NAME_EXPRESSION, expression);
        }

        public Builder andOr(AndOr andOr) {
            criterion.put(ATTRIBUTE_NAME_AND_OR, andOr);
            return this;
        }

        public Builder column(String column) {
            criterion.put(ATTRIBUTE_NAME_COLUMN, column);
            return this;
        }

        public Builder value(Object value) {
            criterion.put(ATTRIBUTE_NAME_VALUE, value);
            return this;
        }

        public CriterionAttributes build() {
            return criterion;
        }

    }

}

