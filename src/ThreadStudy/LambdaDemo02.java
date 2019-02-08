package ThreadStudy;

/**
 * 认识Lambda表达式02
 * 手写一个接口，然后用Lambda表达式进行实现
 */
public class LambdaDemo02 /*implements Lambda    1. 外部接口*/{

    //2. 静态内部类
    static class Lambda2 implements Lambda{
        @Override
        public void lambda() {
            System.out.println("这是lambda02！");
        }
    }

    public static void main(String[] args) {
        new Lambda2().lambda();

        //3. 局部内部类
        class Lambda3 implements Lambda{
            @Override
            public void lambda() {
                System.out.println("这是lambda03！");
            }
        }
        new Lambda3().lambda();

        //匿名内部类
        new Lambda(){
            @Override
            public void lambda() {
                System.out.println("这是lambda04！");
            }
        }.lambda();

        Lambda l4 = ()-> {System.out.println("这是lambda05！简化一");}; //接口内部只能有一个方法 ，简化一
        l4.lambda();

        l4 = () -> System.out.println("这是lambda04！简化二");
        l4.lambda();

        /* 不能这样写，lambda表达式必须要有类型，就是必须赋给一个对象
        ()-> {System.out.println("这是lambda05！简化一");}.lambda();
        */
    }


}

interface Lambda{
    void lambda();
}
