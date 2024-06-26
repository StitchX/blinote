package d12netCode;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * 实现TCP的网络编程
 *     例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 *     ps: 不太想学，看不明白，后期疲惫，这两天能看懂Java的面试题了，需要总结背诵一下
 * @Author Eva
 * @Date 2023/7/6 17:13 -> 2024/6/4 17:44
 */
public class BTCP {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
//            1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);
//            2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
//            3.写出效据的操作
            os.write("nihao".getBytes());
            socket.shutdownOutput(); // 明确告诉服务器传输完成了

        }catch (IOException e){
            e.printStackTrace();
        }finally {
//            4.资源的关闭
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    //    服务端
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
//            1.创建服务器装的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8899);
//            2.调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
//
            is = socket.getInputStream();

//            不建议这样写，可能会有乱码
//            byte[] buffer = new byte[1024];
//            int len;
//            while ((len = is.read(buffer))!=-1){
//                String str = new String(buffer,0,len);
//                System.out.println(str);
//            }

//            4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer))!=-1){
                baos.write(buffer,0,len);
                System.out.println(baos);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
