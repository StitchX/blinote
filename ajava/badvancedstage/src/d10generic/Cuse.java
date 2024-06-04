package d10generic;

import org.junit.Test;

/**
 * @Description: 如何自定义泛型结构：泛型类、泛型接口；泛型方法。
 * @Author Eva
 * @Date 2023/6/25 16:06 -> 2024/6/4 15:12
 */
public class Cuse {

    @Test
    public void test01(){
//        如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
//        要求：如果大家定义了类时泛型的，建议在实例化时要指明类的泛型

        BSelf b1 = new BSelf<>();
        b1.setOrderT(123);
        b1.setOrderT("qqq");

//        建议：实例化时指明类的泛型
        BSelf<String> b2 = new BSelf<String >("orderAA",1001,"QQ");
        b2.setOrderT("AA: hello");
    }

    @Test
    public void test02(){
        YDemo01 y1 = new YDemo01();
//        由于子类在继承带泛型的父亲时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        y1.setOrderT(11);

        YDemo02<String> y2 = new YDemo02<String>();

        y2.setOrderT("ii");
    }
}
