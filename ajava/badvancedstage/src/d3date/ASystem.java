package d3date;

import org.junit.Test;

/**
 * @Description: JDK 8之前的时间和日期的API测试
 * @Author Eva
 * @Date 2023/2/13 17:13 -> 2024/5/26 17:09
 */

public class ASystem {
    //    1、System类中的currentTimeMillis()
    @Test
    public void test01(){
//        返回当前时间戳与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
//        时间戳
        long time = System.currentTimeMillis();
        System.out.println(time);
    }
}
