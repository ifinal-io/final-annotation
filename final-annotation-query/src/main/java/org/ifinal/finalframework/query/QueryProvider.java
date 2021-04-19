package org.ifinal.finalframework.query;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface QueryProvider {

    String where();

    /**
     * @return
     * @see org.ifinal.finalframework.core.Groupable
     */
    String groups();

    /**
     * @return
     * @see org.ifinal.finalframework.core.Orderable
     */
    String orders();

    /**
     * @return
     * @see org.ifinal.finalframework.core.Limitable
     */
    String limit();

}
