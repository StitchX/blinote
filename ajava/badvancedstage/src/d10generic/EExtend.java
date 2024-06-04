package d10generic;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * 1. 泛型在继承方面的体现
 * 2. 通配符的使用
 * ps : 复习时没有怎么看懂，需要重新学习下collection和这个扩展
 * @Author Eva
 * @Date 2023/6/26 11:30 -> 2024/6/4 15:28
 */
public class EExtend {
    /*
    1. 泛型在继承方面的体现
    虽然类A是类B的父类，但是G<A>，和G<B>二者不具备字符类关系，二者是并列关系。

    补充：类A是类B的父类，A<G> 是 B<G> 的父类
     */

    @Test
    public void test01(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;
//    编译不通过
//    Date date = new Date();
//    str = date;

        List<Object> list1 = null;
        List<String > list2 = new ArrayList<String>();
//    此时的list1和list2的类型不具有字符类关系
//    编译不通过
//    list1 = list2;

    /*
    反证法：
    假设list1=list2;
    list1.add(123); 导致混入非String的数据，出错
     */
        show1(list2);
        show2(list1);


    }

    public void show1(List<String> list){

    }
    public void show2(List<Object> list){

    }

    @Test
    public void test02(){
        AbstractList<String> list1 = null;
        List<String> list2=null;
        ArrayList<String > list3 = null;

        list1 = list3;
        list2 = list3;
        List<String> list4 = new ArrayList<>();
    }

    /*
    2. 通配符的使用
    通配符：？

    类A是类B的父类，G<A> 和 G<B>是没有关系的，二者共同的父类是：G<?>
     */

    @Test
    public void test03(){
        List<Object> list1 = null;
        List<String > list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;
        print(list1);
        print(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("AB");
        list3.add("AC");
        list = list3;

        //添加(写入): 对于List<?>就不能向其内部添加数据
        // 除了添加nulL之外
//        list.add("AA");

        list.add(null);

//        //获取(读取): 允许读取效，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);

    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
    3.有限制条件的通配符的使用
        ？ extent A：
            G<? extends A>可以作为G<A>和G<B>的父类，其中B是A的子类
        ? extent A：
            G<? super A>可以作为G<A>和G<B>的父类，其中B是A的父类
     */

    @Test
    public void test04(){
        List<? extends YDemo03> list1 = null;
        List<? super YDemo03> list2 = null;

        List<YDemo04> list3 = new ArrayList<YDemo04>();
        List<YDemo03> list4 = new ArrayList<YDemo03>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5

//        list2 = list3
        list2 = list4;
        list2 = list5;

//        读取数据
        list1 = list3;
        YDemo03 y3 = list1.get(0);
//        编译不通过
//        YDemo04 y4 = list1.get(0);
    }
}
