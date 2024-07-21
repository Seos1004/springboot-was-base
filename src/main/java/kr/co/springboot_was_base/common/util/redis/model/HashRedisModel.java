package kr.co.springboot_was_base.common.util.redis.model;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HashRedisModel {
    private String key;
    private Object value;
}
