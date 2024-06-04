package d13reflection;

import org.junit.Test;

import java.util.Random;

/**
 * @Description:
 * 通过发射创建对应的运行时类的对象
 * @Author Eva
 * @Date 2023/7/18 15:33 -> 2024/6/4 21:35
 */

public class CObject {
    @Test
    public void test01() throws InstantiationException, IllegalAccessException {
        Class<YDemo01> clazz = YDemo01.class;
        /*
        newInstance(): 调用此方法，创建对应的运行时类的对象

        要想此方法正常的创建运行时类的对象，要求:
        1. 运行时类必须提供空参的构造器
        2. 空参的构造器的访问权限得够，通常，设置为public
        在javabean 中要求提供一个public的空参构道器。原因:
        1. 便于通过反射，创建运行时类的对象
        2. 便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        YDemo01 obj = clazz.newInstance();
        System.out.println(obj);
    }

    //    体会反射的动态程
    @Test
    public void test02(){
        int num = new Random().nextInt(3);
        String classPath="";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "d13reflection.YDemo01";
                break;
            default:
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    创建一个指定类的对象
    cLassPath: 指定类的全类名
     */
    public Object getInstance(String classPath) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
