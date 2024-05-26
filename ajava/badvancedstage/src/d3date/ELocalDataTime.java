package d3date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/2/13 17:20 -> 2024/5/26 17:25
 */

public class ELocalDataTime {
    /*
    localDate,localTime,localDateTime的使用
    说明：
        1、localDateTime相较于localDate(日期)，localTime（时间点），使用频率要高
        2、类似于Calendar
        3、分别使用ISO-8611（国际化组织制定的现代公民的日期和时间的表示，也是公历）日历系统的时间
     */
    @Test
    public void test01(){
//        now(): 获取当前的日期、时间、日期+时间
        LocalDate localDate01 = LocalDate.now();
        LocalTime localTime01 = LocalTime.now();
        LocalDateTime localDateTime01 = LocalDateTime.now();
        System.out.println(localDate01);
        System.out.println(localTime01);
        System.out.println(localDateTime01);
        System.out.println("--------------------------");
//        of()：设置指定的年、月、日、时、分、秒，没有偏移量
        LocalDateTime localDateTime02 = localDateTime01.of(2020,10,9,10,10,10);
        System.out.println(localDateTime02);
        System.out.println("================================");
//        getXxx()：获取相关的属性
        System.out.println(localDateTime02.getDayOfMonth());
        System.out.println(localDateTime02.getDayOfWeek());
        System.out.println(localDateTime02.getMinute());
        System.out.println(localDateTime02.getMonthValue()); // 10
        System.out.println(localDateTime02.getMonth()); // OCTOBER

//        体现不可变性
//        withXxx()：设置相关的属性
        LocalDate localDate02 = localDate01.withDayOfMonth(22);
        System.out.println(localDate01); // 2023-02-09
        System.out.println(localDate02); // 2023-02-22

        LocalDateTime localDateTime03 = localDateTime01.withHour(4);
        System.out.println(localDateTime01); // 2023-02-09T17:15:17.577821300
        System.out.println(localDateTime03); // 2023-02-09T04:15:17.577821300

//        不可变性
        LocalDateTime localDateTime04 = localDateTime01.minusDays(6); // 当前日期减6天
        LocalDateTime localDateTime05 = localDateTime01.plusDays(2); // 当前日期加2天
        System.out.println(localDateTime04); // 2023-02-03T17:15:17.577821300
        System.out.println(localDateTime05);

    }
}

/*
    Calendar和Date的问题：
    1、可变性：像日期和时间这样的类应该是不可变的
    2、偏移性：Date中年份是会加上1900，月份从0开始算
    3、格式化：格式化只对Date有用，Calendar则不行
    此外，它们也不是线程安全的：不能处理闰秒

    总结：对日期和时间的操作一直是Java程序员最痛苦的地方之一

    第三次引入API是成功的，并且java 8中引入的java.time API已经纠正了过去的缺陷，将来很长一段时间它都会为我们服务
    Java 8 吸收了Joda-Time的精华
     */
    /*
    新日期的API：
    java.time
    java.time.chrono
    java.time.format
    java.time.temporal
    java.time.zone

    说明：大多数开发者只会用到基础包format包，也可能会用到temporat包，因此，尽管有69个新公开类型，
        大多数开发者，大概将指挥用到其中的三分之一
     */
