package a7wrapper;

import org.junit.Test;

/**
 * @Description:
 * String 类
 * 注意：String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了。
 *       如果需要对字符串做很多修改，那么应该选择使用 StringBuffer & StringBuilder 类。
 * @Author Eva
 * @Date 2024/3/16 21:40
 */

public class C1String {
    String s1 = "nihao";  // String 直接创建；存储在公共池中
    String s2 = new String();  // String 对象创建；存储在堆中
    String s3=s1;   // 相同引用
    String s4 = "";
    //        char c1 = '';  报错
    public static void main(String[] args) {
        String s1 = "nihao";  // String 直接创建；存储在公共池中
        String s2 = new String();  // String 对象创建；存储在堆中
        String s3=s1;   // 相同引用
        String s4 = "";
//        char c1 = '';  报错


        char[] a = {'a','b','c','d'};
        String aa = new String(a);
        System.out.println(aa);  // abcd




//        输出格式化数字可以使用 printf() 和 format() 方法
        System.out.printf("格式化输出：%s",a[0]);

        String fs = String.format("格式化赋值：%s",a[1]);
        System.out.println(fs);  // 格式化赋值：cainiao.b

//        String 方法
        System.out.println( aa.charAt(3));  // d 返回指定索引处的字符
        System.out.println(aa.compareTo("3ffee")); // 46，比较
        System.out.println(aa.isEmpty());  //  false 判断字符串是否为空


//        String 可以和八种数据类型做运算，且只能是连接预算，运算结果还是String类型
        System.out.println(s1 + 33 + true);  // nihao33true

        System.out.println('*'+'\t'+'*');  //93
        System.out.println('*'+"\t"+'*');  // *	*
        System.out.println('*'+'\t'+"*");  // 51*

        String s5 = "33";
        char c2 = '1';
//        System.out.println((int)s5);  报错
        System.out.println(Integer.parseInt(s5));  // 可以这样转换
        System.out.println((int)c2);  // 49
        char c3 = 97;
        System.out.println(c3);  // a

    }

    @Test
    public void demo01(){
        char[] a = {'a','b','c','d'};
        String aa = new String(a);
        System.out.println(aa);  // abcd
    }

    // 长度
    @Test
    public void demo02(){
        System.out.println(s1.length());  // 5
    }

    // 连接
    @Test
    public void demo03(){
        System.out.println(s1.concat("bb")); // nihaobb
        System.out.println(s2+"cc"); //cc

    }

    // 输出格式化数字可以使用 printf() 和 format() 方法
    @Test
    public void demo04(){
        char[] a = {'a','b','c','d'};
        String aa = new String(a);
        System.out.printf("格式化输出：%s",a[0]);

        System.out.println();
        String fs = String.format("格式化赋值：%s",a[1]);
        System.out.println(fs);
    }


    // String 方法
    @Test
    public void demo05(){
        System.out.println( s1.charAt(3));  // a 返回指定索引处的字符
        System.out.println(s1.compareTo("3ffee")); // 59，比较
        System.out.println(s1.isEmpty());  //  false 判断字符串是否为空
    }

    // String 可以和八种数据类型做运算，且只能是连接预算，运算结果还是String类型
    @Test
    public void demo06(){
        System.out.println(s1 + 33 + true);  // nihao33true

        System.out.println('*'+'\t'+'*');  //93
        System.out.println('*'+"\t"+'*');  // *	*
        System.out.println('*'+'\t'+"*");  // 51*

        String s5 = "33";
        char c2 = '1';
//        System.out.println((int)s5);  报错
        System.out.println(Integer.parseInt(s5));  // 可以这样转换
        System.out.println((int)c2);  // 49
        char c3 = 97;
        System.out.println(c3);  // a
    }

    //    错误示范
    @Test
    public void demo07(){
        String s9 = "qwe123";

//        会报错
//        s9[1]="1";
//        s9.charAt(1);
//        s9.charAt(2) = '1';
//        s9.append('1');

//        指向另一个对象，不是改变已有的数据
        s9="123";
        s9 = new String("321");
        System.out.println(s9);

    }


}
