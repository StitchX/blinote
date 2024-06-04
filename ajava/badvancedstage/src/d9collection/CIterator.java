package d9collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Description: 9. Iterator迭代器
 * 集合元素的遍历操作，使用迭代器Iterator 接口
 *     1. 内部的方法：hasNext()和next()
 *     2. 集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
 *     3. 内部定义了remove(), 可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 * @Author Eva
 * @Date 2023/2/20 15:19 -> 2024/6/4 10:14
 */
public class CIterator {
    @Test
    public void test01(){
        Collection coll1=new ArrayList();
        coll1.add("AA");
        coll1.add("BB");
        coll1.add("eew");
        coll1.add(123);

        Iterator it01 = coll1.iterator();
//        方式一：
        System.out.println(it01.next());
        System.out.println(it01.next());
        System.out.println(it01.next());
        System.out.println(it01.next());
//        报异常：NoSuchElementException
//        System.out.println(it01.next());

//        方式二：不推荐
        for (int i = 0; i < coll1.size(); i++) {
            System.out.println(it01.next());
        }
//        方式三：
        while (it01.hasNext()){
            System.out.println(it01.next());
        }
        /*
        Iterator迭代器的执行原理：
        hasNext()：判断是否还有下个元素
        next(): 1)指针下移  2)下移以后集合位置上的元素返回
        Iterator是迭代器，不是容器
         */

//        错误方式二：
//        集合对象每次调用iterator() 方法都得到一个全新的迭代器对象，默认游标都在集合的第一个
        while (coll1.iterator().hasNext()){
            System.out.println(coll1.iterator().next());
        }

    }

    /*
    测试Iterator中的remove()
    如果还未调用next()或在上一次调用next()方法之后已经调用了remove方法，再调用remove都会报IllegalDtateException
     */
    @Test
    public void test02(){
        Collection coll1=new ArrayList();
        coll1.add("AA");
        coll1.add("BB");
        coll1.add("eew");
        coll1.add(123);

        Iterator it01 = coll1.iterator();
//        测试Iterator中的remove()
//        如果还未调用next()或在上一次调用next方法之后调用了remove方法，
//        再调用remove都会报IllegalStateException

        while (it01.hasNext()){
            Object obj = it01.next();
            if ("eew".equals(obj)){
                it01.remove();
            }
        }

        Iterator it02 = coll1.iterator();
        while (it02.hasNext()){
            System.out.println(it02.next());
        }

    }
}
