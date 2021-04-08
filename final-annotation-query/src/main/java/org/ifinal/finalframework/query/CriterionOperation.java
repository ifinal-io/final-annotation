package org.ifinal.finalframework.query;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * CriterionExpression.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum CriterionOperation {

    EQUAL(CriterionExpression.EQUAL),
    NOT_EQUAL(CriterionExpression.NOT_EQUAL);

    private final String value;

    CriterionOperation(final String... value) {
        this.value = String.join(" ", value);

    }

}
