package kr.co.springboot_was_base.common.component.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.springboot_was_base.common.component.redis.enums.CreateHashKeyResultEnum;
import kr.co.springboot_was_base.common.component.redis.model.HashRedisModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Component
public class HashRedisComponent {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    public <T> T getHash(String key , Class<T> returnClass){
        log.info("[HashRedisUtil.getHashType] START {}" , key);
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
        if(entries.isEmpty()){
            log.info("[HashRedisUtil.getHashType] {} is empty" , key);
            return null;
        } else {
            log.info("[HashRedisUtil.getHashType] entries ? : {}" , entries);
            log.info("[HashRedisUtil.getHashType] END {}" , key);
            return objectMapper.convertValue(entries, returnClass);
        }
    }

    public <T> T getHashValue(String key , String hashKey , Class<T> returnClass){
        log.info("[HashRedisUtil.getHashTypeDetail] START {}.{}" , key , hashKey);
        Object result = redisTemplate.opsForHash().get(key , hashKey);
        if(result != null) {
            log.info("[HashRedisUtil.getHashTypeDetail] END {}.{}" , key , hashKey);
            log.info("result ? : {}" , result);
            return objectMapper.convertValue(result, returnClass);
        } else {
            return null;
        }
    }

    public CreateHashKeyResultEnum createHashKey(HashRedisModel hashRedis){
        log.info("[HashRedisUtil.addRedis] START {}.{}" , hashRedis.getKey() , hashRedis.getExpireTime());
        String key = hashRedis.getKey();
        Integer expireTime = hashRedis.getExpireTime();
        if(key.isEmpty() || key.isBlank()){
            log.info("[HashRedisUtil.addRedis] ket is empty or blank : {}" , key);
            return CreateHashKeyResultEnum.FAILURE_DUE_TO_KEY;
        }
        if(hashRedis.getElements() == null || hashRedis.getElements().isEmpty()){
            log.info("[HashRedisUtil.addRedis] hashRedisCreateList list is null or size is 0 : {}" , hashRedis.getElements());
            return CreateHashKeyResultEnum.ELEMENTAL_FAILURE;
        }
        if(expireTime <= 0){
            log.info("[HashRedisUtil.addRedis] expireTime 0 : {}" , expireTime);
            return CreateHashKeyResultEnum.FAILURE_DUE_TO_EXPIRATION_TIME;
        }
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashRedis.getElements().forEach(model ->
                hashOperations.put(key, model.getKey(), model.getValue())
        );
        redisTemplate.expire(key, expireTime, TimeUnit.MILLISECONDS);
        log.info("[HashRedisUtil.addRedis] END {}.{}" , key , expireTime);
        return CreateHashKeyResultEnum.SUCCESS;
    }

    public void deleteHashKey(String key){
        log.info("[HashRedisUtil.removeKey] START {}" , key);
        redisTemplate.delete(key);
        log.info("[HashRedisUtil.removeKey] END {}" , key);
    }

    public boolean deleteHashEntry(String key , String rowKey){
        log.info("[HashRedisUtil.removeHashTypeRow] START {}.{}" , key , rowKey);
        Long deleteCount = redisTemplate.opsForHash().delete(key, rowKey);
        if (deleteCount > 0) {
            log.info("[HashRedisUtil.removeHashTypeRow] END {}.{}" , key , rowKey);
            return true;
        } else {
            log.info("[HashRedisUtil.removeHashTypeRow] no key deleted");
            return false;
        }
    }
}
