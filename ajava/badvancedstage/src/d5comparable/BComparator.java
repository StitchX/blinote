package d5comparable;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.sort;

/**
 * @Description: 定制排序
    一、说明：Java中的对象，正常情况下，只能进行比较：== 或 != 。不能使用>或<的
    但是开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。

    二、Comparable接口与Comparator的使用的对比：
    Comparable接口的方式一旦一定，保证Comparable接口实现类的对象再任何位置都可以比较大小
    Comparator接口属于临时性的比较
 * @Author Eva
 * @Date 2023/2/13 15:29 -> 2024/5/26 17:54
 */

public class BComparator {
    /*
    重写compare(Object o1, Object o2)方法，比较o1和o2的大小
    如果方法返回正整数，则表示o1大于o2
    如果返回0，表示相等
    返回负整数，表示o1小于o2
     */
    @Test
    public void test01(){
        String[] arr = new String[]{"AA","DD","FF","BB","CC","EE"};
        sort(arr,new Comparator(){
            //            按照字符串从大到小排序
            @Override
            public int compare(Object o1,Object o2) {
                if (o1 instanceof String && o2 instanceof String ){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test02(){
        YDemo[] goods = new YDemo[5];
        goods[0] = new YDemo("华为",1230);
        goods[1] = new YDemo("小米",7654);
        goods[2] = new YDemo("魅族",4532);
        goods[3] = new YDemo("锤子",3121);
        goods[4] = new YDemo("oppo",1458);

        sort(goods,new Comparator(){
            //        Arrays.sort(goods,new Comparator(){
//            指明商品比较大小的方式：按照产品名称从低到高排序，再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof YDemo && o2 instanceof YDemo){
                    YDemo goods01 = (YDemo) o1;
                    YDemo goods02 = (YDemo) o2;
                    if (goods01.getName().equals(goods02.getName())){
                        return -Double.compare(goods01.getPrice(),goods02.getPrice());
                    }else {
                        return goods01.getName().compareTo(goods01.getName());
                    }
                }
                throw new RuntimeException("输入数据不一致");
            }
        });
        System.out.println(Arrays.toString(goods));

    }
}

// 底层是Arrays中使用了归并排序法，自学完，后续忘记重看
