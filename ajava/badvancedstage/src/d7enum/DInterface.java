package d7enum;

/**
 * @Description: enum实现接口
 * @Author Eva
 * @Date 2024/5/27 16:21
 */
enum DInterface implements Info {
    //    情况二：让枚举类的对象分别实现接口中的抽象方法
    SPRING("春天","困"){
        @Override
        public void run() {
            super.run();
        }
    },
    SUMMER("夏天","乏"){
        @Override
        public void run() {
            super.run();
        }
    },
    AUTUMN("秋天","打盹"){
        @Override
        public void run() {
            super.run();
        }
    },
    WINTER("冬天","眠"){
        @Override
        public void run() {
            super.run();
        }
    };
    private final String seasonName;
    private final String seasonDesc;
    private DInterface(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //    情况一：实现接口，再enum类中实现抽象方法
    @Override
    public void run() {

    }
}

interface Info{
    void run();
}
