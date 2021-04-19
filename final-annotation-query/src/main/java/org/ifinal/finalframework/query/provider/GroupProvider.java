package org.ifinal.finalframework.query.provider;

import org.springframework.lang.Nullable;

import org.ifinal.finalframework.core.Groupable;

/**
 * GroupProvider.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.1.4
 */
@FunctionalInterface
public interface GroupProvider {

    @Nullable
    String groups(@Nullable Groupable groupable);

}
