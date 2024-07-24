package kr.co.springboot_was_base.common.util.time;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TimeUtil {

    public static String getCurrentTimestamp(ZoneIdEnum zoneID , TimeFormatEnum formatter) {
        return ZonedDateTime.now(zoneID.getZoneId()).format(formatter.getFormatter());
    }
}
