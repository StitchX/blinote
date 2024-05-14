package b4constructor;

/**
 * @author Eva   Email:
 * @Description
 * @data 2023/2/17 14:50
 */
public class YDemo {
    private double b;
    private String n;

    public YDemo(double b, String n,String x){
        this(b,n);
    }

    public YDemo(double b, String n) {
        this.b = b;
        this.n = n;
    }
}
