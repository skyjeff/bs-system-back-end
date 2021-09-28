package com.bssystem.service.config;

import com.bssystem.commons.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 一周有多少秒
     */
    private static final long WEEK_SECONDS = 7 * 24 * 60 * 60;


    /**
     * 将 key，value 存放到redis数据库中，默认设置过期时间为一周
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, JsonUtil.convertObj2String(value), WEEK_SECONDS, TimeUnit.SECONDS);
    }

    /**
     * 将 key，value 存放到redis数据库中，设置过期时间单位是秒
     *
     * @param key
     * @param value
     * @param expireTime
     */
    public void set(String key, Object value, long expireTime) {
        redisTemplate.opsForValue().set(key, JsonUtil.convertObj2String(value), expireTime, TimeUnit.SECONDS);
    }

    /**
     * 判断 key 是否在 redis 数据库中
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 获取与 key 对应的对象
     *
     * @param key
     * @param clazz 目标对象类型
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        String s = get(key);
        if (s == null) {
            try {
                // 如果是int double long 返回0
                Method method = clazz.getMethod("valueOf", new Class[]{String.class});
                return (T) method.invoke(null, new Object[]{"0"});
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return JsonUtil.convertString2Obj(s, clazz);
    }

    /**
     * 获取 key 对应的字符串
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取 list 对应value
     */
    public List<String> getList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 获取 list 对应value通过范围
     */
    public List<String> getListByRange(String key, long l, long r) {
        return redisTemplate.opsForList().range(key, l, r);
    }

    /**
     * 删除 key 对应的 value
     *
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }


    /**
     * 根据 key 获取相应的list
     *
     * @param key
     * @param clz
     * @param <T>
     * @return
     */
    public <T> List<T> getList(String key, Class<T> clz) {
        List<String> jsonList = getList(key);
        List<T> correctList = new ArrayList<>();
        if (jsonList != null) {
            for (String json : jsonList) {
                correctList.add(JsonUtil.toBean(json, clz));
            }
            return correctList;
        }
        return null;
    }

    /**
     * 获取在[l,r]范围内的list
     *
     * @param key
     * @param clz
     * @param l
     * @param r
     * @param <T>
     * @return
     */
    public <T> List<T> getListByRange(String key, Class<T> clz, long l, long r) {
        List<String> jsonList = getListByRange(key, l, r);
        List<T> correctList = new ArrayList<>();
        if (jsonList != null) {
            for (String json : jsonList) {
                correctList.add(JsonUtil.toBean(json, clz));
            }
            return correctList;
        }
        return null;
    }

    /**
     * 获取list的大小
     *
     * @param key
     */
    public long getListSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 根据 key 从队头加入元素(list)
     *
     * @param key
     * @param obj
     * @return
     */
    public long lpush(final String key, Object obj) {
        final String value = JsonUtil.toJson(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.lPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
        return result;
    }

    /**
     * 设置redis过期时间 根据 key 从队头加入元素(list)
     *
     * @param key
     * @param obj
     * @return
     */
    public long lpush(final String key, Object obj, long expireTime) {
        final String value = JsonUtil.toJson(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.lPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
        expire(key, expireTime);
        return result;
    }

    /**
     * 根据 key 从队尾加入元素(list)
     *
     * @param key
     * @param obj
     * @return
     */
    public long rpush(final String key, Object obj) {
        final String value = JsonUtil.toJson(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
        return result;
    }

    /**
     * 设置redis过期时间 根据 key 从队尾加入元素(list)
     *
     * @param key
     * @param obj
     * @param expireTime
     * @return
     */
    public long rpush(final String key, Object obj, long expireTime) {
        final String value = JsonUtil.toJson(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
        expire(key, expireTime);
        return result;
    }

    /**
     * 根据 key 出队
     *
     * @param key
     * @return
     */
    public String lpop(final String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] res = connection.lPop(serializer.serialize(key));
                return serializer.deserialize(res);
            }
        });
        return result;
    }

    // ------ set -----

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    public Set<String> sGet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean sHasKey(String key, String value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param key
     * @param obj
     * @return
     */
    public long sSet(String key, Object obj) {
        final String value = JsonUtil.toJson(obj);
        try {
            return redisTemplate.opsForSet().add(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 直接存String
     *
     * @param key
     * @param value
     * @return
     */
    public long sSet(String key, String value) {
        try {
            return redisTemplate.opsForSet().add(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSet(String key, String... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将set数据放入缓存
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSetAndTime(String key, long time, String... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) expire(key, time);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    public long sGetSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public long setRemove(String key, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // ------ hash -----

    /**
     * 将hash数据放入缓存
     *
     * @param key     redis的key
     * @param hashKey hash的key
     * @param value   hash的value
     */
    public void hSet(String key, String hashKey, String value) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将hash数据放入缓存
     *
     * @param key     redis的key
     * @param hashKey hash的key
     * @param obj     hash的value
     */
    public void hSet(String key, String hashKey, Object obj) {
        final String value = JsonUtil.toJson(obj);
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将set数据放入缓存
     *
     * @param key     redis的key
     * @param hashKey hash的key
     * @param values  值 可以是多个
     * @return 成功个数
     */
    public void hSet(String key, String hashKey, String... values) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, values);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断hashkey是否存在
     *
     * @param key     redis的key
     * @param hashKey hash的key
     * @return 成功个数
     */
    public Boolean hHasKey(String key, String hashKey) {
        try {
            return redisTemplate.opsForHash().hasKey(key, hashKey);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据hashKey获得值
     *
     * @param key     redis的key
     * @param hashKey hash的key
     * @return 成功个数
     */
    public String hGet(String key, String hashKey) {
        try {
            return (String) redisTemplate.opsForHash().get(key, hashKey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据Key获得值
     *
     * @param key redis的key
     * @return 成功个数
     */
    public Map<Object, Object> hGetAll(String key) {
        try {
            return redisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}