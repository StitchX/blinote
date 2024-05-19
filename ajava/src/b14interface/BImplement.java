package b14interface;

/**
 * @Description:
 * 接口的使用：
 * 1、接口使用上也满足多态性
 * 2、接口，实际上就是定义了一种规范
 * 3、开发中，体会面向接口编程
 * @Author Eva
 * @Date 2024/5/15
 */
public class BImplement {

    public static void main(String[] args) {
        Computer com = new Computer();
//        1、创建了接口的非匿名实现类的非匿名对象
        Flash flash = new Flash();
        com.transferData(flash);

//        2、创建了接口的非匿名实现类的匿名对象
        com.transferData(new Printer());

//        3、创建了接口的匿名实现类的非匿名对象
        USB phone = new USB() {
            @Override
            public void start() {

            }

            @Override
            public void stop() {

            }
        };

//        4、创建了接口的匿名实现类的匿名对象

        com.transferData(new USB() {
            @Override
            public void start() {

            }

            @Override
            public void stop() {

            }
        });
    }
}

interface USB{
    void start();
    void stop();
}


class Computer{

    public void transferData(USB usb) {
    }
}

class Flash implements USB{

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
class Printer implements USB{

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
