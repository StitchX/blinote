package d14java8;


/**
 * @Description: 第二步
 * @Author Eva
 * @Date 2024/6/4 14:35
 */
public class YEmployee implements Comparable {


    private String name;
    private int age;

    public YEmployee() {
    }

    public YEmployee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public YEmployee(Integer integer) {
    }

    public YEmployee(Integer integer, String s) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof YEmployee){
            YEmployee e = (YEmployee) o;
            return this.name.compareTo(e.name);
        }
        return 0;
    }

}
