package b3encapsulation;

/**
 * @Description: 权限修饰符
 * @Author Eva
 * @Date 2023/2/16 17:01 2024/3/17 18:53
 */

public class BPermission extends AEncapsulation{
    /*
    三、封装性的体现，需要权限修饰符来配合。
    1. Java规定的4种权限（从小到大排列）：private(堆空间会存在，只是其他不能调用)、缺省、protected、public
    类内部           同一个包          不同包的子类         同一个工程
    private
                    default
                                     protected(继承)
                                                         public
    2. 4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类、接口
    3. 具体的，4种权限都可以用来修饰类的内部结构：属性、方法、构造器、内部类
        修饰类的话，只能使用：缺省、public
     */
//    属性: 分成员属性和局部变量
    protected int a;
    //    方法
    public void a(){
        int b; //
    }

    //    内部类
    private class B{

    }

    //    构造器
    protected BPermission(){

    }

//    接口里面只能是public的

    public void E(){
        System.out.println("不是继承关系");
    }

    @Override
    protected void F() {
        super.F();
        System.out.println("不同的包，可以继承，但是不能直接使用");
    }
}

