package org.ifinal.finalframework.core.result;

import org.ifinal.finalframework.core.IPage;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Page<T extends Serializable> extends Pagination implements IPage<T> {

    private List<T> data;

}

