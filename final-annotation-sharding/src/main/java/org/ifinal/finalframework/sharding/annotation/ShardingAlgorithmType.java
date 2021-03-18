package org.ifinal.finalframework.sharding.annotation;

import org.apache.shardingsphere.sharding.algorithm.sharding.datetime.IntervalShardingAlgorithm;
import org.apache.shardingsphere.sharding.algorithm.sharding.inline.InlineShardingAlgorithm;
import org.apache.shardingsphere.sharding.algorithm.sharding.mod.HashModShardingAlgorithm;
import org.apache.shardingsphere.sharding.algorithm.sharding.mod.ModShardingAlgorithm;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ShardingAlgorithmType {
    /**
     * @see InlineShardingAlgorithm#getType()
     */
    INLINE,
    /**
     * @see ModShardingAlgorithm#getType()
     */
    MOD,
    /**
     * @see HashModShardingAlgorithm#getType()
     */
    HASH_MOD,

    /**
     * @see IntervalShardingAlgorithm#getType()
     */
    INTERVAL,

    HINT_INLINE,

    COMPLEX_INLINE,

    CLASS_BASED
}
