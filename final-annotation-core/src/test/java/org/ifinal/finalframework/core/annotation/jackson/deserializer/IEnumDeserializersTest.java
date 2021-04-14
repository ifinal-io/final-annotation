package org.ifinal.finalframework.core.jackson.deserializer;

import org.ifinal.finalframework.core.annotation.IEnum;
import org.ifinal.finalframework.json.Json;

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
            org.ifinal.finalframework.core.jackson.deserializer.IEnumDeserializers deserializers = new org.ifinal.finalframework.core.jackson.deserializer.IEnumDeserializers();

            JsonDeserializer<?> deserializer = deserializers.findEnumDeserializer(YN.class, null, null);

            Assertions.assertNotNull(deserializer);
            Assertions.assertEquals("EnumDeserializer", deserializer.getClass().getSimpleName());

        });

    }

    @Test
    void enumValueShouldBeCode() {
        Assertions.assertEquals(YN.YES.getCode().toString(), Json.toJson(YN.YES));
        String json = Json.toJson(new Person());
        logger.info(json);
        Assertions.assertTrue(json.contains("ynDesc"));
    }

    @Test
    void deserializeEnumFromCode() {
        Assertions.assertEquals(YN.YES, Json.toObject("1", YN.class));
    }

}
