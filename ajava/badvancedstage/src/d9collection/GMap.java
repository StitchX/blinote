package d9collection;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * 一、Map实现类的结构：
 * |--- Map: 双列数据，存储key-value对的数据 -- 类似于告知的函数：y=f(x)
 *      |--HashMap: 作为Map的主要实现类；线程不安全，效率高；存储null的key和value
 *          |--LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历
 *              原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *              对于频繁的遍历操作，此类执行效率高于HahsMap。
 *       |--TreeMap: 保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序和定制排序。
 *                  底层使用的红黑树
 *      |--Hashtable: 作为古老的实现类；线程安全，效率高；不能存储null的key和value
 *          |-- Properties: 常用来处理配置文件。key和value都是String类型
 *
 *
 *       HashMap的底层： 数组+链表 （jdk7及之前）
 *                      数组+链表+红黑树（jdk 8）
 *
 *  面试题：
 *      1. HashMap的底层实现原理？
 *      2. HashMap 和 Hashtable的异同？
 *      3. CurrentHashMap 与 Hashtable的异同？ （暂时不讲）
 *
 * 二、Map结构的理解：
 *      Map中的key：无序的、不可重复的，使用Set存储所有的key --> key所在的类要重写equals()和hashCode() （以HashMap为例）
 *      Map中的value：无序的、可重复的，使用Collection存储所有的value -->value所在的类要重写equals()
 *      一个键值对：key-value构成了一个Entry对象
 *      Map中的entry：无序的、不可重复的，使用Set存储所有的entry
 *
 * 三、HashMap的底层实现原理? 以jdk7为例说明:
 *      HashMap map = new HashMap():
 *      在实例化以后，底层创建了长度是16的一数组Entry[] table
 *      ...可能已经执行过多次put...
 *      map.put(key1, value1):
 *      首先，调用key1所在类的hashCode()计key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置。
 *      如果此位置上的数据为空，此时的key1-value1添加成功。 ---- 情况1
 *      如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在)，比key1和已经存在的一个或多个数据的哈希值:
 *       如果key1的哈希值与已经存在的数的哈希值都不相同，此时key1-value1添加成功。----情况2
 *       如key1的哈希值和已经存在的某一个数(key2-value2)的哈希值相同，继续比: 调用key1所在类的equals(key2)
 *          如果equals()返回false:此时kev1-value1添加成功。----情况3
 *          如果equals(0)返true: 使value1 value2
 *
 *       补充:关于情况2和情况3: 此时key1-value1和原来的数以链表的方式存储
 *
 *       在不断的添加过程中，会涉及到扩容问题，当超出临界值（且要存放的位置非空），扩容。默认的扩容方式:扩容为原来容量的2倍，并将原有的数据复制过来。
 *
 *       jdk8 相较于idk7在底层实现方面的不同:
 *       1.new HashMap(): 底层没有创建一个长度为16的数组
 *       2.jdk 8底层的数组是: Node[],而非Entry[]
 *       3.首次调用put()方法时，底层创建长度为16的数组
 *       4.jdk7底层结构只有: 数组+链表。jdk8中底层结构: 数组+链表+红黑树。
 *       当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度>64时
 *       此时此索引位置上的所有数摇改为使用红黑树存储。
 *
 *       DEFAULT INITIAL CAPACITY :HashMap的默认容量，16
 *       DEFAULT LOAD FACTOR:HashMap的默认加载因子 0.75
 *       threshold:扩容的临界值，=容量填充因子   16*0.75=12
 *       TREEIFY_THRESHOLD: Bucket中链表长度大于该默认值，转化为红黑树 8
 *       MIN_TREEIFY_CAPACITY: 桶中的Node被树化时最小的hash表容量，64
 *
 *
 *    四、linkHashMap 的底层实现原理（了解）
 *    源码中：
 *    static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;  // 能够记录添加的元素的先后顺序
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 *     五、Map中定义的方法:
 *      添加、删除、修改操作:
 *      Object put(Object key,Object value): 指keyvalue添加到(或修改)当前map对象中
 *      void putALL(Map m):将m中的有key-value对存放到当前map中
 *      Object remove(Object key): 移除指定key的key-value对，并返回value
 *      void cLear(): 清空当前map 中的所有效据
 *      元素查询的操作:
 *      Object get(Object key): 获指定key应的value
 *      boolean containsKey(Object key):是否包合指定的key
 *      boolean containsValue(Object value): 是否包合指定的value
 *      int size():返map中key-value对的个数
 *      boolean isEmpty(): 判断当前map是否为空
 *      boolean equals(Object obi): 判断当前map和参数对象obi是否相等
 *      元视图操作的方法:
 *      Set keySet():返回所有key构成的Set集合
 *      CoLLection values(): 返回所有vaLue成的CoLLection集合
 *      Set entrySet():返所有key-value对成的Set集合
 *
 *   总结:常用方法:
 *      添加: put(Object key,Object value)
 *      删除: remove(Object key)修改: put(Object key,Object value)
 *      查询:get(Object key)长度: size()
 *      遍历: keySet() / values() / entrySet()
 * @Author Eva
 * @Date 2023/6/7 15:51 -> 2024/6/4 11:04
 */
