package b15InnerClass;

/**
 * @Description:
 * 在局部内部类的方法中，如果调用局部内部类所声明的方法中的局部变量，要求此局部变量为final的
 *
 * jdk7 及之前的版本：要求此局部变量显示的声明为final的
 * jdk8 及之后版本，可以省略final的声明
 *
 * 为什么呢？
 *     外部类和内部类是两个独立的文件，基于生命周期的原因
 * @Author Eva
 * @Date 2024/5/17
 */
public class BIClass {

    public void method(){
        int num = 10;  // final 被省略

        class AA{
            public void mm(){
//                num = 20;  // 报错
                int a;
                a=1;
                System.out.println(a);
                System.out.println(num);
            }
        }
    }
}
