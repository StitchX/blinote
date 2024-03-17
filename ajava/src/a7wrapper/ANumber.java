package a7wrapper;
import org.junit.Test;

/*
 * @Description:适合在面向对象时学习
 * 包装类的使用：
 * 1、Java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
 * 2、掌握：基本数据类型、包装类、String三者之间的相互转换
 * @Author Eva
 * @Date 2024/3/16 20:59
 */

public class ANumber {
    //    1、基本数据类型---->包装类：调用包装类的构造器
    @Test
    public void demotest1(){
        int num1 = 10;
//        Integer(java.lang.String) is depreacted and marked for removal；
//        (已弃用且做移除标记）这个翻译要注意
//        报错的原因是该放个已经弃用，不影响运行，红色下滑线是做移除的标记
        Integer in1 = new Integer(num1);   //
        Integer in2 = new Integer("123"); //
//        Integer in3 = new Integer("qwe"); // 注意一：字符串里面是数字，否则报错，转换失败
        System.out.println(in1.toString()); // 10

//        注意二：布尔类型源码是：不是true都是 false
        Boolean bo1 = new Boolean("TRue");
        Boolean bo2 = new Boolean("qwq");
        System.out.println(bo1); // true
        System.out.println(bo2); // false

//        注意三：保证类默认是 null
        System.out.println(new Demo01().bo3); // null
        System.out.println(new Demo01().bo4);  // false
    }

    //2、包装类-->基本数据类型：调用包装类的XXXValue()；包装类转换为基本数据类型，可以做基本数据类型运算
    @Test
    public void demotest2(){
        Integer in1 = new Integer(10);
        int in2 = in1.intValue();
        System.out.println(in2 +1 ); // 11
    }

    //    3、JDK 5.0新特性：自动装箱与自动拆箱
    @Test
    public void demotest3(){
        int num = 10;
        boolean bo1 = false;
//        自动装箱：基本数据类型 --->包装类
        Integer in1 = num;
        Boolean bo2 = bo1;
        System.out.println(bo2);  // false
//        自动拆箱：包装类--->基本数据类型
        System.out.println(in1.toString()); // 10
        int num3 = in1;
        System.out.println(in1); // 10
        System.out.println(num3);
    }

    //    4、基本数据类型、包装类 -- > String类型：调用String重载的valueOf(XXX)
    @Test
    public void demotest4(){
        int num1 = 10;
//        方式一：连接运算
        String str1 = num1 +"";  // 10
//        方式二：调用String的valueOf(XXX)
        float f1 = 12.3f;
        String str2 = String.valueOf(f1);  // 12.3

        Double d1 = new Double(11.3);
        String str3 = String.valueOf(d1);  // 11.3

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

    //    5、String——>基本数据类型、包装类：调用包装类的paresXxx(String s)
    @Test
    public void demotest5(){
        String str1 = "123";
        String str2 = "true1";
//        错误的情况
//        int num1 = (int)str1;
//        Integer in1 = (Integer) str1;
//        可能会报NumberFormatException
        int num1 = Integer.parseInt(str1);        // 123
        boolean b1 = Boolean.parseBoolean(str2);  // false

        System.out.println(num1);
        System.out.println(b1);
    }


}
