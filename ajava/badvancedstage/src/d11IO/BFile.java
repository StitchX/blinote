package d11IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Description:
 *    File类的使用
 *     1.File类的一个对象，代表一个文件或一个文件目录(称:文件夹)
 *     2.File类声明在java.io包下
 *     3.FiLe类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
 *     并未涉及到写入或读取文件内容的提作。如果需要读取或写入文件内容，必须使用IO流来完成。
 *     4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的”终点
 * @Author Eva
 * @Date 2023/6/26 16:30 -> 2024/6/4 15:45
 */
public class BFile {
    /*
    1. 如何创建File类的实例
        File(String filePath)
        File(String parentFile,String childpath)
        File(File parentFile,String childpath)

    2.
       相对路径 : 相较于某个路径下，指明的路径。
       绝对路径 : 包含盘符在内的文件或文件目录的路径

    3.路径分隔符
        windows：\\
        unix： /
     */

    @Test
    public void test01(){
//        构造器一：
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\downloads\\hello.txt");

        System.out.println(file1);
        System.out.println(file2);

//        构造器二：
        File file3 = new File("D:\\downloads","hello");

//        构造器三：
        File file4 = new File(file3,"hello.txt");

    }

    /*
    public string getAbsolutePath():获取绝路径
    public String getPath() : 获取路径
    public String getName() : 获取名称
    public string getParent(): 获取上层文件目录器径，若无，返回null
    public Long length() : 获取文件长度(即:字节数)。不能获取目录的长度
    public Long lastModified() :获取最后一次的修改时间，毫秒值

    如下的两个方法适用于文件目录：
    public String[] list() :获指定目录下的所有文件或文件目录的名称数组
    public File[] listFiles() :获指定目录下的所有文件或者文件目录的File数组
     */

    @Test
    public void test02(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\downloads\\hello.txt");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
//        System.out.println(file1.lastModified());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
//        System.out.println(file1.lastModified());
        System.out.println(new Date(file2.lastModified()));
    }

    @Test
    public void test03(){
        File file = new File("D:\\downloads");
        String[] list = file.list();

        for (String s :
                list) {
            System.out.println(s);
        }

        System.out.println();

        File[] files = file.listFiles();
        for (File f :
                files) {
            System.out.println(f);
        }
    }

    /*
    public boolean renameTo(File dest) : 把文件名重命名为指定的文件路径
        比如：file1.remame(file2) 为例：
            要想保证返回true，需要file1在硬盘中是存在的，且file2不能在硬盘中存在
     */
    @Test
    public void test04(){
        File file1 = new File("hello.txt");
        File file2 = new File("C:\\Users\\QMacroQA\\Desktop\\code\\java\\note\\badvancedstage\\demo.txt");
        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);
    }


    /*
    public boolean isDirectory():判断是否是文件目录
    public boolean isFile() : 判断是否是文件
    public boolean exists() :判断是否存在
    public boolean canRead() : 判断是否可读
    public boolean canwrite():判断是否可写
    public boolean isHidden()判断是否隐藏
     */
    @Test
    public void test05(){
        File file1 = new File(".\\hello.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        File file2 = new File("D:\\Downloads");

        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    /*
    创建硬盘中对应的文件或文件目录
    public boolean createNewFile() :创建文件。文件存在，则不创建，返回false
    public boolean mkdir(): 创建文件目。如果此文件目录存在，就不创建了。如果此文件目录的上层不存在，就不创建了
    public boolean mkdirs() : 创建文件目。如果上层文件目不存在，一#创建

    删除磁盘中的文件或文件目录
        public boolean delete():别除文件或者文件夹删除注意事项.
        Java 中的别除不走回收站
     */
    @Test
    public void test06() throws IOException {
        File file1 = new File("hello.txt");

        if (!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else {
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test07(){
//        文件目录的创建
        File file1 = new File("d:\\io\\io");

        boolean mkdir = file1.mkdir();
        if (mkdir){
            System.out.println("创建成功");
        }

        File file2 = new File("d:\\io\\io1");

        boolean mkdir1 = file2.mkdirs();
        if (mkdir1){
            System.out.println("创建成功");
        }
    }
}
