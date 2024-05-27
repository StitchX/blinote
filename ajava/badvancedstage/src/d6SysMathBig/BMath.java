package d6SysMathBig;

import org.junit.Test;

/**
 * @Description:
 * java.lang.Math提供了一系列静态方法用于科学计算。返回值一般为double类型
 * @Author Eva
 * @Date 2023/2/13 16:23 -> 2024/5/27
 */
public class BMath {
    @Test
    public void test01(){
        System.out.println(Math.abs(1.234));
        System.out.println(Math.sqrt(2));
        System.out.println(Math.pow(2,4));
        System.out.println(Math.log(2)); // 自然对数
        System.out.println(Math.exp(2.12)); // e为低指数
        System.out.println(Math.random()); // 0~1的随机数
        System.out.println(Math.round(1.3));
        System.out.println(Math.toDegrees(1.33)); // 弧度转角度
        System.out.println(Math.toRadians(1.33)); // 角度转弧度
    }
}
