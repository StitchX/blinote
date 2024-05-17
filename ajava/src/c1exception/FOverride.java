package c1exception;

/**
 * @Description:
 * 方法重写的规则之一：
 *     子类重写的方法抛出的异常不大于父类被重写的方法抛出的异常类型。
 * @Author Eva
 * @Date 2024/5/17
 */
public class FOverride extends ZDemo{
    public static void main(String[] args) {

//        原因：
        ZDemo zd = new FOverride();
    }

//    报错
//    public void demo01() throws Exception {}

}
