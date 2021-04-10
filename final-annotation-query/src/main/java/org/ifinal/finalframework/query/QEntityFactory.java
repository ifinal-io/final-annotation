package org.ifinal.finalframework.query;

/**
 * QEntityFactory.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface QEntityFactory {

    QEntity<?, ?> create(Class<?> entity);

}
