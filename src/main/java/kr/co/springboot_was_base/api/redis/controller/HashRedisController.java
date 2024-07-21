package kr.co.springboot_was_base.api.redis.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.springboot_was_base.api.redis.enums.HashRedisResponseEnum;
import kr.co.springboot_was_base.api.redis.model.HashRedisAPIModel;
import kr.co.springboot_was_base.common.response.model.APIResponseModel;
import kr.co.springboot_was_base.common.util.redis.HashRedisUtil;
import kr.co.springboot_was_base.common.util.redis.model.HashRedisModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/hash")
@Tag(name = "REDIS" , description = "레디스 컨트롤러")
public class HashRedisController {

    private final HashRedisUtil hashRedisUtil;


    @Operation(summary = "hash 조회")
    @GetMapping("/{key}")
    public APIResponseModel<HashRedisAPIModel> getHashType(@PathVariable String key) {
        //todo 레디스 케이스별 코드
        //todo restCLient
        //todo custom e
        //todo mybatis
        //todo security
        //todo 각종 유틸
        HashRedisAPIModel hashRedisModel = hashRedisUtil.getHash(key , HashRedisAPIModel.class);
        return new APIResponseModel<>(HashRedisResponseEnum.REDIS_SUCCESS_ARGS_TEST , hashRedisModel ,"sadf","111","zzzz");
    }

    @Operation(summary = "Create a hash in Redis.")
    @PostMapping("/createHashTypeKey/{key}")
    public APIResponseModel<Void> createHashTypeKey(@PathVariable String key, @RequestBody List<HashRedisModel> createKeyModels, @RequestParam int expireTime) {
        hashRedisUtil.createHashKey(key, createKeyModels, expireTime);
        return new APIResponseModel<>(HashRedisResponseEnum.REDIS_SUCCESS , null);
    }
}


