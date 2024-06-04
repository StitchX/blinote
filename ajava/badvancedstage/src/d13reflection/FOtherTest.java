package d13reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/7/19 11:13 -> 2024/6/4 22:58
 */

public class FOtherTest {
    /*
    获取构造器结构
     */
    @Test
    public void test01(){
        Class clazz = YCat.class;
//        getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c:constructors){
            System.out.println(c);
        }

//        getDeclaredConstructors(): 获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c:declaredConstructors){
            System.out.println(c);
        }

    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test02(){

        Class clazz = YCat.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);

    }

    /*
    获取运行时类带泛型的父类
     */
    @Test
    public void test03(){

        Class clazz = YCat.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

    }

    /*
    获取运行时类带泛型的父类的泛型
    代码: 逻性代码 vs 功能代码
     */
    @Test
    public void test04(){

        Class clazz = YCat.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
//        获取泛型类型
        Type[] actualTypeArg = parameterizedType.getActualTypeArguments();
//        System.out.println(actualTypeArg[0].getTypeName());
        System.out.println(((Class)actualTypeArg[0]).getName());
    }
    /*
    获取运行时类实现的接口
     */
    @Test
    public void test05(){

        Class clazz = YCat.class;

        Class[] interfaces = clazz.getInterfaces();
        for (Class c:interfaces){
            System.out.println(c);
        }
//        获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c: interfaces1){
            System.out.println(c);
        }

    }
    /*
    获取运行时类所在的包
     */
    @Test
    public void test06(){

        Class clazz = YCat.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);

    }

    /*
    获取运行时类声明的注解
     */
    @Test
    public void test07(){

        Class clazz = YCat.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annos: annotations){
            System.out.println(annos);
        }

    }
}
