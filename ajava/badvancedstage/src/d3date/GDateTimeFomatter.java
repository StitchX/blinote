package d3date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/2/13 17:20 -> 2024/5/26 17:40
 */

public class GDateTimeFomatter {
    /*
    DateTimeFomatter类：格式化或解析日期、时间
    类似于：SimpleDateFormat

     */
    @Test
    public void test03(){
//        三种声明方式
//        方式一：预定义的标准格式，如：ISO_LOCAL_DATE_TIME，ISO_LOCAL_DATE，ISO_LOCAL_TIME
        DateTimeFormatter dtf01 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//        格式化：日期———>字符串
        String str = dtf01.format(LocalDateTime.now());
        System.out.println(str);

//        解析：字符串-->日期
        TemporalAccessor t1 = dtf01.parse("2023-02-13T10:38:59.784912");
        System.out.println(t1);

//        方式二：
//        本地化相关的格式。如：ofLocalizedDateTime()
//        FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT
        DateTimeFormatter dtf02 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //        格式化：日期———>字符串
        System.out.println(dtf02.format(LocalDateTime.now()));

//        本地化相关的格式。如：ofLocalizedDateTime()
//        FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT/FormatStyle.FULL：适用于LocalDate
        DateTimeFormatter dtf03 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(dtf03.parse("2023/2/13"));

//        重点：方式三：自定义的格式：如：ofPattern("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter dtf04 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
//        格式化
        String s1 = dtf04.format(LocalDateTime.now());
        System.out.println(s1);
//
    }
}
