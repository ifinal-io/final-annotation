package org.ifinal.finalframework.monitor.annotation;

import org.ifinal.finalframework.core.annotation.IEnum;
import org.ifinal.finalframework.core.annotation.lang.Transient;

import lombok.Getter;

/**
 * 监控级别
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Transient
@Getter
public enum MonitorLevel implements IEnum<Integer> {
    TRACE(1, "TRACE"),
    DEBUG(2, "DEBUG"),
    INFO(3, "INFO"),
    WARN(4, "WARN"),
    ERROR(5, "ERROR");

    private final Integer code;

    private final String desc;

    MonitorLevel(final Integer code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

}
