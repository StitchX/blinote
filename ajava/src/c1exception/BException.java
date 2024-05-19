package c1exception;

import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

/**
 * @Description:
 * 一、异常体系结构
 *     java.lang.Throwable
 *         |------java.lang.Error: 一般不编写针对性的代码进行处理
 *         |------java.lang.Exception：可以进行异常的处理
 *             |------编译时异常（checked）
 *                 |------IOException
 *                     |------FileNotFoundException
 *                 |------ClassNotFoundException
 *             |------运行时异常（unchecked)
 *                 |------NullPointerException
 *                 |------ArrayIndexOutOfBoundsException
 *                 |------ClassCastException
 *                 |------NumberFormatException
 *                 |------InputMismatchException
 *                 |------ArithmeticException
 *
 *     面试题：常见的异常都有哪些？举例说明
 * @Author Eva
 * @Date 2024/5/17
 */
public class BException {
//**********************以下是运行时异常*******************************

    //    NullPointerException
    @Test
    public void demo01(){
        int[] arr = null;
        System.out.println(arr[1]);

    }

    //    StringIndexOutOfBoundsException
    @Test
    public void demo02(){
        String a1 = "qwertuyi";
        System.out.println(a1.charAt(10));
    }

    //    ClassCastException
    @Test
    public void demo03(){
        Object ob1 = new Date();
        String str = (String) ob1;
    }

    //    NumberFormatException
    @Test
    public void demo04(){
        String st1 = "123qwe";
        int in1 =Integer.parseInt(st1);
    }

    //    InputMismatchException
    @Test
    public void demo05(){
        Scanner scn = new Scanner(System.in);
        int a1 = scn.nextInt();
        System.out.println(a1);
        scn.close();
    }

    //    ArithmeticException
    @Test
    public void demo06(){
        int a = 0;
        int b = 1;
        System.out.println(b/a);
    }

    //**********************以下是编译时异常*******************************
    //    ArithmeticException
    @Test
    public void demo07(){
        File file = new File("hello.txt");
//        FileInputStream fis = new FileInputStream(file);
//
//        int data = fis.read();
//        while (data != -1){
//            System.out.println((char)data);
//            data = fis.read();
//        }
//
//        fis.close();
    }
}
