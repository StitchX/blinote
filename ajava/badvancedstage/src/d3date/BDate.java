package d3date;

import org.junit.Test;

import java.util.Date;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/2/13 17:14 -> 2024/5/26 17:10
 */

public class BDate {
    /*
    2、
    java.util.Date类
        |---java.sql.Date类 （都代表时间，还是子父类关系）
    1. 两个构造器的使用
        > 构造器一：Date(): 创建一个对应当前时间的Date对象
        > 构造器二：创建指定毫秒数的Date对象

    2. 两个方法的使用
        > toString(): 显示当前的年、月、日、时、分、秒
        > getTime(): 获取当前Date对象对应的毫秒数。（时间戳）

    3. java.sql.Date对应着数据库中的日期类型的变量
        > 如何实例化
        > 如何将java.lang.Date对象转换为java.lang.Date对象
     */
    @Test
    public void test02(){
//        构造器一：Date(): 创建一个对应当前时间的Date对象
        Date date01 = new Date();
        System.out.println(date01.toString()); //Thu Feb 09 14:25:37 CST 2023

        System.out.println(date01.getTime()); //1675923964041

//        构造器二：创建指定毫秒数的Date对象
        Date date02 = new Date(167592396404L);
        System.out.println(date02);

//        创建java.sql.Date对象
        java.sql.Date date03 = new java.sql.Date(167592396404L);
        System.out.println(date03); // 1975-04-25

//        如何将java.lang.Date对象转换为java.sql.Date对象
//        情况一： (这样也可以，比较勉强)
//        Date date04 = new java.sql.Date(167592396404L);
//        java.sql.Date date05 = (java.sql.Date) date04;

//        情况二：
        Date date6 = new Date();
        java.sql.Date date07 = new java.sql.Date(date6.getTime());
    }
}
