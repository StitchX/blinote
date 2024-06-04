package d9collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Description: jdk5 新增foreach循环，用于遍历集合、数组
 * @Author Eva
 * @Date 2023/2/20 15:44 -> 2024/6/4 10:32
 */
public class DForEach {

    @Test
    public void demo01(){
        Collection coll1=new ArrayList();
        coll1.add("AA");
        coll1.add("BB");
        coll1.add("eew");
        coll1.add(123);

        for (Object obj :
                coll1) {
//            for(集合元素的类型 局部变量：集合对象)
//            内部仍然调用了迭代器
            System.out.println(obj);
        }
    }

    //    练习题
    @Test
    public void test3(){
        String[] arr = new String[]{"DD","DD","DD"};

//        方式一：普通for赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i]="FF";
        }

//        方式二：增强for循环
        for (String s:
                arr) {
            s = "HH";
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
    }
}
