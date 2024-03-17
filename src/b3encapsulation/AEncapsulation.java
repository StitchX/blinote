package b3encapsulation;

/**
 * @Description:封装性 高内聚，低耦合
 * @Author Eva
 * @Date 2023/2/17 14:16 2024/3/17 18:52
 */

public class AEncapsulation {
    /*
    面向对象的特征：封装和隐藏
    一、问题的引入：
    当我们创建一个类的对象以后，我们可以通过“对象.属性”的方式，对对象的属性进行赋值。这里，赋值操作要受属性的数据类型和存储范围的制约。
    除此之外，没有其他制约条件。但是，在实际问题中，我们往往需要给属性赋值加入额外的限制条件。这个条件就不能在属性声明时体现，我们只能
    通过方法进行限制条件的添加（比如：setName(String name)）。同时，我们需要避免用户再使用“对象.属性”的方式对属性进行赋值。则需要
    将属性声明为私有的（private）  -->此时，针对属性就体现了封装性。

    二、封装性的体现：
    我们将类的属性XXX私有化（），同时，提供公共的（public）方法来获取（getXxx）和设置（setXxx）
    拓展：封装性的体现：1）如上；2）不对外暴露私有的方法；3）单例模式

    三、封装性的体现，需要权限修饰符来配合。
    1. Java规定的4种权限（从小到大排列）：private、缺省、protected、public
    类内部           同一个包          不同包的子类         同一个工程
    private
                    default
                                     protected(继承)
                                                         public
    2. 4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类、接口
    3. 具体的，4种权限都可以用来修饰类的内部结构：属性、方法、构造器、内部类、接口
        修饰类的话，只能使用：缺省、public

    总结封装性：Java提供了4种权限修饰符来修饰类及类的内部结构，体现类及类的内部结构被调用时的可见性的大小。
     */

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<0){
            this.age = 0;
        }
        this.age = age;
    }

    private void E(){
        System.out.println("不能继承");
    }

    protected void F(){
        System.out.println("不能继承");
    }
}

/*
    封装的优点
        1. 良好的封装能够减少耦合。
        2. 类内部的结构可以自由修改。
        3. 可以对成员变量进行更精确的控制。
        4. 隐藏信息，实现细节。
     */

