package d11IO;

import java.io.Serializable;

/**
 * @Description:
 *  YDemo01需要满足如下要求，方可序列化：
 *  1. 需要实现接口: Serializable
 *  2. 当前类提供一个全局常量: serialVersionUID
 *  3. 除了当前Person类需要实现Serializable接口之外，
 *          还必须保证其内部所有属性也必须是可序列化的。(默认情况下，基本效据类型可序列化)
 *
 *    补充：ObjectOutputStream和objectInputStream不能序列化static和transient修饰的成员变量
 * @Author Eva
 * @Date 2023/7/6 10:44 -> 2024/6/4 17:12
 */
public class YDemo01 implements Serializable {
    //    serialVersionUID用来表明类的不同版本间的兼容性。
//    简言之，其目的是以序列化对象进行版本控制，有关各版本反序列化时是否兼容。
    /*
    如果类没有显示定义这个静态常量，它的值是Java运行时环境根据类的内部细节自若类的实例变量做了修改，
    seriaIVersionUID 可能发生变化。
     */
    public static final long serialVersionUID = 2345678876L;

    private String name;
    private int age;

    public YDemo01() {
    }

    public YDemo01(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
        this.age = age;
    }

    @Override
    public String toString() {
        return "YDemo01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
