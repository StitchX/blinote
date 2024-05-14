package b12Final;

/**
 * @Description:
 * final：最终的
 * 1、final可以用来修饰的结构：类、方法、变量
 * 2、final用来修饰一个类：此类不能被其他类所继承
 *     比如：String类、System类、StringBuffer类
 * 3、final用来修饰方法：表明此方法不能被重写
 *     比如：Object类中的getClass()；【native表示是最终父类，再往上走就是C或C++语言】
 * 4、final用来修饰变量：此时的“变量”就是一个“常量”
 *     4.1 final修饰属性：可以考虑赋值的位置有：显示初始化、代码块中初始化、构造器中初始化
 *     4.2 final修饰局部变量：
 *         尤其是使用final修饰形参时，表明此形参是一个常量。当我们调用此方法时，给常量形参赋值一个实参，
 *         一旦赋值以后，就只能在方法体内使用此形参，但不能进行重新赋值。
 *     static final：用来修饰属性：全局常量
 * @Author Eva
 * @Date 2024/5/14 18:35
 */

public class AFinal {
    final int WIDTH = 9;
    final String AA;
    final char BB;
    {
        final double HEIGHT = 2.1;  // 代码块
    }
    public AFinal(char BB){
        this.AA = "aaa";
        this.BB = BB;
    }

    public AFinal(String b){
        this('q');  //构造器
    }
}

final class FF{
    public final void a(){
        System.out.println("不能被继承和重写");
    }

    public static void b(final int s){
//        s+=1;
        System.out.println(s);
    }
}

