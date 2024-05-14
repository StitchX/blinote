package b5oopB;

/**
 * @Description: 关键字super
 * @Author Eva
 * @Date 2024/4/11 18:49
 */

public class CSuper extends BOverride{
    /*
    super关键字的使用
    1.super理解为:父类的
    2.super可以用来调用:属性、方法、构造器
    3.super的使用:调用属性和方法
        3.1 我们可以在子类的方法或构造器中。通过使用“super.属性"或”super.方法”的方式，显式的调用
        父类中声明的属性或方法。但是，通常情况下，我们习惯省略”super."
        3.2 特殊情况，当子类和父类中定义了同名的属性时，我们要想在子类中调用父类中声明的属性，则必须
        显式的使用“super.属性”的方式，表明调用的是父类中声明的属性。
        3.3 特殊情况，当子类重写了父类中的方法以后，我们想在子类的方法中调用父类中被重写的方法时，则
        必须显式的使用“super.方法”的方式，表明调用的是父类中被重写的方法。

    4.super调用构造器
        4.1 我们可以在子类的构造器中显式的使用“super(形参列表)”的方式，调用父类中声明的指定的构造器
        4.2 "super(形参列表)"的使用，必须声明在子类构造器的首行!
        4.3 我们在类的构造器中，针对于"this(形参列表)"或"super(形参列表)"只能二选一，不能同时出现
        4.4 在构造器的首行，没有显式的声明"this(形参列表)"或”super(形参列表)"，则默认调用的是父类中空参的构造器：super()
        4.5 在类的多个构造器中，至少有一个类的构造器中使用了"super(形参列表)"，调用父类中的构造器
     */
    int id;

    public CSuper(){
        super("null");
    }
    CSuper(String name){
        super(name);
    }

    public static void main(String[] args) {
        CSuper c1 = new CSuper("");
        c1.CC();
        System.out.println();
        c1.AA();

    }
    @Override
    public String AA() {
        System.out.println(super.AA());   // 调用父类的方法
        System.out.println(super.id);     // 调用父类的熟悉
        return "1";
    }
}

/*
super关键字：我们可以通过super关键字来实现对父类成员的访问，用来引用当前对象的父类。
this关键字：指向自己的引用。
//    子类是不继承父类的构造器（构造方法或者构造函数）的，它只是调用（隐式或显式）。
//    如果父类的构造器带有参数，则必须在子类的构造器中显式地通过 super 关键字调用父类的构造器并配以适当的参数列表。
 */
