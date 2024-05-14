package b10main;

/**
 * @Description:
 * main()方法的使用说明：
 * 1、main()方法作为程序的入口
 * 2、main()方法也是一个普通的静态方法
 * 3、main()方法可以作为我们与控制台的交互方式
 *     javac AMain.java
 *     java Amain "1" "2" "3"
 * @Author Eva
 * @Date 2024/5/14 18:19
 */

public class AMain {
    public static void main(String[] args) { // 入口
        Main.main(new String[10]);
    }
}

class Main{
    public static void main(String[] args) {
        for (int i = 0;i<args.length;i++){
            args[i] = "arg_"+i;
            System.out.println(args[i]);
        }
    }
}
