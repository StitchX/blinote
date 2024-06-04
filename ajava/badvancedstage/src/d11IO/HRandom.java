package d11IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description:
 *  RandomAccessFile的使用
 *  1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 *  2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 *  3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建
 *  如果写出到的文件存在，则会对原有文件内容进行覆盏。（默认情况下，从头覆盖)
 *  4.可以通过相关的操作，实现RandomAccessFile”插入教据的效果
 * @Author Eva
 * @Date 2023/7/6 11:14 -> 2024/6/4 17:13
 */
public class HRandom {

    @Test
    public void test01(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;

        try {
            raf1 = new RandomAccessFile((new File("14.jpeg")),"r");
            raf2 = new RandomAccessFile((new File("15.jpeg")),"r");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer))!=-1){
                raf2.write(buffer,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            if (raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }


    @Test
    public void test02() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello1.txt","rw");

        raf1.seek(3); //将指针调到角标为3的位置
        raf1.write("xyz".getBytes());
        raf1.close();

    }

    /*
    使用RandomAccessFile 实现插入的效果
     */

    @Test
    public void test03() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello1.txt","rw");

        raf1.seek(3); //将指针调到角标为3的位置

        //保存指3后面的所有效据到StringBuilder 中
        StringBuilder builder = new StringBuilder((int) new  File("hello1.txt").length());

        byte[] buffer = new byte[20];

        int len;
        while ((len = raf1.read(buffer))!=-1){
            builder.append(new String(buffer,0,len));
        }
//        调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("xxx".getBytes());

        //stringBuilder中的效接写入到文件中
        raf1.write(builder.toString().getBytes());
        raf1.close();

        //思考: stringBuilder警换为ByteArrayOutputstream
    }
}
