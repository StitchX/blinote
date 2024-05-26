package d5comparable;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description: 重点：排序；
 *  *              自然排序 Comparable
 * @Author Eva
 * @Date 2023/2/13 11:48 -> 2024/5/26 17:45
 */

public class AComparable {
    /*
    Comparable接口的使用举例：自然排序
    1. 像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出比较两个对象
    2. 像String、包装类重写了compareTo(obj)方法以后，进行了从小到大排序
    3. 重写compareTo(obj)的规则：
        如果当前对象this大于形参对象obj，则返回正整数
        如果当前对象this等于形参对象obj，则返回0
        如果当前对象this小于形参对象obj，则返回负整数
    4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法
        在compareTo(obj)方法中指明如何排序
     */
    @Test
    public void test01(){
        String[] arr = new String[]{"AA","DD","FF","BB","CC","EE"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //    自定义类的比较
    @Test
    public void test02(){
        YDemo[] goods = new YDemo[5];
        goods[0] = new YDemo("华为",1230);
        goods[1] = new YDemo("小米",7654);
        goods[2] = new YDemo("魅族",4532);
        goods[3] = new YDemo("锤子",3121);
        goods[4] = new YDemo("oppo",1458);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));

    }
}
