package GaojiThem;

/**
 * volatile保证线程间变量的可见性，也就是数据的及时同步
 */
public class VolatileTest {
    private static volatile int num = 0; //添加volatile，保证数据点即时同步
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while(num==0){
                //System.out.println();
            } //一个死循环，不要添加信息，保证CPU忙的没有时间观察num的变化
        }).start();

        Thread.sleep(1000);
        num = 1;  //这里main()线程中num变化
    }
}
