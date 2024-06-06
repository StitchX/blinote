package d14java8;

/**
 * @Description:
 * 只包含一个抽象方法的接口，称为函数式接口
 *
 * java内置的4大核心函数式接口
 *  消费型接口 Consumer<T>      void accept(T t)
 *  供给型接口 Supplier<T>      T get()
 *  函数型接口 Function<T,R>    R apply(T t)
 *  断定型接口 Predicate<T>     boolean test(T t)
 * @Author Eva
 * @Date 2023/8/14 10:55 -> 2024/6/6 15:58
 */
public interface CDemo {
    void method1();
//    void method2();
}
