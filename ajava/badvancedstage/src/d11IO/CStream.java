package d11IO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description:
 *  一、流的分类:
 * 1.操作数据单位:字节流、字符流
 * 2.效据的流向:输入流、输出流
 * 3.流的角色:节点流、处理流
 *  二、流的体系结构
 *  抽象基类                   节点流(或文件流)                                         缓冲流(处理流的一种)
 *  InputStream              FileInputStream  （read(byte[] buffer)）                BufferedInputStream（read(byte[] buffer)）
 *  OutputStreamReader       FileOutputstream  (write(byte[] buffer,0,len))         BufferedOutputstream(write(byte[] buffer,0,len)) / flush()
 *  Reader                    FileReader       （read(char[] cbuf)）                 BufferedReader（read(char[] cbuf) / readline()）
 *  Writer                    Filewriter        (write(char[] cbuf,0,len))          Bufferedwriten(write(char[] cbuf,0,len)) / flush()
 * @Author Eva
 * @Date 2023/6/27 15:54 -> 2024/6/4 16:18
 */
public class CStream {
    @Test
    public void testFileReader()  {
        FileReader fr =null;
        try {
//        1. 实例化FiLe类的对象，指明要操作的文件
            File file  = new File("hello.txt"); // 相较于当前module

//        2. 提供具体的流
            fr = new FileReader(file);

//        3. 数据的读入
//        read()：返回读入的一个字符。如果达到文件末尾，返回-1
//        int data = fr.read();
//        while (data != -1){
//            System.out.print((char) data);
//            data = fr.read();
//        }

//        方式二：语法上针对方式一的修改
            int data;
            while ((data=fr.read())!=-1){
                System.out.print((char) data);
            }

        }catch (IOException e){

        }finally {
//        4. 流的关闭操作
//            try {
//                if (fr != null){
//                    fr.close();   // 涉及到垃圾回收机制
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            或
            if (fr != null){
                try {
                    fr.close();   // 涉及到垃圾回收机制
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


//        System.out.println(file.getAbsoluteFile());
    }


    //    对read()操作升级：使用read的重载方法
    @Test
    public void testFileReader1(){
        FileReader fr =null;
        try {

//        1. 实例化FiLe类的对象，指明要操作的文件
            File file  = new File("hello.txt"); // 相较于当前module

//        2. FileReader流的实例化
            fr = new FileReader(file);

//        3. 读入的操作
//            read(char[] cbuf): 返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
//            方式一：错误的写法
            while ((len = fr.read(cbuf))!=-1){
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.println(cbuf[i]);
//
//                }
//                正确的写法
                for (int i = 0; i < len; i++) {
                    System.out.println(cbuf[i]);
                }

//                方式二：
//                错误的写法，对应着方式一的错误的写法
//                String str = new String(cbuf);
//                System.out.println(str);

                String str = new String(cbuf,0,len);
                System.out.println(str);

            }



        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fr != null) {
                    fr.close();   // 涉及到垃圾回收机制
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /*
    从内存中写出效据到硬盘的文件里。
    说明:
    1. 输出操作，对应的File 可以不存在的。并不会报是异常
    2.
        File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
        File对应的硬盘中的文件如果存在:
            如果流使用的构造器是: FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
            如果流使用的构造器是: FileWriter(file,true):不会对原有文件覆盏，而是在原有文件基础上追加内容
     */
    @Test
    public void testFileWriter() throws IOException {
//        下面需要有try catch操作，懒得写了
//        1. 提供File类的对象，指明写出到文件
        File file = new File("hello1.txt");

//        2. 提供FileWriter的对象，用于数据的写出
//        FileWriter fw = new FileWriter(file);
        FileWriter fw = new FileWriter(file,true);

//        3. 写出操作
        fw.write("I have a cat\n");
        fw.write("I have a dog");

//        4. 资源流的关闭
        fw.close();
    }

    /*
    测试FileInputstream和FileOutpuStream的使用
    结论:
        1.对于文本文件(.txt.java,.c,.cpp)，使用字符流处
        2.对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...) 使用字节流处理
     */
    @Test
    public void demo(){
//        略过FileInputStream和 FileOutputStream
//        与上诉的区别就是 使用byte型数组
        byte[] buf = new byte[5];

//      可以把一个文件复制一份，来练习
    }

//    指定路径下的文件复制
}
