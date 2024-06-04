package d11IO;

import org.junit.Test;

import java.io.*;

/**
 * @Description:
 *  处理流之一：缓冲流的使用
 *  1. 缓冲流
 *      BufferedInputStream
 *      BufferedOutputstream
 *      BufferedReader
 *      Bufferedwriten
 *
 *  2. 作用:提供流的读出、写入的速度提高读写速度的原因:内部提供了一个缓冲区
 *  3. 处理流，就是“套接”在已有的流的基础上。
 * @Author Eva
 * @Date 2023/7/4 16:53 -> 2024/6/4 16:29
 */
public class DBuffer {
    /*
    实现非文本文件的复制
     */

    @Test
    public void bufferedInputStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
//            1. 造文件
            File srcFile = new File("14.jpeg");
            File desFile = new File("15.jpeg");

//          2. 造流
//          2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(desFile);

//            2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

//            3. 复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer))!=-1){
                bos.write(buffer,0,len);

                bos.flush(); // 刷新缓冲区
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
//            4. 资源关闭
//            要求：先关闭外层的流，再关闭内层的流

            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

//            说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省
//            fis.close()
        }
    }

    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void bufferedReadertest(){

    }
}
