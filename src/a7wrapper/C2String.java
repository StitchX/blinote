package a7wrapper;

/**
 * @Description: 值传递机制，String比较特殊
 * @Author Eva
 * @Date 2024/3/17 16:18
 */

public class C2String {
    public static void main(String[] args) {
        Demo01 d1 = new Demo01();

        String str1 = "Hello";
        d1.strDemo(str1);

        System.out.println(str1); // hello
//        原因：String底层是char类型数组，不可变；
//        数据（“Hello”）存在【方法区的常量池】
//        str1 在栈中，存地址值
//        str1 = str2 地址值相同
//        新建一个“Hi~”，str2指向新地址值
        String a1 = "a1";
        String a2 = a1;
        a2 = "a2";
        System.out.println(a1);
        System.out.println(a2);
    }
}

