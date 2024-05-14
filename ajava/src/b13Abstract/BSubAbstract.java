package b13Abstract;

/**
 * @Description: 抽象类的匿名子类
 * @Author Eva
 * @Date 2024/5/14 19:12
 */

public class BSubAbstract {
    public static void main(String[] args) {
        method(new Student());  // 匿名对象
        Student s1 = new Student();
        method1(s1); // 非匿名类非匿名对象
        method1(new Worker()); // 非匿名类匿名的对象

        // -- 复习的时候重温了，注意下面这个例子就是抽象类的匿名子类
        People p2 = new People() {  // 创建了一个匿名子类的对象：p2
            @Override
            public void eat() {
                System.out.println("重写一下");
            }

            @Override
            public void life() {
                System.out.println("");
            }
        };

        method1(p2);

//        创建一个匿名子类的匿名对象

        method1(new People() {
            @Override
            public void eat() {

            }

            @Override
            public void life() {

            }
        });
    }
    public static void method1(People p){
        p.eat();
        p.life();
    }
    public static void method(Student s){
        s.eat();
        s.life();
    }
}

class Worker extends People{

    @Override
    public void life() {

    }

    @Override
    public void eat() {

    }
}
