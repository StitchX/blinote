package b14interface;

/**
 * @Description:
 * 接口的使用：
 * 1、接口使用interface来定义
 * 2、Java中，接口和类是并列的一种情况
 * 3、如何定义接口，定义接口中的成员
 *     3.1 jdk7及以前：只能定义全局常量和抽象方法
 *         >全局常量：public static final的，但是书写时可以省略不写
 *         >抽象方法：public abstract的
 *     3.2 JDK8：除了定义全局常量和抽象方法外，还可以定义静态方法、默认方法（略）
 * 4、接口中不能定义构造器！意味着不可以实例化
 * 5、java开发中，接口通过让类去实现（implement）的方式使用
 *     如果实现类实现了接口中的所有抽象方法，则此类就可以完全实例化
 *     如果实现类没有覆盖了接口中的所有抽象方法，则实现类仍为一个抽象类
 * 6、Java类可以实现多个接口 --> 弥补了Java单继承的局限性
 *     格式 class A extend B implements C,D{}
 *
 * 7、接口与接口之间可以继承，而且可以多继承
 *
 * ********************************************
 * 8、接口的具体使用：体现多态性
 * 9、接口，实际上可以看作一种规范
 * @Author Eva
 * @Date 2024/5/15
 */
public class AInterface {
    public static void main(String[] args) {

    }
}

interface Attar{
    void attack();
}

interface Flyable{
//    public Flyable(){} 不能有构造器

    //    全局常量
    public static final int MAX_SPEED = 7900;
    int MIN_SPEED = 1;

    //    抽象方法
    public abstract void fly();
    void stop();
}

interface CC extends Attar,Flyable{

}


class Plan implements Flyable,Attar{

    @Override
    public void fly() {
        System.out.println("起飞");
    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }
}
