package kr.co.springboot_was_base.api.redis.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HashRedisAPIModel {
    private String userId;
    private String userRole;
}
