package ThreadStudy;

/**
 * Lambda表达式用于简化线程的使用
 */
public class LambdaDemo04 {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("一边学习Lambda");
        }).start();

        new Thread( () -> System.out.println("一边崩溃中...")).start();

    }
}
