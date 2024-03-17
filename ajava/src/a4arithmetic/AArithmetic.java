package a4arithmetic;

/**
 * @Description:算术
 * @Author Eva
 * @Date  2023/1/6 11:07 2024/3/16 20:37
 */

public class AArithmetic {
    /*
    算术运算符：加减乘除 取余 自增 自减
    关系运算符：等于 小于 大于 不等于 大于等于 小于等于
    位运算符：与&   或|   非~   异或^   左移<<   右移>>    右移补零>>>
    逻辑运算符：与&&   或||   非!
    赋值运算符：=; + - * % / << >> & ^ |=;
    其他运算符：条件（三元）运算符；instanceof 运算符

    优先级
     */

    public static void main(String[] args) {
        int a=5;
        int b=5;
        int x=2*++a; //12
        int y=2*b++;  //10
        System.out.println(x);
        System.out.println(y);


        boolean d = true;
        boolean e=false;
        System.out.println(!(d||e));
        System.out.println(d||e);

//        短路逻辑运算符
//        当使用与逻辑运算符时，在两个操作数都为true时，结果才为true，但是当得到第一个操作为false时，其结果就必定是false，这时候就不会再判断第二个操作了。
        int f=8;
        boolean g = (f<7)&&(f++<8);
        System.out.println(g); // false
        System.out.println(f);  // 8


        int h=8;
        h %=3;
        System.out.println(h);  // 2


//        三元
        int j = (h==2)? 20 : 30;
        System.out.println(j);  // 20

//        instanceof 检查该对象是否是一个特定类型（类类型或接口类型）
        AArithmetic a6 = new AArithmetic();
        boolean m = a6 instanceof AArithmetic;
        System.out.println(m);

        System.out.println(2 ^ 3); //10 11
    }
}
