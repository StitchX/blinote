package project03.domain;

/**
 * @Description:
 * @Author Eva
 * @Date 2024/6/12 16:33
 */
public class NoteBook implements Equipment {
    private String model;  // 机器型号
    private Double price;

    public NoteBook() {
    }

    public NoteBook(String model, Double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model+"("+ price +")";
    }
}
