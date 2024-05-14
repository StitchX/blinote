package b5oopB;

/**
 * @Description: 继承的特性和优缺点
 * @Author Eva
 * @Date 2023/2/17 15:44 2024/4/11 18:39
 */

public class AInheritance extends Object{
    /*
    面向对象的特征之二：继承性

    一、继承性的好处
    1）减少了代码的冗余，提高了代码的复用性
    2）便于功能的扩展
    3）为之后多态性的使用，提供了前提

    二、继承性的格式: class A extends Bf
    A:子类、派生类、subclass
    B:父类、超类、基类、superclass

    2.1 体现:一旦子类A继承父类B以后，子类A中就获取了父类B中声明的所有的属性和方法。
    特别的，父类中声明为private的属性或方法，子类继承父类以后，仍然认为获取了父类中私有的结构。
    只有因为封装性的影响，使得子类不能直接调用父类的结构而已。
    2.2 子类继承父类以后，还可以声明自己特有的属性或方法:实现功能的拓展。
    子类和父类的关系，不同于子集和集合的关系。extends:延展、扩展

    三、Java中关于继承性的规定:
        1.一个类可以被多个子类继承。
        2.Java中类的单继承性:一个类只能有一个父类
        3.子父类是相对的概念。
        4.子类直接继承的父类，称为，直接父类。间接继承的父类称为，间接父类
        5.子类继承父类以后，就获取了直接父类以及所有间接父类中声明的属性和方法

    四、1、如果我们没有显式的声明一个类的父类的话，则此类继承于java.lang.object类
    2、所有的java类(除java.lang.object类之外)都直接或间接的继承于java.lang.object类
    3、意味着，所有的java类具有java.lang.object类声明的功能。
     */

    public AInheritance(){
        super();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    //    下面三个方法是为了在BOverride中继承使用
    protected Object AA(){
        return 1;
    }

    int BB() throws Exception{
        return 1;
    }

    final void CC(){
        System.out.println("使用 final 关键字声明类，就是把类定义定义为最终类，不能被继承，或者用于修饰方法，该方法不能被子类重写");
    }
}
    /*
    重复的代码: 代码量大且臃肿，而且维护性不高
    维护性也提高，代码也更加简洁，提高代码的复用性

    java不支持多继承，但支持多重继承


    继承的特性
        1. 子类拥有父类非 private 的属性、方法。(继承了所有属性和方法，只是不能直接调用，通过get set 方法，堆中有private属性)
        2. 子类可以拥有自己的属性和方法，即子类可以对父类进行扩展。
        3. 子类可以用自己的方式实现父类的方法。
        4. Java 的继承是单继承，但是可以多重继承，单继承就是一个子类只能继承一个父类，多重继承就是，
            例如 cainiao.B 类继承 cainiao.A 类，C 类继承 cainiao.B 类，所以按照关系就是 cainiao.B 类是 C 类的父类，
            cainiao.A 类是 cainiao.B 类的父类，这是 Java 继承区别于 C++ 继承的一个特性。
        5. 提高了类之间的耦合性（继承的缺点，耦合度高就会造成代码之间的联系越紧密，代码独立性越差）。
     */

/*
1、OOP特征二：继承性
2、方法的重写（Override）
3、四种访问权限修饰符
4、关键字：super
5、子类对象实例化过程
6、OOP特征三：多态性
*******下面和面向对象没关系*******
7、Object类的使用
8、包装类的使用
 */

