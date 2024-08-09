package kr.co.springbootwasbase.common.util.time;

import lombok.Getter;

import java.time.ZoneId;

@Getter
public enum ZoneIdEnum {

    SEOUL(ZoneId.of("Asia/Seoul")),
    NEW_YORK(ZoneId.of("America/New_York")),
    LONDON(ZoneId.of("Europe/London")),
    UTC(ZoneId.of("UTC"));

    private final ZoneId zoneId;

    ZoneIdEnum(ZoneId zoneId) {
        this.zoneId = zoneId;
    }


}
