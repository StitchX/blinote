package d13reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/7/18 16:46 -> 2024/6/4 22:57
 */

public class EMethodTest {
    @Test
    public void test01(){

        Class clazz = YCat.class;

//        getMethods():获当前运行时类及其所有父类中声明为public限的方法
        Method[] methods = clazz.getMethods();
        for (Method m:methods){
            System.out.println(m);
        }

        System.out.println();

//        getDeclaredMethods():获取当前运行时类中声明的所有方法。 (不包含父类中声明的方法)
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m: declaredMethods){
            System.out.println(m);
        }

    }

    /*
    @Xxxx
    权限修饰符 返回值类型 方法名(参数类型1 形参名1,..) throws XxxException(}
     */
    @Test
    public void test02(){

        Class clazz = YCat.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m:declaredMethods){
//        1. 获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation a:annos){
                System.out.println(a);
            }

//        2. 权限修饰符
            System.out.println(Modifier.toString(m.getModifiers()));

//            3.返回值类型
            System.out.println(m.getReturnType().getName());

//            4. 方法名
            System.out.println(m.getName());
            System.out.println("(");

//            5. 形参列表
            Class[] par = m.getParameterTypes();
//            System.out.println(par.length);
            if (!(par == null && par.length==0)){
                for (int i=0; i<par.length;i++){
                    if (i ==par.length-1){
                        System.out.println(par[i].getName()+" args_"+i);
                        break;
                    }
                    System.out.println(par[i].getName()+" args_"+i+",");
                }
            }
            System.out.println(")");

//            6.抛出的异常
            Class[] exceptionType = m.getExceptionTypes();
            if (exceptionType.length>0){
                System.out.println("throws:");
                for (int i = 0; i < exceptionType.length; i++) {
                    if (i==exceptionType.length-1){
                        System.out.println(exceptionType[i].getName());
                        break;
                    }
                    System.out.println(exceptionType[i].getName()+",");
                }
            }
            System.out.println();

        }
    }
}
