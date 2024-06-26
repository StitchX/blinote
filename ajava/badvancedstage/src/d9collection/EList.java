package d9collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: List接口
 * 1. List 接口框架
 *     |-----Collection接口：单列集合，用来存储一个一个对象
 *         |----list接口：存储有序的、可重复的数据。 --->"动态"数组
 *             |--ArrayList：作为list接口的主要实现类；线程安全的，效率高；底层使用object[] elementData存储
 *             |--LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用的双向链表存储
 *             |--Vector：作为list接口的古老实现类；线程安全的，效率低；底层使用object[] elementData存储
 *
 *     2. ArrayList的源码分析：
 *     2.1 ArrayList的源码分析：jdk 7 情况下：
 *         ArrayList list = new ArrayList();// 底层创建了长度是10的Object[] 数组elementData
 *         list.add(123);// elementData[0]=new Integer(123);
 *         ...
 *         list.add(11);//如果此次添加导致底层elementData数组容量不够，则扩容。
 *         默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据赋值到新的数组中，
 *
 *         结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity);
 *
 *     2.2 jdk 8 中ArrayList的变化：
 *         ArrayList list = new ArrayList();// 底层Object[] elementData初始化{}，并没有创建长度为10的数组
 *         list.add(123);// 第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData[0]
 *         ...
 *         后续的添加和扩容操作与jdk7无异
 *
 *     2.3 小结：
 *         jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象
 *         的创建类似于单例的懒汉式，延迟了数据的创建，节省内存。
 *
 *     3. LinkList 的源码分析：
 *         LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 *         list.add(123);// 将123封装到Node中，创建了Node对象。
 *
 *         其中，Node定义为：体现了LinkList的双向链表的说法
 *         private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *     4. Vector 的源码分析：jdk7和jdk8中通过Vec()构造器创建对象时，底层都创建了长度为10的数组
 *         在扩容方面，默认扩容为原来的数组长度的2倍。
 *
 * 面试题：HashSet、LinkedHashSet、TreeSet三者的异同？
 *     同：三者类都是实现了List接口，存储数据的特点相同：存储有序的 可重复的数据
 *     不同：见上
 *
 *     5. List 接口中的常用方法
 * @Author Eva
 * @Date 2023/2/20 15:50 -> 2024/6/4 10:41
 */
public class EList {
    @Test
    public void test01(){
        ArrayList list =  new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new YDemo01(12,"tom"));
        list.add(342);

        System.out.println(list);

//        void add(int index, Object ele): 在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);

//        boolean addAll(int index, Collection eles): 从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list.size()); // 9

//        Object get(int index): 获取指定index位置的元素
        System.out.println(list.get(0));
    }

    @Test
    public void test02(){
        ArrayList list =  new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new YDemo01(12,"tom"));
        list.add(342);

        System.out.println(list);

//        int indexOf(Object obj): 返回obj在当前集合中首次出现的位置
        int index = list.indexOf(456);
        System.out.println(index);


//        int lastIndexOf(Object obj): 返回obj在当前集合中末次出现的位置
        int indexLast = list.lastIndexOf(456);
        System.out.println(indexLast);

//        Object remove(int index): 移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

//        Object set(int index, Object ele): 设置志聪index位置的元素为ele
        list.set(1,"CC");
        System.out.println(list);

//        List subList(int formIndex, int toIndex): 返回从fromIndex到toIndex位置左闭右开的子集合
        List sublist = list.subList(2,4);
        System.out.println(sublist);
    }

    @Test
    public void test03(){
//        1) Iterator迭代器方式

//        2) 增强for循环

//        3) 普通的循环

    }
    /*
   void add(int index, Object ele): 在index位置插入ele元素
   boolean addAll(int index, Collection eles): 从index位置开始将eles中的所有元素添加进来
   Object get(int index): 获取指定index位置的元素
   int indexOf(Object obj): 返回obj在当前集合中首次出现的位置
   int lastIndexOf(Object obj): 返回obj在当前集合中末次出现的位置
   Object remove(int index): 移除指定index位置的元素，并返回此元素
   Object set(int index, Object ele): 设置志聪index位置的元素为ele
   List subList(int formIndex, int toIndex): 返回从fromIndex到toIndex位置左闭右开的子集合
    总结：常用方法
    增：add(Object ele)
    删：remove(int index)  / remove(Object obj)
    改：set(int index, Object ele)
    查：get(int index)
    插：add(int index, Object ele)
    长度：size()
    遍历：1) Iterator迭代器方式
         2) 增强for循环
         3) 普通的循环
     */
}
