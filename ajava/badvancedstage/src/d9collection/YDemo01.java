package d9collection;

import java.util.Objects;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/2/15 16:56 -> 2024/6/4 9:57
 */
public class YDemo01 {
    private int age;
    private String name;

    public YDemo01() {
    }

    public YDemo01(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "YDemo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YDemo01 yDemo01)) return false;
        return age == yDemo01.age && Objects.equals(name, yDemo01.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
