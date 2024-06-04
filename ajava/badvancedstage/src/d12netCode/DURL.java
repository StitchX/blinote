package d12netCode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description:
 * URL网络编程
 *  * 1.URL: 统一楚源定位符，对应者互联网的某一楚源地址
 *  * 2.格式:
 *  *  http://Localhost:8080/examples/beauty.jpg?username=Tom
 *  * 协议主机名         端口号    资源地址               参教列表
 * @Author Eva
 * @Date 2023/7/7 10:40 -> 2024/6/4 21:06
 */

public class DURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("");

//            System.out.println(url.getProtocol());
//            System.out.println(url.getHost());
//            System.out.println(url.getPort());
//            System.out.println(url.getPath());
//            System.out.println(url.getFile());
//            System.out.println(url.getQuery());

//            从服务器端下载数据，这里只有部分代码
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            InputStream is = httpURLConnection.getInputStream();
            FileOutputStream fos = new FileOutputStream("");

        }catch (MalformedURLException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
