package d9collection;

import java.util.Objects;

/**
 * @Description:
 * @Author Eva
 * @Date 2024/6/4 10:54
 */
public class YDemo02 implements Comparable {

    public YDemo02(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private  String name;
    private int age;

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
        return "YDemo02{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("user equals() ... ");
        if (this == o) return true;
        if (!(o instanceof YDemo02 yDemo02)) return false;

        if (age != yDemo02.age) return false;
        return Objects.equals(name, yDemo02.name);
    }

    @Override
    public int hashCode() { // set去重
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }


    //    按照姓名从小到大排列，再按照年龄从小到大排列
    @Override
    public int compareTo(Object o) {
        if (o instanceof YDemo02) {
            YDemo02 y2 = (YDemo02) o;
            int compare = this.name.compareTo(y2.name);

            if (compare !=0){
                return compare;
            }else {
                return Integer.compare(this.age, y2.age);
            }
//            return -this.name.compareTo(y2.name);   // 从大到小
        } else {
            throw new RuntimeException("输入类型不匹配");
        }
    }
}
