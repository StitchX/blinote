package d9collection;

import org.junit.Test;

import java.util.*;

/**
 * @Description: Collection接口中的常用方法
 * Collection接口中声明的方法的测试
 *     结论：
 *         向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 * @Author Eva
 * @Date 2023/2/15 16:24 -> 2024/6/4 9:50
 */
public class BCollection {

    @Test
    public void test01(){
        Collection coll1=new ArrayList();
        Collection coll2=new ArrayList();
//        add(Object e): 将元素e添加到集合coll中
        coll1.add("AA");
        coll2.add("AA");
        coll1.add("BB");
        coll1.add(123); // 自动装箱
        coll1.add(new Date());

//        addAll(Collection coll1): 将coll1的集合中的元素添加到当前的集合中
        coll2.addAll(coll1);
        System.out.println(coll2.size()); // 5
//        clear(): 清空集合元素
        coll1.clear();

//        isEmpty(): 判断当前集合是否为空
        System.out.println(coll1.isEmpty()); // true; 元素清空，对象还在

//        size(): 获取添加的元素的个数
        System.out.println(coll1.size()); // 0
    }


        @Test
        public void test02(){
            Collection coll1=new ArrayList();
            coll1.add("AA");
            coll1.add("BB");
            coll1.add("eew");
            coll1.add(123);
            coll1.add(new String("qwe"));
            coll1.add(false);
            coll1.add(new YDemo01(13,"jerry"));

//        1. contains(Object obj)：判断当前集合中是否包含obj
//        我们在判断时会调用obj对象所在类的equals()
            boolean contains  = coll1.contains(123);
            System.out.println(contains); // true
            System.out.println(coll1.contains(new String("qwe"))); //true 证明调用的是重写的equals方法

//        原方法toString被重写过，所以是true
            System.out.println(coll1.contains(new YDemo01(13,"jerry")));

//        2. containsAll(Collection coll1): 判断形参coll1中的所有元素是否都存在当前集合中
//        顺序可以不相同
            Collection coll2=new ArrayList();
            coll2.add("AA");
//            coll2.add("BB");
            coll2.add("eew");
            coll2.add(123);
            coll2.add(new String("qwe"));
            coll2.add(false);
            coll2.add(new YDemo01(13,"jerry"));
            System.out.println(coll2.containsAll(coll1)); // false

        }

        @Test
        public void test03(){
            Collection coll1=new ArrayList();
            coll1.add("AA");
            coll1.add("BB");
            coll1.add("eew");
            coll1.add(123);

    //        remove(Object obj): 从当前集合中移除obj元素
            System.out.println(coll1.remove("AAB")); // false
            System.out.println(coll1); // [AA, BB, eew, 123]

    //        4. removeAll(Collection coll) : 从当前集合中移除coll中所有元素
            Collection coll2=new ArrayList();
            coll2.add("AA");
            coll2.add("eew");
            coll2.add(123);
            coll2.add(new String("qwe"));
            coll2.add(false);

            coll2.removeAll(coll1);
            System.out.println(coll2); // [qwe, false]
        }

        @Test
        public void test04(){
            Collection coll1=new ArrayList();
            coll1.add("AA");
            coll1.add("BB");
            coll1.add("eew");
            coll1.add(123);

    //        5. retainAll(Collection coll): 交集，获取当前集合和coll1集合的交集，并返回给当前集合
            Collection coll2 = Arrays.asList(123,456,789);
            coll1.retainAll(coll2);
            System.out.println(coll1); // [123]
    //        6. equals(Object obj): 要想返回true，需要当前集合和形参集合的元素都相同
    //        需要有序
            System.out.println(coll1.equals(coll2)); // false

            Collection coll3 = Arrays.asList(456,123,789);
            System.out.println(coll2.equals(coll3)); // false , 注意顺序也要相同

        }

        @Test
        public void test05(){
            Collection coll1=new ArrayList();
            coll1.add("AA");
            coll1.add("BB");
            coll1.add("eew");
            coll1.add(123);

    //        7. hashCode()：返回当前对象的哈希值
            System.out.println(coll1.hashCode());

    //        8. 集合 --- > 数组：toArray()
            Object[] arr = coll1.toArray();
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }

    //        拓展：数组--->集合：调用Arrays类的静态方法asList()
            List list = Arrays.asList(new String[]{"11","22","33"});
            System.out.println(list);

            List arr1 = Arrays.asList(new int[]{123,321}); // 会认为是一个元素
            System.out.println(arr1);

    //        解决方案
            List arr2 = Arrays.asList(new Integer[]{123,321});
            System.out.println(arr2.size());

            List arr3 = Arrays.asList(123, 456);
            System.out.println(arr3);
        }
}
