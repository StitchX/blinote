package b9static;

/**
 * @Description: 关键字：static
 * @Author Eva
 * @Date 2024/4/20 20:37
 */

/*
static关键字的使用：

1、static：静态的
2、static可以用来修饰：属性、方法、代码块、内部类

3、使用static修饰属性：静态变量（或类变量）
    3.1 属性，按是否使用static修饰，又分为：静态变量 vs 非静态变量（实例变量）
        实例变量：我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性。当修改其中一个对象中的非静态属性时，
                不会导致其他对象中同样的属性值的修改
        静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，会导致其他对象
                调用此静态变量时，是修改过了的。
    3.2 static修饰属性的其他说明：
        1）静态变量随着类的加载而加载。可以通过：“类.静态变量”的方式进行调用
        2）静态变量的加载要早于对象的创建。
        3）由于类只会加载一次，则静态变量在内存中也会存在一份：存在方法区的静态域中。
        4）           类变量     实例变量     -- 能否调用
               类      yes        no
              对象     yes        yes
    3.3 静态属性举例：System.out Math.PI
4. 使用static修饰方法：静态方法
    1）随着类的加载而加载，可以通过”类.静态方法“的方式进行调用
    2）                   静态方法     非静态方法     -- 能否调用
                 类        yes         no
                对象        yes        yes
    3）静态方法中，只能调用静态方法或属性
    非静态方法中，既可以调用非静态方法或属性，也可以调用静态方法或属性

5、static注意点：
    5.1 在静态方法内，不能使用this关键字、super关键字
    5.2 关于静态属性和静态方法的使用，大家都从生命周期的角度去理解

6、开发中，如何确定一个属性是否要声明为static的？
    >属性是可以被多个对象所共享的，不会随着对象的不同而不同的
    >类中的常量也常常声明为static

  开发中，如何确定一个方法是否要声明为static的？
    >操作静态属性的方法，通常设置为static的
    >工具类中的方法，习惯上声明为static的。比如：Math Arrays Collections


 */

public class AStatic {

    public static void main(String[] args) {
        Chinese china = new Chinese();
        china.name = "中华";
        china.nation = "中国";
        Chinese.nation = "中华人们共和国";
        System.out.println(china.nation);
    }
}
class Chinese{
    String name;
    int age;
    public static String nation;

    public static void color(){
        System.out.println("静态方法只能调用静态方法和属性");
        System.out.println(nation); //
        eat(); // Chinese.eat(); 省略了Chinese


//        System.out.println(age); // 报错
//        play();  // 报错，声明周期不同，对象还未创建

//        Chinese cna = new Chinese();
//        cna.run();
//        System.out.println(cna.age);

    }
    public static void eat(){
        System.out.println("这是静态方法");
//        System.out.println(this.age); // 不能使用this，这时没有对象
    }
    public void play(){
        System.out.println("非静态方法可以调用静态和非静态的属性和方法");
        run(); // 非静态
        eat();// 静态
        System.out.println(name); // 非静态
        System.out.println(nation);// 静态


    }
    public void run(){
        System.out.println("这是非静态方法");
    }
}

