package d14java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Description:
 * lambda表达式的使用
 * 1. 举例：（o1,o2）-> Integer.compare(o1,o2)
 * 2. 格式
 *      -> : Lambda操作符 或 箭头操作符
 *      -> 左边：lambda的形参列表（其实就是接口中的抽象方法的形参列表）
 *      -> 右边：lambda体（其实就是重写的抽象方法的方法体）
 * 3. Lambda的使用：（分为6种情况介绍）
 *      总结：
 *      -> 左边：lambda形参列表的参数类型可以省略(类型推断):如Lambda形参列表只有一个参数，其一对()也可以省略
 *      -> 右边：lambda体应该使用一对小括号：如果Lambda体只有一行语句 (可能是return语句)，省略这一对{}和return关键字
 * 4. lambda表达式的本质：作为函数式接口的实例
 * 5. 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口,我们可以在一个接口上使用@Functionallnterface
 *      注解，这样做可以检查它是否是一个函数式接口。
 * 6. 所以以前用匿名实现类表示的现在都可以Lambda表达式来写
 * @Author Eva
 * @Date 2023/8/10 15:27 -> 2024/6/6 15:56
 */
public class BLambda {
    /*
    Lambda 是一个匿名函数，我们可以把 Lambda 表达式理解为是一段可以传递的代码(将代码像数据一
    样进行传递)。使用它可以写出更简洁、更灵活的代码。作为一种更紧凑的代码风格，使Java的语言表达
    能力得到了提升。
     */
    @Test
    public void test01(){
//        语法格式一：无参，无返回值
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱背景天安门");
            }
        };
        r1.run();
        System.out.println("******************");

        Runnable r2 = () -> System.out.println("我爱故宫");
        r2.run();
    }

    @Test
    public void test02(){
        Comparator<Integer> com01 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com01.compare(122,21);
        System.out.println(compare1);

        System.out.println("**************************");

//        Lambda表达式的写法
        Comparator<Integer> com02 = (o1,o2) -> Integer.compare(o1,o2);

        int compare2 = com02.compare(32,12);
        System.out.println(compare2);

        System.out.println("________________________________");

        Comparator<Integer> com03 = Integer::compare;

        int compare3 = com03.compare(32,31);
        System.out.println(compare3);

    }

    @Test
    public void test03(){
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        con1.accept("谎言和誓言的区别是什么？");
        System.out.println("***************************");
//        语法格式二：lambda需要一个参数，但是没有返回值
        Consumer<String> con2 = (String s) ->{
            System.out.println("s");
        };

        con2.accept("一个是听的人当真了，一个是说的人当真了");

    }

    @Test
    public void test04(){
//        语法格式三：数据类型可以省略，因为可由编译器推断出，称为“类型推断”
        Consumer<String> con2 = (s) ->{
            System.out.println("s");
        };

        con2.accept("一个是听的人当真了，一个是说的人当真了");

//        下面是类型推断举例
        ArrayList<String> list = new ArrayList<>();
        int[] arr = {1,2,3};
    }

    @Test
    public void test05(){
//        语法格式四: Lambda 若只高要一个参数时，参数的小号可以省略
        Consumer<String> con2 = s ->{
            System.out.println("s");
        };

        con2.accept("一个是听的人当真了，一个是说的人当真了");
    }

    @Test
    public void test06(){
//        语法格式五: Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com02 = (o1,o2) ->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(12);
        };
        System.out.println(com02.compare(1,2));

        //        语法格式六:当 Lambda 体只有一条语句时，return 与大号若有，都可以省略
        Comparator<Integer> com03 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com03.compare(1,2));
    }
}
