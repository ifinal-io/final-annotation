package org.ifinal.finalframework.cache.annotation.data;

import org.ifinal.finalframework.core.annotation.IUser;

import lombok.Getter;
import lombok.Setter;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Setter
@Getter
public class AbsUser implements IUser<Long> {

    @PrimaryKey
    private Long id;

    private String name;

}

