package d7enum;

/**
 * @Description: 枚举类和注解
 * @Author Eva
 * @Date 2023/2/13 17:04 -> 2024/5/27 16:19
 */
public class AIntroduce {
    /**
     * 一、枚举类的使用
     * 1、枚举类的理解：类的对象只有有限个，确定的。我们称为此类为枚举类
     * 2、当需要定义一组常量时，强烈建议使用枚举类
     * 3、如果枚举类中只有一个对象，则可以作为单例模式的实现方式
     *
     * 二、如何定义枚举类
     * 方式一：jdk5.0之前，自定义枚举类
     * 方式二：jdk5.0，可以使用enum关键字定义枚举类
     *
     * 三、Enum类中的常用方法
     *  value()方法：返回枚举类类型的对象数组。该方法可以很方便地遍历所有的枚举值。
     *  valueOf(String str): 可以把一份字符串转为对应的枚举类对象。
     *      要求字符串必须是枚举类对象的名字。如不是，会运行异常：IllegalArgumentException
     *  toString()返回当前枚举类对象常量的名称
     *
     *  四、使用enum关键字定义的枚举类实现接口的情况
     *      情况一：实现接口，再enum类中实现抽象方法
     *      情况二：让枚举类的对象分别实现接口中的抽象方法
     */

    public static void main(String[] args) {
        BselfEnum spring = BselfEnum.SPRING;
        BselfEnum summer = BselfEnum.SUMMER;
        BselfEnum autumn = BselfEnum.AUTUMN;
        BselfEnum winter = BselfEnum.WINTER;
        System.out.println(spring);  // BselfEnum{seasonName='春天', seasonDesc='困'}
        //===========================================
        CEnum s1 = CEnum.SPRING;
        System.out.println(CEnum.class.getSuperclass());  //class java.lang.Enum
//        toString()
        System.out.println(s1);   // SPRING
//        valueOf()
        Thread.State[] v1 = Thread.State.values();
        for (Thread.State i:v1){
            System.out.println(i);//NEW RUNNABLE BLOCKED WAITING
        }

//        valueOf(String str): 返回枚举类中对象名是objName的对象
        CEnum w1 = CEnum.valueOf("WINTER");  // TERMINATED
        CEnum w2 = CEnum.valueOf("WINTER1"); // 抛异常：IllegalArgumentException
        System.out.println(w2);

    }
}
