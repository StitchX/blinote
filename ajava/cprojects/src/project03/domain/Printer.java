package project03.domain;

/**
 * @Description:
 * 第二步：创建notebook、pc、printer的Bean类
 * @Author Eva
 * @Date 2024/6/12 16:34
 */
public class Printer implements Equipment {
    private String name;  // 机器型号
    private String type;  // 机器类型

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name +"("+ type +")";
    }
}
