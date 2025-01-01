package com.hit.counter;

import java.time.Instant;

public class CounterServiceImpl implements CounterService {

    private final RedisService redisService;

    public CounterServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public void hitRequest(Instant ts) {
        redisService.request(ts);
    }

    @Override
    public long requestCountInLastOneHour(Instant ts) {
        return redisService.getCount(ts);
    }
}
