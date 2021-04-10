package org.ifinal.finalframework.query;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public final class Order {

    private final QProperty<?> property;

    private final Direction direction;

    static Order order(QProperty<?> property, Direction direction) {
        return new Order(property, direction);
    }

    static Order asc(QProperty<?> property) {
        return order(property, Direction.ASC);
    }

    static Order desc(QProperty<?> property) {
        return order(property, Direction.DESC);
    }

}
