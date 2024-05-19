package b14interface;

/**
 * @Description: JDK8：除了定义全局常量和抽象方法外，还可以定义静态方法、默认方法
 * @Author Eva
 * @Date 2024/5/15
 */
public class Djava8 {

    public static void main(String[] args) {
//
        Eight e1 = new Eight();
//        知识点一：接口中定义的静态方法，只能通过接口来调用
//        e1.A();
        CompareB.A();
//        知识点二：通过实现类的对象，可以调用接口中的默认方法
//        如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
        e1.B();
//        CompareB.B();
//        知识点三：如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的方法
//        那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数方法。 --> 类优先原则
        e1.C();

//        知识点四：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，
//        那么在实现类没有重写此方法的情况下，报错。 --> 接口冲突
//        这就需要我们必须在实现类中重写此方法
        e1.C();

    }
}

class SuperClass{
    public void C(){
        System.out.println("继承父类和实现接口中声明了同名同参数方法，那么子类默认调用父类");
    }
}
interface CompareA{
    default void C(){
        System.out.println("");
    }
}

interface CompareB{
    //    静态方法
    public static void A(){
        System.out.println();
    }
    //    默认方法
    public default void B(){
        System.out.println("接口默认方法，可以被重写");
    }
    default void C(){
        System.out.println();
    }
}

class Eight extends SuperClass implements CompareB,CompareA{

    public void B(){
        System.out.println("重写的方法");
    }

    //    知识点五：如何在子类（或实现类）的方法中调用父类、接口中被重写的方法
    public void myMethod(){
        B();
        super.C(); // 调用父类中声明的方法
        CompareB.super.B(); // 调用接口中默认方法
    }
}
