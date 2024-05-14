package b6polymorphism;

/**
 * @Description: 用于APolymorphism的举例和使用
 * @Author Eva
 * @Date 2023/2/20 11:44 2024/4/11 19:07
 */

public class YDemo02 extends YDemo01{
    int id = 11;
    String name = "jerry";
    @Override
    public void demo02() {
        System.out.println("覆盖");
    }

    public void smoken(){
        System.out.println("特有的");
    }
}
