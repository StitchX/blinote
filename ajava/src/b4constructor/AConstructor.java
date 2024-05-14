package b4constructor;

/**
 * @Description: 构造器（constructor）
 * @Author Eva
 * @Date 2023/2/17 14:44 2024/3/17 19:23
 */

public class AConstructor {
    /*
    类的结构之三：构造器（或构造方法、constructor）的使用
    construct: 建设、建造。construction：CCB

    一、构造器的作用：
    1. 创建对象
    2. 初始化对象的属性

    二、说明：
    1. 如果没有显示的定义类的构造器的话，则系统默认提供一个空参的构造器
    2. 定义构造器的格式：权限修饰符 类名(形参列表){}
    3. 一个类中定义的多个构造器，彼此构成重载
    4. 一旦我们显示的定义了类的构造器之后，系统就不再提供默认的空参构造器
    5、一个类中，至少一个构造器
     */

    private int a;

    public AConstructor(){
        System.out.println("默认空参");
    }
    public AConstructor(int a, double b){
    }

    public AConstructor(int a){
//        this.a = a;
    }

    public static void main(String[] args) {
//        创建类的对象：new + 构造器
        YDemo a1 = new YDemo(2.1,"aa");
    }
}


//    构造方法
    /*
    当一个对象被创建时候，构造方法用来初始化该对象。构造方法和它所在类的名字相同，但构造方法没有返回值。
    通常会使用构造方法给一个类的实例变量赋初值，或者执行其它必要的步骤来创建一个完整的对象。
    不管你是否自定义构造方法，所有的类都有构造方法，因为 Java 自动提供了一个默认构造方法，
        默认构造方法的访问修饰符和类的访问修饰符相同(类为 public，构造函数也为 public；类改为 protected，构造函数也改为 protected)。
    一旦你定义了自己的构造方法，默认构造方法就会失效。
     */

