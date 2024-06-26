package b11Block;

/**
 * @Description:
 * 类的成员之四：代码块（或初始化块）
 *
 * 1、代码块的作用：用来初始化类、对象
 * 2、代码块如果有修饰的话，只能使用static
 * 3、分类：静态代码块 VS 非静态代码块
 * 4、静态代码块
 *     >内部可以有输出语句
 *     >随着类的加载而执行，而且只执行一次
 *     >作用：初始化类的信息
 *     >如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
 *     >静态代码块的执行要优先于非静态代码块的执行
 *     >静态代码块内只能调用静态的属性、静态的方法，不能调用非静态的结构
 *
 * 5、非静态代码块
 *     >内部可以有输出语句
 *     >随着对象的创建而执行
 *     >每创建一个对象，就执行一次非静态代码块
 *     >作用：可以在创建对象时，对对象的属性等进行初始化
 *     >如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行
 *     >非静态代码块内可以调用静态的属性、静态的方法，或调用非静态的属性和方法
 *
 * 使用构造器和代码块效果相似，代码块使用情景不高，不使用代码块也可以，但是要看懂源码
 *
 * 对属性可以赋值的位置：
 * 1）默认初始化
 * 2）显示初始化
 * 3）构造器中初始化
 * 4）有个对象以后，可以通过”对象.属性 或“对象.方法”的方式，进行赋值
 * 5）在代码块中赋值
 * @Author Eva
 * @Date 2024/5/14 18:21
 */


public class ABlock {
    public static void main(String[] args) {
        String str1 = Person.des; //
        Person person1 = new Person(); //
        Person person2 = new Person(); //
    }
}

class Person{
    String name;
    int age;

    static String des = "人";
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Person(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    //    代码块
    {
        System.out.println("hello,非静态代码块");
    }
    static {
        System.out.println("hello,静态代码块-1");
    }
    static {
        System.out.println("hello,静态代码块-2");
        info(); // 调用静态方法
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void info(){
        System.out.println("111");
    }
}
