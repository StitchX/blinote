package c1exception;

/**
 * @Description:
 * 练习题一：判断输出顺序
 * @Author Eva
 * @Date 2024/5/19 22:06
 */

public class ZExercise01 {
    public static void demo01(){
        try {
            System.out.println("举例一");
            throw new RuntimeException("抛出异常");
        }finally {
            System.out.println("猜猜什么时候输出？");
        }
    }

    public static void demo02(){
        try {
            System.out.println("举例二");
            return;
        }finally {
            System.out.println("猜猜会不会输出？");
        }
    }

    public static void main(String[] args) {
        try {
            demo01();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        demo02();
    }

}
