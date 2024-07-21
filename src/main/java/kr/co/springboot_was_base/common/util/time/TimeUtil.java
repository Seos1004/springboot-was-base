package kr.co.springboot_was_base.common.util.time;

import java.time.LocalDateTime;

public class TimeUtil {

    public static String getCurrentTimestamp(TimeFormatEnum formatter) {
        return LocalDateTime.now().format(formatter.getFormatter());
    }
}
