package b13Abstract;

/**
 * @Description:
 * abstract关键字的使用
 * 1、abstract：抽象的
 * 2、abstract可以用来修饰的结构：类、方法
 * 3、abstract修饰类：抽象类
 *     >此类不能实例化
 *     >抽象类中一定有构造器，便于子类实例化的调用（涉及：子类对象实例化的全过程）
 *     >开发中，都会提供抽象类的子类，让子类对象实例化，完成相关操作
 * 4、abstract修饰方法：抽象方法
 *     >抽象方法只有方法的声明，没有方法体
 *     >包含抽象方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法。
 *     >若子类重写了父类中的所有的抽象方法后，次子类可实例化
 *     >若子类没有重写父类中的所有的抽象方法，则此子类也是一个抽象类，需要使用abstract修饰
 *     >
 *
 * abstract使用上的注意点：
 *     1、abstract不能用来修饰：属性、构造器
 *     2、abstract不能用来修饰私有方法、静态方法、final方法、final的类
 * @Author Eva
 * @Date 2024/5/14 19:12
 */


public class AAbstract {
    public static void main(String[] args) {
//        People p1 = new People();   不能被实例化
        People p2 = new Student();
    }
}
abstract class Creature{
    public abstract void life();
}

abstract class People extends Creature{
    String name;
    int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void eat();
}

class Student extends People{

    @Override
    public void eat() {
        System.out.println("两种处理方式");
    }

    @Override
    public void life() {

    }
}

