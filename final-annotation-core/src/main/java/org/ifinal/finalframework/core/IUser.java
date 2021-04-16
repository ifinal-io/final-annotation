package org.ifinal.finalframework.core;

import java.io.Serializable;

/**
 * The interface of {@code user} which impl the interface of {@link IEntity} in the system.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IUser<I extends Serializable> extends IEntity<I> {

    /**
     * return user name.
     *
     * @return user name.
     */
    String getName();

    /**
     * set user name.
     *
     * @param name user name.
     */
    void setName(String name);

}
