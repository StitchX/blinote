package d9collection.exercise;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Description: 实现自然排序和定制排序
 * @Author Eva
 * @Date 2023/6/7 14:40 -> 2024/6/4 14:38
 */
public class EmployeeTest {


    //    问题一：使用自然排序
    @Test
    public void test01(){

        TreeSet treeSet = new TreeSet();

        Employee e1 = new Employee("ldh",55,new MyDate(1965,2,3));
        Employee e2 = new Employee("zxy",45,new MyDate(1953,4,3));
        Employee e3 = new Employee("lm",56,new MyDate(1965,5,7));
        Employee e4 = new Employee("gfc",46,new MyDate(1955,4,23));
        Employee e5 = new Employee("lcw",51,new MyDate(1947,8,1));

        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);

        Iterator iterator = treeSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //    问题二：按生日日期排序
    @Test
    public void test02(){
        TreeSet  treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate b1 = e1.getMyDate();
                    MyDate b2 = e2.getMyDate();

//                    方式一：
//                    int sumYear = b1.getYear()-b2.getYear();
//                    if (sumYear !=0){
//                        return sumYear;
//                    }
//                    int subMonth = b1.getMonth()-b2.getMonth();
//                    if (subMonth !=0){
//                        return subMonth;
//                    }
//                    return b1.getDay()-b2.getDay();
//                }

//                    方式二：
                    return b1.compareTo(b2);
                }
                throw new RuntimeException("传入的数据类型不一致！");
            }
        });

        Employee e1 = new Employee("ldh",55,new MyDate(1965,2,3));
        Employee e2 = new Employee("zxy",45,new MyDate(1953,4,3));
        Employee e3 = new Employee("lm",56,new MyDate(1965,5,7));
        Employee e4 = new Employee("gfc",46,new MyDate(1955,4,23));
        Employee e5 = new Employee("lcw",51,new MyDate(1947,8,1));

        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);

        Iterator iterator = treeSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
