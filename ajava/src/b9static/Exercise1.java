package b9static;

/**
 * @Description:
 * 编写一个类实现银行账户的概念，包含的属性有“账户、密码、存款余额、最小余额”
 * 定义封装这些属性和方法.账号要自动生成
 *     编写主类，使用银行账户类，输入、输出3个储户的账户信息
 *     考虑：哪些属性可以设计成static类
 * @Author Eva
 * @Date 2024/4/20 20:47
 */

public class Exercise1 {

}


class Account{
    private int id;
    private String pwd = "000000";
    private double balance;

    private static double interestRate;
    private static double minMoney = 1.0;
    private static int init = 1001;

    public Account(){
        id = init++;     // 账号自动生成，注意这一点；每次声明自动+1
    }
    public Account(String pwd,double balance){
        this();
        this.balance = balance;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getBalance() {
        return balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public static double getMinMoney() {
        return minMoney;
    }
}
