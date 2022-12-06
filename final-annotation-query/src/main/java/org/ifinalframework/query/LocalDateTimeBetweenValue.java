/*
 * Copyright 2020-2022 the original author or authors.
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

import java.time.LocalDateTime;

/**
 * LocalDateTimeBetweenValue.
 *
 * @author ilikly
 * @version 1.4.2
 * @since 1.4.2
 */
public final class LocalDateTimeBetweenValue extends BetweenValue<LocalDateTime> {
    @Override
    public void setMax(LocalDateTime max) {
        super.setMax(max);
    }

    @Override
    public void setMin(LocalDateTime min) {
        super.setMin(min);
    }

    @Override
    public LocalDateTime getMax() {
        return super.getMax();
    }

    @Override
    public LocalDateTime getMin() {
        return super.getMin();
    }
}