public class GMap {

    @Test
    public void test01(){
//        Map map = new HashMap();
        Map map = new LinkedHashMap();

        map.put(1,"wwq");
        map.put(2,"oi");
        map.put(33,"odk");

        System.out.println(map);
    }

    /*
        添加、删除、修改操作:
          Object put(Object key,Object value): 指keyvalue添加到(或修改)当前map对象中
          void putALL(Map m):将m中的有key-value对存放到当前map中
          Object remove(Object key): 移除指定key的key-value对，并返回value
          void cLear(): 清空当前map 中的所有效据
     */

    @Test
    public void test02(){
        Map map1 = new HashMap();

//        添加
        map1.put("q","oiu");
        map1.put("SS","oiu");
        map1.put(321,"oiu");
//        修改
        map1.put("q","ooi");

        Map map2 = new HashMap();
        map2.put("te","r");
        map2.put("bb","e");

        map1.putAll(map2);

        System.out.println(map1);

//        remove(Object key)
        Object obj = map1.remove("q"); // 不存在则返回null
        System.out.println(obj);
        System.out.println(map1);

//        clear()
        map1.clear();  // 与map = null操作不同
        System.out.println(map1);
    }
    /*
    元素查询的操作:
      Object get(Object key): 获指定key应的value
      boolean containsKey(Object key):是否包合指定的key
      boolean containsValue(Object value): 是否包合指定的value
      int size():返map中key-value对的个数
      boolean isEmpty(): 判断当前map是否为空
      boolean equals(Object obi): 判断当前map和参数对象obi是否相等
     */
    @Test
    public void test03(){
        Map map1 = new HashMap();

        map1.put("q","oiu");
        map1.put("SS","GG");
        map1.put(321,"32R");
//
        System.out.println(map1.get(321)); // 不存在则为：null

        System.out.println(map1.containsKey("SS"));
        System.out.println(map1.containsValue("oiu"));

        map1.clear();
        System.out.println(map1.isEmpty());

    }
    /*
    元视图操作的方法:
      Set keySet():返回所有key构成的Set集合
      Collection values(): 返回所有vaLue成的Collection集合
      Set entrySet():返所有key-value对成的Set集合
     */

    @Test
    public void test04(){
        Map map1 = new HashMap();

        map1.put("q","oiu");
        map1.put("SS","GG");
        map1.put(321,"32R");

//        遍历所有元素，由于key和value是两个集合，所以获取到两个集合就行
//        遍历所有的key集：keySet()
        Set set1 = map1.keySet();
        Iterator iterator1 = set1.iterator();

        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println("-------------");

//        遍历所有的value集：values()
        Collection collection = map1.values();
        Iterator iterator2 = collection.iterator();

        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
        System.out.println("-------------");
//        遍历所有的key-value
//        方式一：entrySet()
        Set entrySet = map1.entrySet();
        Iterator it01 = entrySet.iterator();
        while (it01.hasNext()){
            Object obj = it01.next();
//            entrySet 集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey()+"---->" +entry.getValue());
        }

//        方式二：
//        获取所有的key，通过key获取到value，不写了，上面方法拼凑出来的

//        遍历的目的是一个一个取出来

    }
}

/*
面试题:
    谈谈你对HashMap中put/get方法的认识?
    如果了解再谈谈HashMap的扩容机制?
    默认大小是多少?
    什么是负载因子（或填充比)?
    什么是吞吐临界值(或阅值、threshold)?

HashMap源码中的重要常量
        DEFAULT INITIAL CAPACITY :HashMap的默认容量，16
        MAXIMUM CAPACITY: HashMap的最大支持容量，2^30
        DEFAULT LOAD FACTOR:HashMap的默认加载因子 0.75
        TREEIFY_THRESHOLD: Bucket中链表长度大于该默认值，转化为红黑树 ：8
        UNTREEIFY_THRESHOLD: Bucket中红黑树存储的Node小于该默认值，转化为链表
        MIN_TREEIFY_CAPACITY: 桶中的Node被树化时最小的hash表容量， (当桶中Node的数量大到需要变红黑树时
            ，若hash表容量小于MIN TREEIFY CAPACITY时，此时应执行resize扩容操作这个
            MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的4倍。) 64
        table:存储元素的数组，总是2的n次幂
        entrySet:存储具体元素的集
        size: HashMap中存储的键值对的数量
        modCount: HashMap扩容和结构改变的次数
        threshold:扩容的临界值，=容量填充因子   16*0.75=12
        loadFactor: 填充因子
 */
