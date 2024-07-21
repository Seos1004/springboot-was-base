package kr.co.springboot_was_base.api.redis.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
public class HashRedisAPIModel {

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class HashRedisCreate {

        @Size(min = 1 , max = 20 , message = "1 ~ 20 사이")
        private String key;

        @NotNull(message = "비어있을 수 없음")
        private String value;

    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class GetHashTypeRequestModel {

        @NotBlank
        private String te;
        @NotBlank
        private String tee;

    }
}
