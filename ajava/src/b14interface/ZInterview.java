package b14interface;

/**
 * @Description:面试题：是否有错？
 * @Author Eva
 * @Date 2024/5/15
 */
public class ZInterview extends B implements A{
    public static void main(String[] args) {
//        new ZInterview().px();
        Ball b = Ball.ball;
        b.play();
    }
    public void px(){
//        面试题一：排错
//        System.out.println(aa);  编译不通过
        System.out.println(super.aa);  // 1
        System.out.println(A.aa);  // 0  全局静态变量
    }
}

interface A{
    int aa = 0;
}
class B{
    int aa = 1;
}

//==============面试题二===================

interface Playable{
    void play();
}
interface Bounceable{
    void play();
}
interface Rollable extends Playable,Bounceable{
    Ball ball = new Ball("pp");
}
class Ball implements Rollable{
    private String name;
    public String getName(){
        return name;
    }

    public Ball(String name){
        this.name = name;
    }

    public void play(){ // 错误一：不知道是哪一个play；不会报错，可以运行
//        ball = new Ball("fb");  // 错误二：接口定义的是静态常量，不能再次赋值
        System.out.println(ball.getName());
    }
}
