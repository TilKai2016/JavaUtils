package utils;

import java.util.Calendar;

/**
 * @author tilkai
 */
public class DateUtils {
    /**
     * 获取今天起始时间
     * @param calendar
     * @return
     */
    public static Calendar getStartOfDay(Calendar calendar) {
        Calendar time = (Calendar) calendar.clone();
        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);
        return time;
    }

    public static Calendar getStartOfNextDay(Calendar calendar) {
        Calendar time = getStartOfDay(calendar);
        time.add(Calendar.DAY_OF_MONTH, 1);
        return time;
    }

    /**
     * 获取今天的结束时间
     * @param calendar
     * @return
     */
    public static Calendar getEndOfDay(Calendar calendar) {
        Calendar time = (Calendar) calendar.clone();
        time.set(Calendar.HOUR_OF_DAY, 23);
        time.set(Calendar.MINUTE, 59);
        time.set(Calendar.SECOND, 59);
        time.set(Calendar.MILLISECOND, 0);
        return time;
    }

    /**
     * 获取本小时开始时间
     * @param calendar
     * @return
     */
    public static Calendar getStartOfHour(Calendar calendar) {
        Calendar time = (Calendar) calendar.clone();
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);
        return time;
    }

    /**
     * 获取下一小时开始时间
     * @param calendar
     * @return
     */
    public static Calendar getStartOfNextHour(Calendar calendar) {
        Calendar time = getStartOfHour(calendar);
        time.add(Calendar.HOUR_OF_DAY, 1);
        return time;
    }

    public static Calendar getStartOfMonth(Calendar calendar) {
        Calendar time = (Calendar) calendar.clone();
        time.set(Calendar.DAY_OF_MONTH, 1);
        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);
        return time;
    }

    public static Calendar getStartOfNextMonth(Calendar calendar) {
        Calendar time = getStartOfMonth(calendar);
        time.add(Calendar.MONTH, 1);
        return time;
    }

    public static Calendar getStartOfYear(Calendar calendar) {
        Calendar time = (Calendar) calendar.clone();
        time.set(Calendar.MONTH, 0);
        time.set(Calendar.DAY_OF_MONTH, 1);
        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);
        return time;
    }

    public static Calendar getStartOfNextYear(Calendar calendar) {
        Calendar time = getStartOfYear(calendar);
        time.add(Calendar.YEAR, 1);
        return time;
    }

    public static Calendar getLastSecond(Calendar calendar) {
        Calendar time = (Calendar) calendar.clone();
        time.add(Calendar.SECOND, -1);
        return time;
    }

    /**
     * 获取指定时间所在自然周的开始时间
     * @param calendar
     * @return
     */
    public static Calendar getStartOfThisWeek(Calendar calendar) {
        Calendar time = getStartOfDay(calendar);

        time.setFirstDayOfWeek(Calendar.MONDAY);
        time.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return time;
    }

    /**
     * 获取指定时间下一自然周的开始时间
     * @param calendar
     * @return
     */
    public static Calendar getStartOfNextWeek(Calendar calendar) {
        Calendar time = getStartOfThisWeek(calendar);

        time.add(Calendar.DAY_OF_MONTH, 7);
        return time;
    }

    /**
     * 格式化给定字符串，给定字符串为空时返回当前时间
     * @param integerOfDate 日期格式字符串
     * @return
     */
    public static Calendar getDateTimeFormat(Integer integerOfDate) {

        String tempStr = "";
        Calendar resultDateTime = Calendar.getInstance();

        if (integerOfDate != null && !"".equals(integerOfDate)) {
            String dateStr = String.valueOf(integerOfDate);
            if (dateStr.length() == 8) {
                String reg = "(\\d{4})(\\d{2})(\\d{2})";
                tempStr = dateStr.replaceAll(reg, "$1-$2-$3");

                String[] timeArray = tempStr.split("-");
                resultDateTime.set(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]) - 1, Integer.parseInt(timeArray[2]));
            } else if (dateStr.length() == 6) {
                String reg = "(\\d{4})(\\d{2})";
                tempStr = dateStr.replaceAll(reg, "$1-$2");

                String[] timeArray = tempStr.split("-");
                resultDateTime.set(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]) - 1, 1);
            } else if (dateStr.length() == 4) {
                resultDateTime.set(Calendar.YEAR, Integer.parseInt(dateStr));
            }
        }

        return resultDateTime;
    }
}
