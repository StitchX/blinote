package a2dataclass;

/**
 * @Description: 数据类型
 * @Author Eva
 * @Date 2023/1/6 11:02 2024/3/16 19:56
 */

public class ADataClass {
    // 变量就是申请内存来存储值：内存管理系统根据变量的类型为变量分配存储空间，分配的空间只能用来储存该类型数据
    /*
   强类型语言，对应JavaScript为弱类型语言
   Java 的两大数据类型:
       一、基本(内置)数据类型（8种primitive type）：
           数值型(二进制补码表示)：
               整数类型：byte 1字节长、short 2、int 4、long 8
               浮点类型：float 4字节长、double 8
           字符型：char 2字节长
           布尔型：boolean
       二、引用数据类型(3种reference type)：
           类：class（String，类 类型）
           接口：（interface）
           数组：(array)
    */
//    内置八种数据类型：
    byte a2 = 1;  // 默认值是 0
    short a3 = 2; // 默认值是 0
    int a4 = 4;// 默认值是 0
    long a5 = 8L;  // 默认值是 0L

    float f1 = 1.9f; // 默认值是 0.0f
    double d1 = 1.5;   // 默认值是 0.0d

    char c1 = '\u0000'; // 默认 '\u0000'
    boolean b1 = false;  // 默认值是 false

//  对象、数组；所有引用类型的默认值都是null；一个引用变量可以用来引用任何与之兼容的类型

    public static void main(String[] args) {
        System.out.println(new ADataClass().c1);
    }

}
