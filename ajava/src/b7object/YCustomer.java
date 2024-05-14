package b7object;

/**
 * @Description:
 * @Author Eva
 * @Date 2024/4/11 19:34
 */

public class YCustomer {
    public YCustomer(){

    }
    private String Name;
    private int age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //    自动生成一个toString()方法
    @Override
    public String toString() {
        return "Customer{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                '}';
    }
}
