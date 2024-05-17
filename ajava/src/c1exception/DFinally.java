package c1exception;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description:
 * try-catch-finally中finally的使用：
 *     1. finally是可选的
 *     2. finally中声明的是一定会被执行的代码。即使catch中又出现异常了，try中有return语句，
 *         catch中有return语句等情况。
 *     3. 像数据库连接、输入输出流、网络编程socket等资源，JVM是不能自动的回收的，我们需要自己手动的进行资源
 *         的释放。此时的资源释放，就需要声明在finally中。
 * @Author Eva
 * @Date 2024/5/17
 */
public class DFinally {

    @Test
    public void test01(){
        FileInputStream fis=null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);  // 源码throw了异常，所以需要处理

            int data = fis.read();
            while (data != -1){
                System.out.println((char)data);
                data = fis.read();
            }
        } catch (FileNotFoundException e){

        }catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (fis !=null)
                    fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
