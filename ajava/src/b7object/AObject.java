package b7object;

/**
 * @Description: 最高级别父类，注意可以继承的方法的使用
 * @Author Eva
 * @Date 2023/2/20 14:29 2024/4/11 19:28
 */

public class AObject {
    /*
    java.lang.Object类
    1、Object类是所有Java类的根父类
    2、如果在类的声明中未使用extends关键字指明父类，则默认为java.lang.Object类
    3、Object类中的功能（属性、方法）就具有通用性
        属性：无
        方法：equals() toString() getClass() hashCode() clone() finalize()
            wait()、notify()、notifyAll()
    4、Object类只声明了一个空参的构造器

    面试题：final finally finalize的区别

    p294 讲了clone() 没听明白，只做了解；讲了finalize()说是后续jvm详细讲解
    equals() toString() 用的比较多
     */
    public static void main(String[] args) {
        AObject order = new AObject();
        System.out.println(order.getClass().getSuperclass()); //class java.lang.Object
    }
}
