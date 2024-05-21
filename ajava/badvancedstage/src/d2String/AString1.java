package d2String;

import org.junit.Test;

/**
 * @Description: String的使用
 * @Author Eva
 * @Date 2024/5/20
 */
public class AString1 {
    /*
    String：字符串，使用一对”“引起来表示
    1. String声明为final的，不可被继承
    2. String实现了Serializable接口：表示字符串是支持序列化的。
        实现了Comparable接口：表示String可以比较大小
    3. String内部定义了final char[] value 用于存储字符串数据
    4. String：代表不可变的字符序列。简称：不可变性。
        体现：1. 当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
        2.当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
        3.当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域。
    5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
    6.字符串常量池中是不会存储相同内容的字符串的。
     */

    //    不可变性
    @Test
    public void test1(){
//        字面量的定义方式
        String str1 = "qwe"; // qwe存在常量池中 str1在栈中
        String str2 = "qwe";
        System.out.println(str1==str2); // 地址值相同
        String str3 = str1.replace("1234","p");
    }

    /*
    String的实例化方式：
    方式一：通过字面量定义的方式
    方式二：通过new+构造器的方式

    面试题：String s = new String("123")，在内存中创建了几个对象？
    两个：一个是堆空间中new结构，另一个是char[]对应的常量池中的数据："123"
     */
//    不同实例化方式对比
    @Test
    public void test2(){
//        通过new + 构造器的方式:此时的str1和str3保存的地址值，是数据在堆空间中开辟空间以后对应的地址值。
        String str1 = new String("1234"); // 存在堆中
        String str3 = new String("1234"); // 指向不同地址；地址都指向相同内容
//        通过字面量定义的方式：此时的s1和s2的数据Javaee声明在方法中的字符串常量池中
        String str2 = "1234"; // 存在常量池中

        System.out.println(str1==str2); // false  地址不一样
        System.out.println(str1==str3); // false  地址不一样
        System.out.println(str1.equals(str2)); // true；内容一致（补充前面面向对象的数据）
    }

    /*
    不同拼接操作的对比
    1. 常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量。
    2. 只要其中一个是变量，结果就在堆中
    3. 如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop"; // 面试题：final String s2 = "hadoop"；这是个常量

        String s3 = "javaEE"+"hadoop";
        String s4 = "javaEEhadoop";
        String s5 = "javaEE"+s2;
        String s6 = s1+"hadoop";
        String s7 = s1+s2;

        System.out.println(s3==s4); // true
        System.out.println(s3==s5);
        System.out.println(s3==s6);
        System.out.println(s3==s7); // false
        System.out.println(s5==s7); // false

        String s8 = s5.intern();
        System.out.println(s8==s3); // true

    }
}
//        String对象的创建：了解下原理
//        char[] a = {'1','2','3','4','5'};
//        String s1 = new String();
//        String s2 = new String("qwer");
//        String s3 = new String(a);
//        String s4 = new String(a,1,2);
