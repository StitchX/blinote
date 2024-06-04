package d9collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Description: 面试题 set
 * @Author Eva
 * @Date 2023/6/6 16:21 -> 2024/6/4 14:32
 */
public class Z2Interviewer {

    //    练习一：在List内去除重复数字值，要求尽量简单
    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
    @Test
    public void test01(){
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));

        List list2 = duplicateList(list);
        for (Object integer:
                list2) {
            System.out.println(integer);
        }

    }
}
