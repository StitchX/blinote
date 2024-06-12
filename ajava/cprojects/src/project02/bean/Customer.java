package project02.bean;

/**
 * @Description:
 * 1、
 * model 层，主要用来处理数据
 * Customer类，用来封装实体信息（数据对象封装）
 * @Author Eva
 * @Date 2024/6/12 9:48
 */
public class Customer {
    /*
    第一步：Customer 为实体类，用来封装客户信息
    该类封装客户的以下信息：
        String name; 客户姓名
        char gender; 性别
        int age; 年龄
        String phone; 电话号码
        String email; 电子邮箱

    提供各属性的get/set方法
    提供所需的构造器
     */
    private String name; // 客户姓名
    private char gender; //  性别
    private int age;  //  年龄
    private String phone;       // 电话号码
    private String email;  // 电子邮箱

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    Customer(){

    }
    public Customer(String name, char gender, int age, String phone, String email){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }
}
