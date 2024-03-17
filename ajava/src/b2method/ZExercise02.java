package b2method;

/**
 * @Description: 考察可变参数的使用；可变参数被继承之后，相同方法被覆盖还是被重载
 * 这个还是没明白
 * @Author Eva
 * @Date 2023/2/20 14:45 2024/3/17 18:12
 */

public class ZExercise02 {
    public static void main(String[] args) {
        Vase vase = new Vase();
        vase.add(1,2,3);

        Vub v = (Vub)vase;   // 类型转换保存
        v.add(1,2,3);
    }
}

class Vase{
    public void add(int a,int... arr){
        System.out.println("Vase");
    }
}

class Vub extends Vase{
    public void add(int a,int[] arr){
        System.out.println("Vub_1");
    }
    public void add(int a,int b,int c){
        System.out.println("Vub_2");
    }
}
