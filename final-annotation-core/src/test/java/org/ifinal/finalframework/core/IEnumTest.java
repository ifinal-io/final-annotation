package org.ifinal.finalframework.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

/**
 * IEnumTest.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class IEnumTest {

    @Getter
    @RequiredArgsConstructor
    private enum YN implements IEnum<Integer> {
        YES(1, "YES"),
        NO(0, "NO");

        private final Integer code;

        private final String desc;
    }

    @Test
    void valueOf() {
        Assertions.assertNull(IEnum.valueOf(YN.class, null));
        Assertions.assertNull(IEnum.valueOf(YN.class, 2));
        Assertions.assertEquals(YN.YES, IEnum.valueOf(YN.class, 1));
        Assertions.assertEquals(YN.NO, IEnum.valueOf(YN.class, 0));
    }

    @Test
    void should_throw_npe_when_type_is_null() {
        Assertions.assertThrows(NullPointerException.class, () -> IEnum.valueOf(null, "yes"));
    }

}
