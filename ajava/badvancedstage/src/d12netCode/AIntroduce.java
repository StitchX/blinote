package d12netCode;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/7/6 16:12 -> 2024/6/4 17:40
 */
public class AIntroduce {
    /*
     *  1. 网络编程的概述
     *  2. 网络通信要素概述
     *  3. 通信要素1：IP和端口号
     *  4. 通信要素2：网络协议
     *  5. TCP网络编程
     *  6. UDP网络编程
     *  7. URL编程
     *
     */

    /*
    一、网络编程中有两个主要的问题:
    1.如何准确地定位网络上一台或多台主机:定位主机上的特定的应用
    2.我到主机后如何可靠高教地进行数据传输

    二、网络编程中的两个要素
    1.对应向器一:IP和端口号
    2.对应问题二: 提供网络通信协议: TCP/IP参考模型(应用层、传输层、网络层、物理层+数据链路层）

    三、通信要素一: IP和端口号
    1. IP:唾一的标识 Internet 上的计算机 (通信实体)
    2. 在Java中使InetAddress类代表IP
    3. IP分类 : IPV4 和 IPV6 ; 万维网和局城网
    4. 域名 www.baidu.com
    5. 本地回路地址：127.0.0.1 对应着：localhost
    6. 如何实例化InetAddress:
        两个方法: getByName(String host)、 getLocalHost()
        两个常用方法: getHostName() / getHostAddress()

    7. 端口号: 正在计算机上运行的进程。
        要求：不同的进程有不同的端口号
        范围：被规定为一个 16 位的整数 0~65535
    8. 端口号与IP地址的组合得出一个网络套接字: Socket

     */
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.0.7");
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            InetAddress inet3 = InetAddress.getByName("localhost");
            InetAddress inet4 = InetAddress.getLocalHost();

            System.out.println(inet1);
            System.out.println(inet2);
            System.out.println(inet3);
            System.out.println(inet4);

            System.out.println(inet3.getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    端口号: 标识正在计算机上运行的进程(程序)
        > 不同的进程有不同的端口号
        > 被规定为一个 16 位的整数 0~65535
        > 端口分类:
            > 公认端口:0~1023。被预先定义的服务通信占用 (如:HTTP占用端口80，FTP占用端口21，Telnet占用端口23，https 443)
            > 注册端口:1024~49151。分配给用户进程或应用程序。 (如: Tomcat占端口8080，MySQL占用端口3306用 Oracle占用端口1521等)
            > 动态/私有端口:49152~6553端口号与IP地址的组合得出一个网络

     端口号与IP地址的组合得出一个网络套接字: Socket
     */
}
