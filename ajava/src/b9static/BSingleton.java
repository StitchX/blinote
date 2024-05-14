package b9static;

/**
 * @Description: 单例模式
 * 设计模式：是在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。
 * 设计模式免去我们自己再思考和摸索。模式就像是经典的棋谱，不同的棋局，我们用不同的棋谱，“套路”
 * 单例模式：就是采取一定的方法保证在整个的软件系统重，对某个类只能存在一个对象实例，并且该类只提供一个
 * 去的其对象实例的方法。如果我们要让类在一个虚拟机中只能产生一个对象，我们首先必须将类的构造器的访问权
 * 限设置为private，这样，就不能用new操作符在类的外部产生类的对象了，但类内部仍可以产生该类的对象。因为
 * 在类的外部开始还无法得到类的对象，只能调用该类的某个静态方法以返回类内部创建的对象，静态方法只能访问类
 * 中的静态成员变量，所以，指向类内部产生的该类对象的变量也必须定义成静态的。
 *
 * 举例一些模式：
 * 创建型模式，共5种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式
 * 结构型模式，共7种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
 * 行为型模式，共11种：策略、模版方法、观察者、迭代子、责任链、命令、备忘录、状态、访问者、中介者、解释器
 * 对软件设计模式的研究造就了-本可是面向对象设计方面最有影响的书籍:设计模):《Design Patens: Elements
 * of Reusable bjet-0riented Software)(即述(设计模) -书),由 Erich GammaRichard Helm, Ralph
 * ohnson 和ohn Vlissides (Addison-Wesley, 1995)这位作常被称为四人组(Gang of Four)!而这本书也
 * 就被称为”四人组(或GoF)书。
 * @Author Eva
 * @Date 2024/4/20 20:42
 */

/*
单例（Singleton）设计模式；笔试可能手写

1、所谓类的单例设计模式，就是采取一定的方法保证在整个软件系统中，对某个类只能存在一个对象实例。

2、如何是实现？
    饿汉式 VS 懒汉式

3、区分饿汉式和懒汉式
    饿汉式：坏处，对象加载时间过长。
        好处，饿汉式是线程安全
    懒汉式：好处，延迟对象的创建。
        目前的写法坏处，线程不安全  -- >多线程内容时，再修改

 单例模式的优点：
 由于单例模式只生成一个实例，减少了系统性能开销，当一个对象的产生需要比较多的资源时，如读取配置、产生
 其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后永久驻留内存的方式来解决

 举例：java.lang.Runtime -- 自己去看

 应用场景：
 > 网站的计数器，一般也是单例模式实现，否则难以同步。
 > 应用程序的日志应用，一般都使用单例模式实现，这一般是由于共享的日志文件一直处于打开状态，因为只能有
 一个实例去操作，否则内容不好追加。
 > 数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库资源。
 > 项目中，读取配置文件的类，一般也只有一个对象。没有必要每次使用配置文件数据，都生成一个对象去读取。
 > Application 也是单例的典型应用    （应用程序）
 > Windows的Task Manager (任务管理器)就是很典型的单例模式
 > Windows的Recycle Bin (回收站)也是典型的单例应用。在整个系统运行过程中，回收站一直维护着
   仅有的一个实例。
 */

public class BSingleton {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank2==bank1);


        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();
        System.out.println(order2 == order1);
    }


}

// 饿汉式设计模式
class Bank{
    //    1、私有化类的构造器
    private  Bank(){}

    //    2、内部创建类的对象
   //    4、要求此对象也必须声明为静态的
    private static Bank instance = new Bank();

    //    3、提供公共的静态方法，返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}

// 懒汉式设计模式
class Order{

    //    1、私有化类的构造器
    private Order(){}
    //    2、声明当前类对象，没有初始化
    //    4、要求此对象也必须声明为静态的
    private static Order instance = null;

    //    3、声明public static的返回当前类对象的方法
    public static Order getInstance(){
        if (instance == null){
            instance = new Order();
        }
        return instance;
    }
}
