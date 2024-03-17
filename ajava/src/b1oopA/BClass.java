package b1oopA;

/**
 * @Description:体会下类的设计
 * @Author Eva
 * @Date 2024/3/17 17:25
 */

/*
一、设计类：其实就是设计类的成员
    属性 = 成员变量 = field = 域、字段
    方法 = 成员方法 = 函数 = method

    创建类的对象 = 类的实例化 = 实例化类

二、类和对象的使用（面向对象思想落地的实现）
    1. 创建类，设计类的成员
    2. 创建类的对象
    3. 通过“对象.属性”或“对象.方法”调用对象的结构

三、如果创建一个类的多个对象，则每个对象都独立的拥有一套类的属性。（非static）
    意味着，如果我们修改一个对象的属性a，则不影响另外一个对象属性a的值

四、对象的内存解析
 */

//1、创建类，设计类的成员
public class BClass {
    //    属性，或成员变量
    String name;
    int age;

    //    构造器
    public BClass(){

    }

    //    方法，或函数
    public void walk(){
        System.out.println("11");
    }

    //    代码块
    {
        name = "cc";
    }

    //    内部类
    class pet{
        String name;
        double weight;
    }

}

