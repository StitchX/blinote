package d6SysMathBig;

import org.junit.Test;

/**
 * @Description: System类
 * @Author Eva
 * @Date 2023/2/13 16:23 -> 2024/5/26 18:20
 */

public class ASystem {
    /*
    构造器private，其余成员变量和成员方法都是static的
    三个成员变量：in out err 输入 输出 错误输出

    成员方法：
    native long currentTimeMillis()：
        返回格林威治时间，时间戳
    void exit(int status)：
        退出程序，0代表正常退出，非0代表异常退出。使用该方法可以再图形界面编程中实现程序的退出功能
    void gc()
        请求系统进行垃圾回收，系统会根据执行情况进行回收
    String getProperty(String key)：
        获取系统中属性名为key的属性对应的值。系统中常见的属性名以及属性的作用如下：

     */
    @Test
    public void test01(){
        System.out.println(System.currentTimeMillis());
//        System.exit(0);
//        System.gc();
//        如下：
        System.out.println(System.getProperty("java.version")); // java运行版本
        System.out.println(System.getProperty("java.home")); // Java安装目录
        System.out.println(System.getProperty("os.name")); // 操作系统名称
        System.out.println(System.getProperty("os.version")); //操作系统版本
        System.out.println(System.getProperty("user.name")); // 用户的账户名称
        System.out.println(System.getProperty("user.home")); // 用户的目录
        System.out.println(System.getProperty("user.dir")); // 用户的当前目录

    }
}
