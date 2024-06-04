package d9collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 面试题 List
 *      区分List中的remove(int index) 和 remove(Object obj)
 * @Author Eva
 * @Date 2023/6/6 16:21 -> 2024/6/4 14:30
 */
public class Z1Interviewer {
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private static void updateList(List list){
        list.remove(2);
//        list.remove(new Integer(2));
    }
}
