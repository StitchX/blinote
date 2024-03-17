package b1oopA;

/**
 * @Description: 面向对象的理解
 * @Author Eva
 * @Date 2024/3/17 17:24
 */

public class AIntroduce {
    /*
    面向对象：object oriented programming
    面向过程：procedure oriented programming

    一、Java面向对象学习的三条主线
    1. Java类及类的成员：属性、方法、构造器；代码块、内部类
    2. 面向对象的三大特性：封装Encapsulation、继承Inheritance、多态Polymorphism、（抽象性）Abstract
    3. 其他关键字：this、super、static、final、abstract、interface、package、import

    “大处着眼，小处着手”

    二、“人把大象装冰箱”
    1.面向过程：强调的是功能行为，以函数为最小单位，考虑怎么做。
        1、打开冰箱
        2、抬起大象，装进去
        3、把并行们关上

    2.面向对象：强调具备了功能的对象，以类/对象为最小单位，考虑谁来做。
    人{
        打开（冰箱）
            冰箱.打开（）；
    }
    冰箱{
    }
    大象{
    }

    三、面向对象的两个要素
    类(class)：对一类事物的描述，是抽象的、概念上的定义
    对象(Object)：是实际存在的该类事物的每个个体，因而也称为实例（instance）
    > 面向对象程序设计的重点是类的设计
    > 设计类，就是设计类的成员
     */

    public static void main(String[] args) {
//        2、 创建类的对象
        BClass b1 = new BClass();

//        3、
//        调用对象的结构：属性、方法
//        调用属性：“对象.属性”
        b1.name="jerry";
        System.out.println(b1.name);
        System.out.println(b1.age); //

//        调用方法：“对象.方法”
        b1.walk();


//        **********************************************
        BClass b2 = b1;
        System.out.println(b2.name);


    }
}

/*
1、面向对象和面向过程
2、Java的基本元素：类和对象
3、对象的创建和使用
4、类的成员之一：属性 property           ---第一个包：这个包下讲到这里
5、类的成员之二：方法 method
6、再谈方法                            ---第二个包：讲到这里，很多
==============================================================
7、OOP特征一：封装和隐藏                 ---第三个包：讲到这
8、类的成员之三：构造器
9、关键字：this
10、关键字：package、import            ---第四个包：讲到这
 */

