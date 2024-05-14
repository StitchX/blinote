package b7object;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/2/20 14:30 2024/4/11 19:30
 */

public class BEquals {
/*
一、回顾 == 的使用
1、可以使用在基本数据类型变量和引用数据类型变量中
2、如果比较的是基本数据类型变量：比较两个变量报错的数据是否相等。（不一定类型要相同）
   如果比较的是引用数据类型变量：比较两个对象的地址值是否相同。即两个引用是否指向同一个对象实体
补充：== 符号使用时，必须保证符号左右两边的变量类型一致。
二、equals方法的使用
1、是一个方法，而非运算符
2、只能适用于引用数据类型
3、Object类中equal()的定义
    public boolean equals(Object obj) {
        return (this == obj);
    }
    说明：Object类中定义的equals() 和 == 的作用是相同的：比较两个对象的地址值是否相同。
4、像String、Date、File、包装类等都重写了Object类中的equals()方法。重写之后，比较的
    不是两个引用的地址是否相同。而是比较两个对象的”实体内容“是否相同
5、通常情况下，我们定义的类如果使用equals()的话，也通常是比较两个对象的”实体内容“是否相同。那么，我们
    就需要对Object类中的equal()进行重写。
    重写的原则：比较两个对象的实体内容是否相同。
 */

        public static void main(String[] args) {
            boolean isTrue = true;
            int a10 = 10;
            double b10 = 10.0;
            char c10 = 10;
//        System.out.println(isTrue == a10); //
            System.out.println(a10 == b10); // 自动类型提升，适用于任何运算符
            System.out.println(c10 == a10); // true

            System.out.println("*******************************************");
            YAnimal an = new YAnimal();
            YAnimal an2 = new YAnimal();
            System.out.println(an.equals(an2));

            String str1 = "10";
            String str2 = "10";
            System.out.println(str2.equals(str1));
        }

        //    手动实现equals方法，也可以快捷键自动生成
        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            if (obj instanceof YAnimal){
//            比较其中的属性是否相同
//            if ()
                YAnimal an = (YAnimal) obj;
//            if (this.age == obj.age && this.name.equals(obj.name))
                return true;
            }else {
                return false;
            }
        }
}
