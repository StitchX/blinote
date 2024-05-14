package b4constructor;

/**
 * @Description: JavaBean
 * @Author Eva
 * @Date 2023/2/17 15:02 2024/4/9 19:16
 */

public class CJavaBean {
    /*
    JavaBean是一种Java语言写成的可重用组件

    所谓JavaBean，是指符合如下标准的Java类：
        > 类是公共的
        > 有一个无参的公共的构造器
        > 有属性，且有对应的get, set方法


     */

    private int a;
    private double b;
    private String c;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public CJavaBean(int a, double b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public CJavaBean() {
    }
}
