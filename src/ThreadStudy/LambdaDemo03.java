package ThreadStudy;

/**
 * lambda表达式
 *
 * 测试带参数的lambda表达式
 */
public class LambdaDemo03 {
    public static void main(String[] args) {

        class lambda03 implements LambdaTest {
            @Override
            public int count(int a1, int a2) {
                return a1 + a2;
            }
        }

        lambda03 l03 = new lambda03();
        System.out.println(l03.count(11, 22));

        //匿名内部类
        System.out.println(new LambdaTest() {
            @Override
            public int count(int a, int b) {
                return a + b;
            }
        }.count(12, 23));

        LambdaTest l05 = (int a, int b) -> {
            return a + b;
        };  //简化一

        l05 = (a, b) -> {
            return a + b;
        };  //简化二

        l05 = (a, b) ->  a + b; //简化三，return可以省略

        l05 = (a,b) -> 100;

        System.out.println(l05.count(14,45));
    }
}



//接口内部方法带参数
interface LambdaTest{
    int count(int a,int b);
}

