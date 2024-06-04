package d9collection;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 *     向TreeMap中添加key-value，要求key必须是右同一个类创建的对象
 *     因为要按照key进行排序：自然排序、定制排序
 * @Author Eva
 * @Date 2023/6/14 11:41 -> 2024/6/4 13:43
 */
public class HTreeMap {
    @Test
    public void test01(){
        Map map = new TreeMap();

        YDemo02 y1 = new YDemo02("tom",12);
        YDemo02 y2 = new YDemo02("jerry",23);
        YDemo02 y3 = new YDemo02("lisa",33);
        YDemo02 y4 = new YDemo02("cc",17);
        map.put(y1,43);
        map.put(y2,55);
        map.put(y3,60);
        map.put(y4,90);

        Set entrySet = map.entrySet();
        Iterator it01 = entrySet.iterator();
        while (it01.hasNext()){
            Object obj = it01.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey()+"---->" +entry.getValue());
        }
    }

    @Test
    public void test02(){
        Map map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof YDemo02 && o2 instanceof YDemo02){
                    YDemo02 y1 = (YDemo02) o1;
                    YDemo02 y2 = (YDemo02) o2;
                    return Integer.compare(y1.getAge(),y2.getAge());
                }
                throw new RuntimeException("输入类型不匹配！");
            }
        });

        YDemo02 y1 = new YDemo02("tom",12);
        YDemo02 y2 = new YDemo02("jerry",23);
        YDemo02 y3 = new YDemo02("lisa",33);
        YDemo02 y4 = new YDemo02("cc",17);
        map.put(y1,43);
        map.put(y2,55);
        map.put(y3,60);
        map.put(y4,90);

        Set entrySet = map.entrySet();
        Iterator it01 = entrySet.iterator();
        while (it01.hasNext()){
            Object obj = it01.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey()+"---->" +entry.getValue());
        }
    }

}
