package d13reflection;

/**
 * @Description:
 * 静态代理举例
 *     特点：代理类和被代理类在编译期间，就确定下来了。
 * @Author Eva
 * @Date 2023/7/20 11:08 -> 2024/6/5 17:03
 */
public class HStaticProxy {
    public static void main(String[] args) {
//        创建被代理类的对象
        ClothFactory nick = new NikeCothFactory();
//        创建代理类的对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nick);
        proxyClothFactory.produceCloth();
    }
}
interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory; // 用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理厂做一些后续的收尾工作");
    }
}

class NikeCothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nick工厂生产一批运动服");
    }
}
