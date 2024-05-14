package b8unittest;

import org.junit.Test;

/**
 * @Description:
 * 参考资料：https://blog.csdn.net/u011138533/article/details/52165577
 *
 * Java中的junit单元测试
 * 步骤：
 *     1、选中当前工程 - 右键 - build path - add libraries - junit 4 - 下一步
 *         1)file -project structure - module - + - jars or directors - idea安装目录 - lib - junit.4
 *         2)创建一个与src同级别的目录
 *         3)右键 - make directory as - test resources root
 *         4)选择测试的类 - 右键（ctrl+shift+T）- go to - test
 *         5)选择要测试的方法
 *     2、创建Java类，进行单元测试
 *         此时的java类要求：1）此类是public的 2）此类提供无参的构造器
 *     3、此类中声明单元测试方法。
 *         此时的的那元测试方法：方法的权限是public，没有返回值，没有参数
 *     4、此单元测试方法上需要声明注释：@Test，并在单元测试类中导入：import org.junit.Test
 *     5、声明好单元测试方法以后，就可以在方法体内测试相关的代码
 *     6、写完代码以后，左键双击单元测试方法名，右键：run as - Junit Test
 *
 *     说明：
 *     1、如果执行结果没有任何异常：绿条
 *     2、如果执行结果出现异常：红条
 * @Author Eva
 * @Date 2024/4/11 19:45
 */

public class AJUnitTest {

    @Test
    public void demo01(){
        int a = 1;
        float b = 1L;
        System.out.println(a==b);
    }
}

