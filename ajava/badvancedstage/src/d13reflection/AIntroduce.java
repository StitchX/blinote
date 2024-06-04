package d13reflection;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/7/7 11:16 -> 2024/6/4 21:07
 */

public class AIntroduce {
    /*
    1. Java反射机制概述
    2. 理解Class类并获取Class实例      掌握
    3. 类的加载与ClassLoader的理解
    4. 创建运行时类的对象               掌握
    5. 获取运行时类的完整结构
    6. 调用运行时类的指定结构            掌握
    7. 反射的应用：动态代理
     */

    //    反射之前，对于YDemo01的操作
    @Test
    public void test01(){
//        1.创建YDemo01类的对象
        YDemo01 y1 = new YDemo01();

//        2.通过对象，调用其内部的属性、方法
        y1.age = 10;
        System.out.println(y1.toString());

        y1.show();

//        在YDemo01类外部，不可以通过YDemo01类的对象调用其内部私有结构
//        比如：name、showNation()以及私有的构造器
    }

    //    反射之后，对于YDemo01的操作
    @Test
    public void test02() throws Exception {
        Class clazz = YDemo01.class;
//        1.通过反射，创建YDemo01类的对象
        Constructor cons = clazz.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("Tom",12);
        YDemo01 y1 = (YDemo01) obj;
        System.out.println(y1.toString());

//        2. 通过反射，调用对象指定的属性、方法
//        调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(y1,10);

//        调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(y1);

        System.out.println("****************************");
//        通过反射，可以调用YDemo01类的私有结构的。比如：私有的构造器、方法、属性
//        调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        YDemo01 y2 = (YDemo01) cons1.newInstance("jerry");
        System.out.println(y2);

//        调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(y2,"hanMeiMei");
        System.out.println(y2);

//        调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation",String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(y2,"china");// 相当于String nation = y2.shpwNation("china")
        System.out.println(nation);

//        疑问1:通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个?
//        建议:直接new的方式。
//        什么时候会使用:反射的方式。 反射的特征:动态性

//        疑问2:反射机制与面向对中的封装性是不是矛盾的? 如何看待两个技术?
//        不矛盾。

    }
     /*
        关于java.Lang.CLass类的理释
        1.类的加载过程:程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
        接者我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
        加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
        运行时类，就作为Class的一个实例。
        2.换句话说，Class的实例就对应着一个运行时类
        3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式
             来获取此运行时类。

         */

    //    获取Class的实例的方式（前三种方式需要掌握）
    @Test
    public void test03() throws ClassNotFoundException {
//        方式一：调用运行时类的属性：class
        Class<YDemo01> clazz1 = YDemo01.class;
        System.out.println(clazz1);

//        方式二：通过运行时类的对象调用getClass()
        YDemo01 y1 = new YDemo01();
        Class clazz2 = y1.getClass();
        System.out.println(clazz2);

//        方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("d13reflection.YDemo01");
//        clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);

        System.out.println(clazz3 == clazz2);
        System.out.println(clazz3 == clazz1);

//        方式四：使用类的加载器：classLoader（了解）
        ClassLoader classLoader = AIntroduce.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("d13reflection.YDemo01");
        System.out.println(clazz4);
        System.out.println(clazz3 == clazz4);

//
    }

    //    Class实例可以是哪些结构的说明：
    @Test
    public void test04(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];

        Class c10 = a.getClass();
        Class c11 = a.getClass();
//        只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10==c11);
    }

//        万事万物皆对象? 对象.xxx,File,URL，反射，前端、数据库操作
}
