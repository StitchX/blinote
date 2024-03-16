package a3variableclass;

/**
 * @Description: 变量类型
 * @Author Eva
 * @Date 2023/1/6 11:05 2024/3/16 20:09
 */

public class AVariable {
    /*
    成员变量：
        实例变量（不以static修饰）
        类变量（以static修饰）
    局部变量：
        形参(方法、构造器中定义的变量)
        方法局部变量(在方法内定义)
        代码块局部变量(在代码块内定义)

    成员变量（实例变量）和 局部变量区别：
    1、作用域
    成员变量：针对整个类有效
    局部变量：只在某个范围内有效
    2、存储位置
    成员变量：存储在堆内存中
    局部变量：存储在栈内存中
    在方法被调用完，或者语句结束后，就自动释放
    3、初始值
    成员变量：有默认初始值
    局部变量：没有默认初始值，使用前必须赋值
    4、生命周期
    成员变量：随着对象的创建而存在，随着对象的消失而消失
    局部变量：在方法被调用，或者语句被执行的时候存在

    成员变量（实例变量） 和 静态变量（类变量）的区别：
    1、调用方式
    静态变量：可以通过类名直接调用，也可以通过对象名调用
    成员变量：只能通过对象名调用
    2、存储位置
    静态变量：方法区中的静态区
    成员变量：堆内存
    3、生命周期
    静态变量：随着类的加载而存在，随着类的消失而消失。生命周期长
    成员变量：随着对象的创建而存在，随着对象的消失而消失
    4、对象的相关性
    静态变量是所有对象共享的数据
    成员变量是每个对象所特有的数据
     */
}
