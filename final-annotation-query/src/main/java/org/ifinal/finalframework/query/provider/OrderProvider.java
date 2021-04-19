package org.ifinal.finalframework.query.provider;

import org.springframework.lang.Nullable;

import org.ifinal.finalframework.core.Orderable;

/**
 * OrderProvider.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.1.4
 */
@FunctionalInterface
public interface OrderProvider {

    @Nullable
    String orders(@Nullable Orderable orderable);

}
