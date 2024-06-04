package d11IO;

import org.junit.Test;

import java.io.*;

/**
 * @Description:
 * 对象流的使用
 *  1. ObjectInputStream和ObjectOutputSteam
 *  2. 用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *  3. 要想一个java对象是可序列化的，需要满足相应的要求。见YDemo01.java
 * @Author Eva
 * @Date 2023/7/5 15:37 -> 2024/6/4 17:11
 */
public class GObject {
    /*
    序列化过程:将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */

    @Test
    public void test01(){
        ObjectOutputStream oos= null;
        try {
//            1.
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
//            2.
            oos.writeObject(new String("温度计恢复肌肤经济法"));
            oos.flush();

            oos.writeObject(new YDemo01("是否",12));

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (oos != null){
//                3.
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /*
    反序列化:将磁盘文件中的对象还原为内存中的一个对象
    使ObjectInputStream来实现
     */
    @Test
    public void test02(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();
            String str = (String) obj;
            YDemo01 y1 = (YDemo01) ois.readObject();
            System.out.println(str);
            System.out.println(y1);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            if (ois != null){
//                3.
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
