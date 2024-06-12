package project03.domain;

/**
 * @Description:
 * 第七步：架构师，增加股权属性
 * @Author Eva
 * @Date 2024/6/12 16:45
 */
public class Architect extends Designer {
    private int stock;

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public Architect() {
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return getDetail()+"\t\t"+"架构师 " +
                "\t"+getStatus()+
                "\t" + getBonus() +
                "\t\t" +stock+ "\t" +getEquipment().getDescription();
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getDetailsForTeam(){
        return getMemberId() +"/"+getId()+" \t"+getName()+"\t"+getAge()+"\t\t"+getSalary()+" \t"+"架构师 " +
                "\t" + getBonus() +
                "\t\t" +stock;
    }
}
