package org.ifinal.finalframework.data.annotation;

import org.ifinal.finalframework.core.IEntity;
import org.ifinal.finalframework.core.IEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 是否有效枚举，用于标记记录是否有效。
 *
 * @author likly
 * @version 1.0.0
 * @see IEntity
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum YN implements IEnum<Integer> {
    /**
     * 有效
     */
    YES(1, "有效"),
    /**
     * 无效
     */
    NO(0, "无效");

    /**
     * 枚举码
     */
    private final Integer code;

    private final String desc;

}
