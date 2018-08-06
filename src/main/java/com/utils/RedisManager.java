package com.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;
import java.util.Set;

public class RedisManager {
    private JedisPool pool = new JedisPool(new JedisPoolConfig(), "144.76.43.170", 6379, 2000, null, 1);

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

    public void setQuantityOfPlayedRoundsForAnHourInLast24HoursForPlayer(String userId, String quantity) {
        try (Jedis jedis = pool.getResource()) {
            jedis.set("achievements:player:" + userId + ":time_limited:24h:" + DateTime.now(DateTimeZone.UTC).minusHours(1).getHourOfDay(), quantity);
            //DateTimeZone.UTC - zero meridian, our redis have -3 time offset
        }
    }

    public void setQuantityOfPlayedRoundsForAnHourInLast48HoursForPlayer(String userId, String quantity) {
        try (Jedis jedis = pool.getResource()) {
            jedis.set("achievements:player:" + userId + ":time_limited:48h:" + DateTime.now(DateTimeZone.UTC).minusHours(30).getHourOfDay(), quantity);
            //DateTimeZone.UTC - zero meridian, our Redis have -3 time offset
        }
    }
}
