package org.ifinal.finalframework.core;

import org.springframework.lang.Nullable;

/**
 * Limitable.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Limitable {

    @Nullable
    Long getOffset();

    @Nullable
    Long getLimit();

}
