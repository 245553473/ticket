package com.line.ticket.mini.config.shard;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class LongPreciseShardingAlgorithm extends AbstractPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        long value = shardingValue.getValue();
        return getTargetName(availableTargetNames, value > Short.MAX_VALUE ? (int) (value >>> 16) : (int) value);
    }
}
