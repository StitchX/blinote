package project03.service;

/**
 * @Description: 第八步：自定义异常类
 * @Author Eva
 * @Date 2024/6/12 16:55
 */
public class TeamException extends Exception {
    @java.io.Serial
    static final long serialVersionUID = -2327516993124229948L;

    public TeamException(){

    }
    public TeamException(String msg){
        super(msg);
    }
}
