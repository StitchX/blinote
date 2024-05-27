package d7enum;

/**
 * @Description: 使用enum关键字定义
 *  说明：定义的枚举类默认继承于java.lang.Enum
 * @Author Eva
 * @Date 2023/2/14 10:32 -> 2024/5/27 16:20
 */
enum CEnum {

    //    1. 提供当前枚举类的对象，多个对象之间用 ，隔开，末尾用；结束
    SPRING("春天","困"),
    SUMMER("夏天","乏"),
    AUTUMN("秋天","打盹"),
    WINTER("冬天","眠");

    //    2.声明CEnum对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //    3. 私有化的构造器，并给对象属性赋值
    CEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //
    //    4、其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //    其他诉求2：提供toString()
//    @Override
//    public String toString() {
//        return "BselfEnum{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
