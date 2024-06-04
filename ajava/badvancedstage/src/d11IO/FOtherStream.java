package d11IO;

import org.junit.Test;

import java.io.*;

/**
 * @Description:
 * 其他流的使用
 *  1.标准的输入、输出流
 *  2.打印流
 *  3.数据流
 * @Author Eva
 * @Date 2023/7/5 14:17 -> 2024/6/4 16:41
 */
public class FOtherStream {
    /*
    1.标准的输入、输出流
    1.1
    System.in:标准的输入流，默认从键盘输入
    System.out: 标准的输出流，默认从控制台输出
    1.2
    System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出

    1.3练习:
    从键盘输入字符串，要求将读取到的整行非符串转成大写输出。然后继续进行输入操作,
    直至当输入”e”或者”exit”时，退出程序。

    方法一: 使用Scanner实现，调用next()返回一个字符串
    方法二: 使用System.in实现。System.in --->BufferedReader的readLine()

     */

//    public static void main(String[] args) {
//        BufferedReader br = null;
//        try {
//            InputStreamReader isr = new InputStreamReader(System.in);
//            br = new BufferedReader(isr);
//
//            while (true){
//                System.out.println("请输入字符串：");
//                String data = br.readLine();
//                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
//                    System.out.println("程序结束");
//                    break;
//                }
//
//                String upperCase = data.toUpperCase();
//                System.out.println(upperCase);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            if (br!=null){
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }

    /*
    2.打印流: PrintStream和PrintWriter

    2.1 提供了一系列重裁的print() 和 println()
    2.2 练习:

     */
    @Test
    public void test01(){

    }

    /*
    3.数据流
    3.1 DataInputStream  DataOutputStream
    3.2 作用:用于读取或写出基本数据类型的变量或字符串

    练习: 将内存中的字符串、基本数据类型的变量写出到文件中。

    注意: 处理异常的话，仍然应该使用try-catch-finally.
     */
    @Test
    public void test02() throws IOException {
//        1.
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

//        2.
        dos.writeUTF("来啦");
        dos.flush();
        dos.writeInt(2);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();  //刷新操作，海内存中的数与入文件

//        3.
        dos.close();
    }

    /*
    将文件中存储的基本数据类型变量和宇符串读取到内存中，保存在变量中。

    注意点:读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致!
     */
    @Test
    public void test03() throws IOException {
        //1.
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        //2.
        String name = dis.readUTF();   // 顺序不一致导致报错
        boolean isMale = dis.readBoolean();
        int age = dis.readInt();
        System.out.println("name = " + name);
        System.out.println("age = " + age);  // 257 倒过来读取，关于存储和读取的顺序
        System.out.println("isMale = " + isMale);

//        dis.readInt();
//3.
        dis.close();
    }
}
