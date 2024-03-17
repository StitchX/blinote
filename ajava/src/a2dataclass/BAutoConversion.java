package a2dataclass;

/**
 * @Description: 自动类型转换
 * @Author Eva
 * @Date 2023/1/6 11:02 2024/3/16 20:06
 */

public class BAutoConversion {
      /*
    类型转换：
    数据类型转换必须满足如下规则：
        1. 不能对boolean类型进行类型转换。
        2. 不能把对象类型转换成不相关类的对象。
        3. 在把容量大的类型转换为容量小的类型时必须使用强制类型转换。
        4. 转换过程中可能导致溢出或损失精度

    自动类型转换：必须满足转换前的数据类型的位数要低于转换后的数据类型

     */

    public static void main(String[] args) {
        //        自动类型转换
//        byte,short,char—> int —> long—> float —> double
        char a1 = 'a';
        int b1 = a1;
//        System.out.println(a1+9); //106
        System.out.println(b1);  // 97

        short b2 = 2;
        System.out.println(b2+a1);  // byte,short,char类型运行，结果为int类型
        System.out.println('-');

        long ll = 123432L; // 不写l 默认为int类型
//        float ff1 = 123.3;  报错
    }
}
