package d3date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/2/13 17:14 -> 2024/5/26 17:11
 */

public class CSimpleDateFormat {
    /*
    3、
    Date类的API大部分不利于国际化，大部分被废弃了，需要转换
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1. 两个操作：
    1.1 格式化：日期 ----> 字符串
    1.2 解析：格式化的逆过程，字符串 ---> 日期

    2. SimpleDateFormat的实例化
     */
    @Test
    public void test03() throws ParseException {
//   ------实例化SimpleDateFormat: 使用默认构造器-----
        SimpleDateFormat sdf1 = new SimpleDateFormat();

//        格式化：日期-->字符串
        Date date = new Date();
        System.out.println(date); // Thu Feb 09 15:16:37 CST 2023

        String format = sdf1.format(date);
        System.out.println(format);  // 2023/2/9 15:16

//        解析：格式化的逆过程，字符串 --> 日期
        String str = "2023/2/9 15:16";
        Date date01 = sdf1.parse(str); // 为了防止字符串格式错误
        System.out.println(date01);

//        -----------------按照指定的方式格式化和解析：调用带参的构造器-------------------
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");

//        格式化：
        String f1 = sdf2.format(date);
        System.out.println(f1); // 2023.二月.09 公元 03:23 下午

//        解析：要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数实现）
//        否则，抛异常
        Date date2 = sdf2.parse("2018-01-01 11:45:55");
        System.out.println(date2);
//
//        练习题一：将”2015-01-02“ 转换为java.sql.Date
//        练习题二：”三天打鱼两天筛网“ 1970-01-01 ****-**-**是打鱼？筛网（面试题）
//
//            方式一：总天数计算（毫秒数相减 /1000/60/60/24 +1）；%5: 0 4 晒网  1 2 3打鱼
//          方式二：先减去年数

    }
}
