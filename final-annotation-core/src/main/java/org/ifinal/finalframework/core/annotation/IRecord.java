package org.ifinal.finalframework.core.annotation;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IRecord<I extends Serializable, U extends IUser<I>> extends IEntity<I> {

    /**
     * return the record creator
     *
     * @return the record creator
     */
    @Nullable
    U getCreator();

    /**
     * set the record creator
     *
     * @param creator the record creator
     */
    void setCreator(@NonNull U creator);

    /**
     * return the record last modifier.
     *
     * @return the record last modifier.
     */
    @Nullable
    U getLastModifier();

    /**
     * set the record last modifier.
     *
     * @param modifier the record modifier.
     */
    void setLastModifier(@NonNull U modifier);

}