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

    private final String column;

    private final Direction direction;

    static Order order(String column, Direction direction) {
        return new Order(column, direction);
    }

    static Order asc(String column) {
        return order(column, Direction.ASC);
    }

    static Order desc(String column) {
        return order(column, Direction.DESC);
    }

    @Override
    public String toString() {
        return String.join(" ", column, direction.name());
    }

}
