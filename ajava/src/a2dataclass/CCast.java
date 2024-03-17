package a2dataclass;

/**
 * @Description:强制类型转换
 * @Author Eva
 * @Date 2023/1/6 11:02 2024/3/16 20:07
 */

public class CCast {

    /*
    强制类型转换：条件是转换的数据类型必须是兼容的。
    隐含强制类型转换
        1、 整数的默认类型是 int。
        2、 小数默认是 double 类型浮点型，在定义 float 类型时必须在数字后面跟上 F 或者 f。
     */

    public static void main(String[] args) {
        //        强制类型转换
        int c1 = 65;
//        char d1 = c1;   // 报错
        char d1 = (char) c1;
        System.out.println(d1);   // A
        int ff=99999;
        short gg = (short) ff;
        System.out.println(gg);  // -31073
    }
}
