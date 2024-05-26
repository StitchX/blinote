package d3date;

import org.junit.Test;

import java.time.Instant;
import java.time.ZoneOffset;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/2/13 17:20 -> 2024/5/26 17:30
 */

public class FInstant {

    /*
    java.time包通过值类型Instant提供机器视图，不提供处理人类意义上的时间单位。
    从1970年1月1日0时0分0秒（UTC）开始的秒数
    计算世界时间的主要标准有：
        UTC（Coordinated Universal Time）
        GMT（GreenwichMean Time）
        CST（Central Standard Time）
    Instant使用
        类似与java.util.Date类
     */
    @Test
    public void test02(){
        // 静态方法，默认返回UTC时区的时间
        Instant instant01 = Instant.now(); // 对应本初子午线
//        静态方法，返回1970.1.1 00:00:00基础上加上指定毫秒数之后的Instant类的对象
        Instant instant02 = Instant.ofEpochMilli(1000);

        System.out.println(instant01);
        System.out.println(instant02);

//        添加时间的偏移量
        System.out.println(instant01.atOffset(ZoneOffset.ofHours(8)));

//        从1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long t1 = instant01.toEpochMilli(); // DateTime中的getTime方法
        System.out.println(t1);

    }
}
