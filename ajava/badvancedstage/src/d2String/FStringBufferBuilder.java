package d2String;

import org.junit.Test;

/**
 * @Description: 关于StringBuffer和StringBuilder的使用
 * 注意：三者的区别
 * @Author Eva
 * @Date 2024/5/26 16:59
 */

public class FStringBufferBuilder {
    /*
    String、StringBuffer、StringBulider三者的异同？
    String：不可变的字符序列，底层使用char[]存储
    StringBuffer: 可变的字符序列；线程安全，效率低；底层使用char[]存储; 底层使用了synchronized同步解决线程安全
    StringBulider:可变的字符序列；jdk5.0新增的，线程不安全，效率高； 底层使用char[]存储；与StringBuffer方法差不多

    效率对比：2*StringBulider约等于StringBuffer 远快于 String

    源码分析：
    String str1 = new String();//char[] value = new char[0];
    String str2 = new String("abc")//char[] value = new char[]{'a','b','c'}

    StringBuffer sb1 = new StringBuffer();//char[] value = new char[16]; 底层创建了一个长度是16的数组
    System.out.println(sb1.length());
    sb1.append('a');//value[0]=a
    sb1.append('b');//value[1]=b

    StringBuffer sb2 = new StringBuffer("abc"); // char[] value = newchar["abc".length()+16]4

    问题1：System.out.println(sb1.length()); // 0
    问题2：扩容问题：如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组。
        默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中

        指导意义：开发中建议大家使用：StringBuffer(int capacity) 或 StringBilder(int capacity)
     */

    /*
    StringBuffer/Builder的一些方法：
    append(XXX)：提供了很多的append()方法，用于进行字符串拼接
    delete(int start,int end)：删除指定位置的内容
    replace(int start, int end, String str)：把[start,end]位置替换为str
    insert(int offset, xxx)：在指定位置插入xxx
    reverse()：把当前字符串序列逆转
    public int indexOf(String str)
    public String substring(int start,int end)
    public int length()
    public char charAt(int n)
    public void setCharAt(int n, char ch)

    总结：
    增：append(XXX)
    删：delete(int start,int end)
    改：setCharAt(int n, char ch)
    查：charAt(int n)
    插：insert(int offset, xxx)
    长度：length()
    遍历：for() + charAt() / toString()

    如上方法支持方法链操作。原理需要后面查一查

     */
    StringBuilder sb1 = new StringBuilder(10);
    StringBuilder sb2 = new StringBuilder("hello world");

    StringBuilder sb3 = new StringBuilder();

    // 增
    @Test
    public void demo01(){
        sb3.append('A');
        sb3.append("a2");
        sb3.insert(1,"a3");
        System.out.println(sb3); // Aa3a2
        System.out.println(sb3.length()); // 5
    }

    // 删
    @Test
    public void demo02(){
        sb2.delete(0,4);
        System.out.println(sb2); // o world
    }

    // 改
    @Test
    public void demo03(){
        sb2.replace(1,2,"123");
        System.out.println(sb2); // h123llo world
        sb2.reverse();
        System.out.println(sb2); // dlrow oll321h
    }

    //    有初始化长度,但实际长度还是 0
    @Test
    public void demo04(){
        StringBuffer sbu1 = new StringBuffer("qwertyu");
        StringBuffer sbu2=new StringBuffer(10);
        System.out.println(sbu1.length());  // 7
        System.out.println(sbu2.length()); // 0

        sbu2.append('z');
        System.out.println(sbu2.length()); // 1
//        sbu2.insert(3,'d'); // 报错:Range [3, 1) out of bounds for length 1
    }

    // 查
    @Test
    public void demo05(){
//        "hello world"
        System.out.println(sb2.charAt(1));  //e 返回指定索引处字符
        System.out.println(sb2.capacity()); //27 返回当前容量
        System.out.println(sb2.indexOf("1")); //2 返回第一次出现的指定子字符串在该字符串中的索引。
        System.out.println(sb2.indexOf("w",1)); //从指定的索引处开始，返回第一次出现的指定子字符串在该字符串中的索引。
    }
}
