package a1introduce;

/**
 * @author Eva   Email:
 * @Description Java特性
 * @Date 2023/1/6 10:45
 */
public class BFeatures {
    /*

    Java首先是一种编程语言
        它是一种面向对象的编程语言（OOP）
        它的语法结构与C和C++语言极为相似
        Java所用的语法十分简单

        主要特性：（11个）
            简单
            面向对象
            分布式
            健壮
            安全
            体系结构中立
            可移植
            解释型
            高性能
            多线程
            动态


        Java提供了大量的类以满足网络化、多线程、面向对象系统的需要
            语言包(package)
            实用程序包
            I/O包
            网络包
            图形用户界面包
            And More……


        可以做什么：
            面向对象的应用开发
            各类网络应用程序的开发
            计算过程的可视化
            动态画面/交互操作
            Internet的系统管理
            数据库操作
            And more ……




        Java三种核心机制
            Java 虚拟机(Java Virtual Machine)
            代码安全性检测(Code Security)
            垃圾收集机制(Garbage collection)

        Java虚拟机（Java Virtual Machine）
            在一台计算机上由软件或硬件模拟的计算机。
            Java虚拟机(JVM)读取并处理经编译过的字节码class文件 。
                java虚拟机规范定义了：
                    指令集
                    寄存器集
                    类文件结构
                    堆栈
                    垃圾收集堆
                    内存区域

        JRE (The Java Runtime Environment)
        JRE = JVM（Java Virtual Machine）+ API（Lib )
        JRE运行程序时的三项主要功能：
            加载代码：由class loader 完成；
            校验代码：由bytecode verifier 完成；
            执行代码：由 runtime interpreter完成。
        理解
            为何Java是跨平台的
            为何Java是安全的

        JDK=JRE+Tools
            JDK提供的工具
                java编译器 javac.exe
                java执行器 java.exe
                文档生成器 javadoc.exe
                java打包器 jar.exe
                java调试器 jdb.exe
        JRE=JVM+API



        Java自动垃圾回收技术
            垃圾回收(garbage collection)
            在C/C++ 等语言中，由程序员负责回收无用内存
            Java语言自动垃圾回收
                系统级线程跟踪存储空间的分配情况
                在JVM的空闲时，检查并释放那些可被释放的存储器空间
                程序员无须也无法精确控制和干预该回收过程


        虚拟机和编译器是由C和C++两种语言合作实现的
        核心类库，是JAVA自己实现。io操作上，涉及到操作系统上的文件调用，包括log file socket底层上是
            调用虚拟机的接口，也就是C++语言作为虚拟机封装的操作系统提供的C接口
        网络，文件io，socket，一般是操作系统用C封装，一般连C++要调用都要include这些C的头文件，
            然后用相应的结构体，函数来进行相关操作
     */

}
