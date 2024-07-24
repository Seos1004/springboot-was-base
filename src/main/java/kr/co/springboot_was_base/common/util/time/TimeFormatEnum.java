package kr.co.springboot_was_base.common.util.time;

import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public enum TimeFormatEnum {

    DATE_TIME_MILLIS_UTC("yyyy-MM-dd HH:mm:ss.SSS'Z'"),
    DATE_TIME_MILLIS("yyyy-MM-dd HH:mm:ss.SSS"),
    DATE_TIME_SECONDS_UTC("yyyy-MM-dd HH:mm:ss'Z'"),
    DATE_TIME_SECONDS("yyyy-MM-dd HH:mm:ss"),
    DATE_ONLY("yyyy-MM-dd"),
    TIME_ONLY_HOURS_MINUTES_UTC("HH:mm'Z'"),
    TIME_ONLY_HOURS_MINUTES("HH:mm"),
    TIME_ONLY_HOURS_MINUTES_SECONDS_UTC("HH:mm:ss'Z'"),
    TIME_ONLY_HOURS_MINUTES_SECONDS("HH:mm:ss");



    private final DateTimeFormatter formatter;

    TimeFormatEnum(String pattern) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

}
