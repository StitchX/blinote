package b13Abstract;

/**
 * @Description: 抽象类的应用：模板方法的设计模式
 * @Author Eva
 * @Date 2024/5/14 19:13
 */

public class CTemplate {
    public static void main(String[] args) {
        Template t1 = new Sub();
        t1.spendTime();
    }
}


abstract class Template{

    public long spendTime(){
        long start = System.currentTimeMillis();
        code(); // 不确定部分
        long end = System.currentTimeMillis();
        return end-start;
    }


    public abstract void code();
}

class Sub extends Template{

    @Override
    public void code() {

    }
}
