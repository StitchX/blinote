package b2method;

/**
 * @Description: 匿名对象，穿插其他解释
 * @Author Eva
 * @Date 2024/3/17 17:57
 */

public class BAnonymous {
    /*
    一、理解“万事万物皆对象”
    1. 在Java语言范畴中，我们都将功能、结构等封装到类中，通过类的实例化，来调用具体的功能结构
        > Scanner，String等
        > 文件：file
        > 网络资源：URL
    2. 涉及到Java语言与前端HTML、后端的数据库交互时，前后端的结构在Java层面交互时，都体现为类、对象

    二、内存解析
        1. 引用类型的变量，只可能存储两类值：null 或 地址值（含变量类型）

    三、匿名对象的使用
    1. 理解：我们创建的对象，没有显示的赋值给一个变量名。即位匿名对象
    2. 特征：匿名队形只能调用一次
    3. 使用：如下
     */
    public static void main(String[] args) {
        System.out.println(new AMethod().demo01(20));
    }
}

