package b2method;

/**
 * @Description: 可变参数的形参
 * @Author Eva
 * @Date 2024/3/17 18:01
 */

public class DParameter {

    /*
    可变个数形参的方法

    1. jdk 5.0新增的内容
    2. 具体使用
        2.1 可变个数形参的格式：数据类型... 变量名
        2.2 当调用可变个数形参的方法时，传入的参数个数可以是：0、1、2 ...
        2.3 可变个数形参的方法与本类中方法名相同，形参不同的方法之间构成重载
        2.4 可变个数形参的方法与本类中方法名相同，形参也相同的数组之间不构成重载。换句话说，二者不能同时存在
        2.5 可变个数形参在方法的形参中，必须声明在末尾
        2.6 可变个数形参在方法的形参中，最多只能声明一个可变形参
     */

    public void show(String... strs){}
//    public void show(String[] strs){}

//    注意重载
    public void show(String a){}
    public void show(){}
}

    /*
    可变参数的形参:Java 5 新特性
    使用：sql多条件查询
     */

