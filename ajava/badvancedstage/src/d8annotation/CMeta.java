package d8annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE;

/**
 * @Description: 元注解
 * 4. jdk 提供的4种元注解
 *        元注解：对现有的注解进行解释说明的注解
 *            Rentention: 指定所修饰的Annotation的生命周期：SOURCE\CLASS(默认行为)\RUNTIME只
 *                有声明为RUNTIME生命周期的注解，才能通过反射获取
 *            Target: 用于指定被修饰的Annotation能用于修饰哪些程序元素
 *            ***************************频率较低***********************************
 *            Documented: 表示所修饰的注解在被javadoc解析时，保留下来
 *            Inheried: 被它修饰的Annotation将具有继承性
 * @Author Eva
 * @Date 2023/2/15 10:57 -> 2024/5/27 16:58
 */

@Retention(RetentionPolicy.RUNTIME) // 指定所修饰的Annotation的生命周期
@Inherited // 被它修饰的Annotation将具有继承性
//用于指定被修饰的Annotation能用于修饰哪些程序元素
//类、接口、属性、构造器成员变量、方法
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
@Documented // 表示所修饰的注解在被javadoc解析时，保留下来; 看下Deprecated注解源码
public @interface CMeta {}
