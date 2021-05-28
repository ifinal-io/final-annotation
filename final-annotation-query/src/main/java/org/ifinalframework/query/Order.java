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

import java.io.Serializable;
import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public final class Order implements Serializable {

    private final String column;

    private final Direction direction;

    public static Order from(String order) {

        String[] orderAndDirection = order.split(" ");

        if (orderAndDirection.length == 1) {
            return asc(order);
        } else if (orderAndDirection.length == 2) {
            return order(orderAndDirection[0], Direction.valueOf(orderAndDirection[1].toUpperCase()));
        }

        throw new IllegalArgumentException("Order need column and direction values bound found more in " + order);

    }

    public static Order order(String column, Direction direction) {
        return new Order(column, Objects.requireNonNull(direction));
    }

    public static Order asc(QProperty<?> property) {
        return asc(property.getColumn());
    }

    public static Order asc(String column) {
        return order(column, Direction.ASC);
    }

    public static Order desc(QProperty<?> property) {
        return desc(property.getColumn());
    }

    public static Order desc(String column) {
        return order(column, Direction.DESC);
    }

    @Override
    public String toString() {
        return String.join(" ", column, direction.name());
    }

}
