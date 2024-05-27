package d9collection;

/**
 * @Description:
 *      1、Java集合框架概述
 *      2、collection接口方法
 *      3、iterator迭代器接口
 *      4、collection子接口一：List
 *      5、collection子接口二：Set
 *      6、Map接口
 *      7、Collections工具类
 * @Author Eva
 * @Date 2023/2/15 14:02 -> 2024/5/27 17:29
 */
public class AIntroduce {
    /*
    一、集合框架的概述
    1.集合、数组都是对于多个数据进行存储操作的结构，检查Java容器
    说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt .jpg .avi 数据库中）

    2.1 数组在存储多个数据方面的特点：
        > 一旦初始化以后，其长度就确定了
        > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
            比如：String[] arr; int[] arr1;Object[] arr2
    2.2 数据在存储多个数据方法的缺点
        > 一旦初始化以后，其长度就不可更改
        > 数组中提供的方法非常有限，对于添加（长度不可变）、删除（后面覆盖前面）、插入数据等操作，非常不便，同时效率不高
        > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
        > 数组存储数据的特点：有序、可重。对于无序、不可重复的需求，不能满足

    二、集合概述
        |-----Collection接口：单列集合，用来存储一个一个对象
            |----list接口：存储有序的，可重复的数据。 --->"动态"数组
                |--ArrayList、LinkedList、Vector
            |----Set接口：存储无序的、不可重复的数据。---->高中讲的“集合”
                |--HashSet、LinkedHashSet、TreeSet

        |----Map接口：双列集合，用来存储一对（key-value）一对的数据 -->高中函数：y=f(x)
            |--HashMap、LinkedHashMap、TreeMap、Hashtable、Properties

    三、Collection接口中的方法的使用

     */
}
