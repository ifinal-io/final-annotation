package org.ifinal.finalframework.query.provider;

import org.springframework.lang.Nullable;

import org.ifinal.finalframework.core.Limitable;

/**
 * LimitProvider.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.1.4
 */
@FunctionalInterface
public interface LimitProvider {

    @Nullable
    String limit(@Nullable Limitable limitable);

}
