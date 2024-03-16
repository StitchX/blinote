package a1introduce;

/**
 * @author Eva   Email:
 * @Description  注释
 * @data 2023/1/6 10:47
 */
public class DNote {
    /* 一、自动生成作者信息
     * 自动生成作者信息：file - settings - File and Code Templates - Includes - File Header添加下列信息
     * @author Eva
     * @data ${DATA} ${TIME}
     */

//    二、三种注释
//    Java 支持三种注释方式。前两种分别是 // 和 /* */，第三种被称作说明注释，它以 /** 开始，以 */结束。

    /**
     * 三、给方法加注释
     * 介绍一些，先写方法，后写注释
     * @param a1 参数1
     * @param b1 参数2
     * @return 返回内容的具体解释
     */
    public final double AA(String a1,char b1){
        return 1.1;
    }

//    四、javadoc 标签
//    @author 标识一个类的作者  @deprecated 指名一个过期的类或成员 @version	指定类的版本

//    五、生成doc文档语句：
//    javadoc -encoding UTF-8 HelloWorld.java
//    javadoc -d myHello -author version HelloWorld.java
//    可以使用 javadoc 工具软件来生成信息，并输出到HTML文件中


}
