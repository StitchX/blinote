package project03.service;

/**
 * @Description:
 * 第四步：创建枚举类，programmer类需要改枚举类说明程序员状态
 * @Author Eva
 * @Date 2024/6/12 16:40
 */
public class Status {
    private final String NAME;
    private Status(String name){
        this.NAME = name;
    }

    public String getNAME() {
        return NAME;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    @Override
    public String toString() {
        return NAME ;
    }
}
