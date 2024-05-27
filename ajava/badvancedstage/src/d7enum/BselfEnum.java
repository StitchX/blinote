package d7enum;

/**
 * @Description: 自定义枚举类
 * @Author Eva
 * @Date 2023/2/14 10:32 -> 2024/5/27 16:20
 */
public class BselfEnum {
    //    1、声明BselfEnum对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //    2、私有化的构造器，并给对象属性赋值
    private BselfEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //    3、提供当前枚举类的多个对象：public static final 的
    public static final BselfEnum SPRING = new BselfEnum("春天","困");
    public static final BselfEnum SUMMER = new BselfEnum("夏天","乏");
    public static final BselfEnum AUTUMN = new BselfEnum("秋天","打盹");
    public static final BselfEnum WINTER = new BselfEnum("冬天","眠");

    //    4、其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //    其他诉求2：提供toString()
    @Override
    public String toString() {
        return "BselfEnum{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
