package com.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;
import java.util.Set;

public class RedisManager {
    JedisPool pool = new JedisPool(new JedisPoolConfig(), "144.76.43.170", 6379, 2000, null, 1);

    public void doQuery() {
        try (Jedis jedis = pool.getResource()) {

            for (Map.Entry<String, String> entry : jedis.hgetAll("achievements:player:48754184:return_group").entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
            }

        }
    }

    public void close() {
        pool.close();
    }

    public void addGameEventForDates(String userId, Set<String> datesOfGames) {
        for (String date : datesOfGames) {
            try (Jedis jedis = pool.getResource()) {
                jedis.hset("achievements:player:" + userId + ":return_group", date, "1");
            }
        }
    }

    public void setQuantityOfPlayedRoundsForPlayer(String userId, String quantity) {
            try (Jedis jedis = pool.getResource()) {
                jedis.set("achievements:player:" + userId + ":total_played_games", quantity);
            }
    }
}
