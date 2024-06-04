package d10generic;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Author Eva
 * @Date 2024/6/4 15:03
 */
public class AIntroduce {
    /*
    1、为什么要有泛型
    2、在集合中使用泛型
    3、自定义泛型结构
    4、泛型在继承上的体现
    5、通配符的使用
    6、泛型应用举例
     */

    /*
    泛型的使用
    1、jdk 5.0 新增的特性
    2、在集合中使用泛型
      1）集合接口或集合类在jdk5.0 时都修改为带泛型的结构。
      2）在实例化集合类时，可以指明具体的泛型类型
      3）指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型位置，都指定为实例化的泛型类型。
         比如：add(E e)   ----> 实例化以后：add(Integer e)
      4）注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换。
      5）如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型

     3、如何自定义泛型结构：泛型类、泛型接口；泛型方法。见 Cuse.java
     */

    //    在集合中使用泛型之前的情况:
    @Test
    public void test01(){
        ArrayList list = new ArrayList();
//        需求：存放学生的成绩
        list.add(78);
        list.add(67);
        list.add(90);
        list.add(89);
//        问题一：类型不安全
        list.add("tom");

        for (Object score:
                list) {
//            问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }


    //    在集合中使用泛型之前的情况:以ArrayList为例
    @Test
    public void test02(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(21);
        list.add(21);
//        编译时，就会进行类型检查，保证数据安全
//        list.add("AA");

//        方式一：
        for (Integer score:
                list) {
//          避免了强转操作
            int stuScore = score;
            System.out.println(stuScore);
        }

//        方式二：
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }

    }
    //    在集合中使用泛型之前的情况:以HashMap为例
    @Test
    public void test03(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("Tom",87);
        map.put("jerry",87);
        map.put("jack",77);

//        泛型的嵌套
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entry.iterator();

        while (iterator.hasNext()){
            Map.Entry<String,Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + " --" + value);
        }
    }
}
