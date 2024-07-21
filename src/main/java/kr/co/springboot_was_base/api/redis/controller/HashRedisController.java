package kr.co.springboot_was_base.api.redis.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kr.co.springboot_was_base.api.redis.enums.HashRedisAPIResponseEnum;
import kr.co.springboot_was_base.api.redis.enums.HashRedisExceptionResponseEnum;
import kr.co.springboot_was_base.api.redis.model.HashRedisAPIModel;
import kr.co.springboot_was_base.common.response.model.APIResponseModel;
import kr.co.springboot_was_base.common.util.model.ModelUtil;
import kr.co.springboot_was_base.common.util.redis.HashRedisUtil;
import kr.co.springboot_was_base.common.util.redis.model.HashRedisModel;
import kr.co.springboot_was_base.config.exception.custom.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/hash")
@Tag(name = "REDIS" , description = "레디스 컨트롤러")
public class HashRedisController {

    private final HashRedisUtil hashRedisUtil;

    @Operation(summary = "hash 조회")
    @GetMapping("/{key}")
    public APIResponseModel<HashRedisAPIModel> getHashType(
            @PathVariable("key") String key,
            @Parameter(hidden = true) @Valid HashRedisAPIModel.GetHashTypeRequestModel getHashTypeRequestModel)
    {
        //todo 1. sample 컨트롤러 , @Valid 인자별 터지는거 정리해서 주석
        //todo 2. 레디스 케이스별 코드
        //todo 3. restCLient
        //todo 4. custom e
        //todo 5. mybatis
        //todo 6. security
        //todo 7.각종 유틸
        if(Objects.equals(key, "qwe")){
            throw new BusinessException(HashRedisExceptionResponseEnum.FAIL , "ㅂㅈㄷ");
        }
        HashRedisAPIModel hashRedisModel = hashRedisUtil.getHash(key , HashRedisAPIModel.class);
        return new APIResponseModel<>(
                HashRedisAPIResponseEnum.REDIS_SUCCESS_ARGS_TEST ,
                hashRedisModel ,
                "sadf","111","zzzz"
        );
    }

/*    @Operation(summary = "hash 추가")
    @PostMapping("/{key}")
    public APIResponseModel<Void> createHashTypeKey(
            @PathVariable("key") String key,
            @RequestBody @Valid List<HashRedisModel> createKeyModels,
            @RequestParam(value = "expireTime", required = true) int expireTime) {
        hashRedisUtil.createHashKey(key, createKeyModels, expireTime);
        return new APIResponseModel<>(HashRedisAPIResponseEnum.REDIS_SUCCESS);
    }*/
    @Operation(summary = "hash 추가")
    @PostMapping("/{key}")
    public APIResponseModel<Void> createHashTypeKey(
            @RequestBody @Valid List<HashRedisAPIModel.HashRedisCreate> createKeyModels) {
        hashRedisUtil.createHashKey("", ModelUtil.copyList(createKeyModels , HashRedisModel.class) , 1);
        return new APIResponseModel<>(HashRedisAPIResponseEnum.REDIS_SUCCESS);
    }
}


