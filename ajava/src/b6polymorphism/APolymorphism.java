package b6polymorphism;

/**
 * @Description: 多态性
 * @Author Eva
 * @Date 2024/4/11 18:58
 */

public class APolymorphism {
    /*
    面向对象特征之三:多态性
        1.理解多态性:可以理解为一个事物的多种形态。
        2.何为多态性:
            对象的多态性，父类的引用指向子类的对象（或子类的对象赋给父类的引用)
        3.多态的使用，虚拟方法调用
            有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法
                总结:编译，看左边，运行，看右边。
        4.多态性的使用前提: 1)类的继承关系 2)方法的重写
        5.对象的多态性，只适用于方法，不适用于属性(编译和运行都看左边)


        补充：动态绑定，运行时行为
     */

    public static void main(String[] args) {
        YDemo01 y1 = new YDemo01();
//        对象的多态性：父类的引用指向子类的对象
        YDemo01 y2 = new YDemo02();

        System.out.println(y1.id); // 0: 多态性不适用于属性，仅方法
        System.out.println(y2.id); // 0
        System.out.println(y2.name); // null

//        多态的使用：当调用子父类同名同参的方法时，实际执行的是子类重写父类的方法 --- 虚方法的调用
        y1.demo02(); // 321
        y2.demo02(); // 覆盖



    }

    public void dd(YDemo01 y3){

        System.out.println("多态性的应用场景之一");
        System.out.println("补充，数据库连接connection；可以传 mysql orcle等 ");
    }

    public APolymorphism a1(){
        //        动态绑定
        int key = (int) (Math.random()*10);
        switch (key){
            case 1: return new YDemo01();
            case 2: return new YDemo02();
            default:return new APolymorphism();

        }
    }



}

/*
    虚函数
    虚函数的存在是为了多态。
    Java 中其实没有虚函数的概念，它的普通函数就相当于 C++ 的虚函数，动态绑定是Java的默认行为。
        如果 Java 中不希望某个函数具有虚函数特性，可以加上 final 关键字变成非虚函数。

    子类重写父类方法，多态情况下，此时父类的方法称为虚拟方法。调用在编译器是无法确定的


    多态存在的三个必要条件
        继承
        重写
        父类引用指向子类对象：Parent p = new Child();


    多态的优点
        1. 消除类型之间的耦合关系
        2. 可替换性
        3. 可扩充性
        4. 接口性
        5. 灵活性
        6. 简化性
     */
