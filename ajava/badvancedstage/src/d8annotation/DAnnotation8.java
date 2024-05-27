package d8annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;
import java.util.ArrayList;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

/**
 * @Description: jdk8 新增的注解
 * @Author Eva
 * @Date 2023/2/15 11:07 -> 2024/5/27 17:00
 */


/*
6.1 可重复注解：1）DAnnotation8上声明@Repeatable，成员值为 YDemo02.class
              2）DAnnotation8的Target和Retention和YDemo02相同
 */
@Repeatable(YDemo02.class)
@Target(value = {FIELD,TYPE,TYPE_PARAMETER,TYPE_USE})
public @interface DAnnotation8 {
    String[] value() default "hello";
}
//jdk8之前的写法
//@YDemo02({@DAnnotation8(value = "hi"),@DAnnotation8(value = "hello")})
// jdk8新增写法
@DAnnotation8(value = "hi")
@DAnnotation8(value = "hello")
class Eight{

}


//6.2 类型注解：
//* ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）
//* ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。

class G<@DAnnotation8 T>{
    public void show() throws RuntimeException{
        ArrayList<@DAnnotation8 String> list = new ArrayList<>();
        int num =(@DAnnotation8 int) 10L;
    }
}
