package org.ifinal.finalframework.core;

import org.springframework.lang.Nullable;

/**
 * A limit query interface for {@link IQuery}.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Limitable {

    /**
     * return the limit offset value.
     *
     * @return limit offset value.
     */
    @Nullable
    Long getOffset();

    /**
     * return the limit value.
     *
     * @return limit value
     */
    @Nullable
    Long getLimit();

}
