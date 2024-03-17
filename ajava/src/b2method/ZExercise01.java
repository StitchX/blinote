package b2method;

import java.io.PrintStream;

/**
 * @Description: 考题：怎么让程序输出a=100 b=100；看似考值传递，实际不是
 * @Author Eva
 * @Date 2023/2/16 16:42 2024/3/17 18:08
 */

public class ZExercise01 {
    public static void main(String[] args) {
        int a=10;
        int b=10;
//        让 a = 100; b=100
        method2(a,b);
        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }

    //    方法一：
    public static void method1(int a,int b){
        a = a*10;
        b = b*10;
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        System.exit(0); // 强制停止执行
    }

    //    方法二：
    public static void method2(int a,int b){
//        略；没看明白
        PrintStream ps = new PrintStream(System.out){
            @Override
            public void println(String x){
                if ("a=10".equals(x)){
                    x = "a=100";
                } else if ("b=10".equals(x)) {
                    x = "b=200";
                }
                super.println(x);
            }
        };
        System.setOut(ps);
    }
}
