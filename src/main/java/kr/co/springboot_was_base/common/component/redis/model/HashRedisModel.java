package kr.co.springboot_was_base.common.component.redis.model;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
public class HashRedisModel {
    private String key;
    private Integer expireTime;
    private List<Create> elements;
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Create {
        private String key;
        private Object value;
    }
}
