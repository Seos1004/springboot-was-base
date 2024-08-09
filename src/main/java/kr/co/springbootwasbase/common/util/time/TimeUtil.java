package kr.co.springbootwasbase.common.util.time;

import java.time.ZonedDateTime;

public class TimeUtil {

    public static String getCurrentTimestamp(ZoneIdEnum zoneID , TimeFormatEnum formatter) {
        return ZonedDateTime.now(zoneID.getZoneId()).format(formatter.getFormatter());
    }
}
