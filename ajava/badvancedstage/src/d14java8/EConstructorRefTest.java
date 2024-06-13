package d14java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description:
 *
 *  一、构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构道器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属的类的类型
 *  二、数组引用
 *      大家可以把数组看做是一个特殊的类，则写法与构造器引用一致
 * @Author Eva
 * @Date 2023/8/18 11:29 -> 2024/6/13 11:05
 */
public class EConstructorRefTest {
    //    构造器引用
//    Supplier中的T get()
    @Test
    public void test01(){
        Supplier<YEmployee> sup = YEmployee::new;
        System.out.println(sup.get());
    }


    //    Function中的R apply(T t)
    @Test
    public void test02(){
        Function<Integer,YEmployee> function = YEmployee::new;
        YEmployee employee = function.apply(1002);
        System.out.println(employee);
    }

    //    BiFunction中的R apply(T t,U u)
    @Test
    public void test03(){
        BiFunction<Integer,String ,YEmployee> fun = YEmployee::new;
        System.out.println(fun.apply(1002,"tom"));
    }

    //    数组的引用
//    Function中的R apply(T t)
    @Test
    public void test04(){
        Function<Integer,String[]> function = length -> new String[length];
        String[] arr1 = function.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("************************************");
        Function<Integer,String[]> func2 = String[] :: new;
        String[] arr2 = func2.apply(10);
        System.out.println(Arrays.toString(arr2));
    }
}
