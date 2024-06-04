package d13reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Description:
 * 获取当前运行时类的属性结构
 * @Author Eva
 * @Date 2023/7/18 16:17 -> 2024/6/4 21:36
 */

public class DFieldTest {

    @Test
    public void test01(){
        Class clazz = YCat.class;
//        获取属性结构
//        getFields(): 获取当前运行时类及其父类中声明为public 访问限的属性
        Field[] fields = clazz.getFields();
        for (Field f:fields){
            System.out.println(f);
        }
        System.out.println();

//        getDeclaredFields():获当前运行时类中声明的所有性。 (不包含父类中声明的属性)
        Field[] declaredFilds = clazz.getDeclaredFields();
        for (Field f: declaredFilds){
            System.out.println(f);
        }
    }

    //    权限修饰符  数据类型 变量名
    @Test
    public void test02(){
        Class clazz = YCat.class;
        Field[] declaredFilds = clazz.getDeclaredFields();
        for (Field f: declaredFilds){
//            1. 权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(modifiers);
            System.out.println(Modifier.toString(modifiers));

//            2.数据类型
            Class type = f.getType();
            System.out.println(type.getName());
//            3. 变量名
            String fName = f.getName();
            System.out.println(fName);


        }

    }
}
