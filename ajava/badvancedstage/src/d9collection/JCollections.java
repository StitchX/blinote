package d9collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 *    Collections: 操作Collection、Map的工具类
 *
 *    面试题：Collection 和 Collections的区别？
 *        Collection是创建集合的/存储单例数据的接口, 常见的set等; Collections是操作Collection一个工具类
 * @Author Eva
 * @Date 2023/6/14 15:12 -> 2024/6/4 14:09
 */
public class JCollections {
    /*
    reverse(List):反转 List 中元素的顺序
    shuffLe(List): List 集合元素进行随机排序
    sort(List):根据元素的自然顺对指定 List 集合元素按升序排序
    sort(List，Comparator): 根指定的 Comparator 产生的顺序 List 集合元素进行排序
    swap(List，int， int): 指定 List 集合中的 i 元素和 j 元素进行交换

    Object max(ColLection): 根元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection，Comparator): 根据 Comparator 指定的顺序，返回给定集合中的最大元素
    Object min(Collection)
    Object min(Collection, Comparator)
    int frequency(Collection，Object): 返回指定集合中指定元素的出现次数
    void copy(List dest,List src): 将src中的内容复制到dest中
    boolean replaceAll(List list， Object oldVal，Obiect newVal): 使用新值替换List 对象的所有旧值
     */

    @Test
    public void Test01(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(567);
        list.add(23456);
        list.add(567);

        System.out.println(list);
//        Collections.reverse(list);
        Collections.shuffle(list);

        System.out.println(list);

        System.out.println(Collections.frequency(list,567));
    }

    @Test
    public void test02(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(567);
        list.add(23456);
        list.add(567);

//        报异常：
//        List dest = new ArrayList();
//
//        Collections.copy(dest,list);

//        正确的写法
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);

        System.out.println(dest);

        /*
        Collections 类中提供了多个 synchronizedXxx() 方法，
        该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程
        并发访问集合时的线程安全问题
         */
//        返回的list1 即为线程安全的list
        List list1 = Collections.synchronizedList(list);

    }
}
