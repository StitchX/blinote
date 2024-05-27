package d3date;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/2/13 17:15 -> 2024/5/26 17:13
 */

public class DCalendar {
    /*
    4、
    Calendar日历类（抽象类）的使用
    比Date要强大，涉及日期之间的一些操作
    注意：月份，一月是0 ；周日是1
     */
    @Test
    public void test04(){
//        1. 实例化
//        方式一：创建其子类（GregorianCalendar）的对象
//        Calendar g1 = new GregorianCalendar();
//        方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass()); // GregorianCalendar


//        2. 常用方法
//        get()
        int n = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(n); // 这个月的第几天

//        set()
//        calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,5); // 设置为这月的第5天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 从星期天开始算

//        add()
        calendar.add(Calendar.DAY_OF_MONTH,-1); // 获取到的天数加几天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 从星期天开始算

//        getTime() 日历类--->Date
        Date date01 = calendar.getTime();
        System.out.println(date01);

//        setTime()  Date--->日历类    (前面的练习题就会简单点)
        Date date02 = new Date();
        calendar.setTime(date02);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

    }
}
