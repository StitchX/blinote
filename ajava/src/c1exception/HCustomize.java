package c1exception;

/**
 * @Description:
 * 如何自定义异常类：
 *     1、继承于现有的异常结构：Exception、RuntimeException
 *     2、提供全局常量：serialVersionUID（类的标识，IO流详解，没听明白）
 *     3、提供重载的构造器
 * @Author Eva
 * @Date 2024/5/17
 */
public class HCustomize extends RuntimeException{
    @java.io.Serial
    static final long serialVersionUID = -1111111111111111117L;

    public HCustomize(){

    }
    public HCustomize(String msg){
        super(msg);
    }
}

//public class HCustomize extends Exception{
//
//}
