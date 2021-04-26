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

package org.finalframework.core.jackson.deserializer;

import org.finalframework.core.IEnum;
import org.finalframework.json.Json;

import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * IEnumDeserializersTest.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
class IEnumDeserializersTest {

    @RequiredArgsConstructor
    @Getter
    private enum YN implements IEnum<Integer> {

        YES(1, "YES"),

        NO(2, "NO");

        private final Integer code;

        private final String desc;

    }

    private enum Normal {
        NORMAL
    }

    @Data
    private static class Person {

        private YN yn = YN.YES;

        private Normal normal = Normal.NORMAL;

    }

    @Test
    void findEnumDeserializer() {

        Assertions.assertDoesNotThrow(() -> {
            IEnumDeserializers deserializers = new IEnumDeserializers();

            JsonDeserializer<?> deserializer = deserializers.findEnumDeserializer(YN.class, null, null);

            Assertions.assertNotNull(deserializer);
            Assertions.assertEquals("EnumDeserializer", deserializer.getClass().getSimpleName());

        });

    }

    @Test
    void enumValueShouldBeCode() {
        Assertions.assertEquals(YN.YES.getCode().toString(), Json.toJson(YN.YES));
        String json = Json.toJson(new Person());
        Assertions.assertTrue(json.contains("ynDesc"));
    }

    @Test
    void deserializeEnumFromCode() {
        Assertions.assertEquals(YN.YES, Json.toObject("1", YN.class));
    }

}
