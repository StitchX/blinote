package b2method;

/**
 * @Description: 值传递机制
 * @Author Eva
 * @Date 2024/3/17 18:04
 */

public class EByValue {
    /*
    关于变量的赋值：
        如果变量是基本数据类型，此时赋值的是变量所保存的数据值
        如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值
     */

    /*
    方法的形参的传递机制：值传递
    1. 形参：方法定义时，声明的小括号内的参数
       实参：方法调用时，实际传递给形参的数据

    2. 值传递机制：
        如果参数是基本数据类型，此时实参赋给形参的是实参真实存储的数据值。
        如果参数是引用数据类型，此时实参赋给形参的是实参存储数据的地址值。

     */


    int[] a = new int[]{1,2};

    public static void main(String[] args) {
        EByValue e = new EByValue();
        demo01(e.a); // 注意这里是地址传递
        System.out.println(e.a[0]); // 10
    }

    public static void demo01(int[] a){
        a[0] = 10;
        a[1] = 11;
    }
}

