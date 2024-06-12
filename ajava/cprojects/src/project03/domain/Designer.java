package project03.domain;

/**
 * @Description:
 * 第六步：设计师类，增加奖金
 * @Author Eva
 * @Date 2024/6/12 16:44
 */
public class Designer extends Programmer {
    private double bonus;

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer() {
        super();
    }

    @Override
    public String toString() {
        return getDetail()+"\t\t"+"设计师 " +
                "\t"+getStatus()+
                "\t" + bonus + "\t\t\t\t" +getEquipment().getDescription();
    }

    public String getDetailsForTeam(){
        return getMemberId() +"/"+getId()+" \t"+getName()+" \t"+getAge()+"\t\t"+getSalary()+" \t"+"设计师 "+
                "\t" + bonus + "\t\t\t\t" ;
    }
}
