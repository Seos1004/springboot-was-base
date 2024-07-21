package kr.co.springboot_was_base.common.util.time;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TimeUtil {

    public static String getCurrentTimestamp(TimeFormatEnum formatter) {
        return ZonedDateTime.now(ZoneOffset.UTC).format(formatter.getFormatter());
    }
}
