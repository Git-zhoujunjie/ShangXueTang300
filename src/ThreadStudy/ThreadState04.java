package ThreadStudy;

/**
 * 查看线程的状态
 */
public class ThreadState04 {
    public static void main(String[] args) {
        //System.out.println(Thread.activeCount());
        Runnable test = () -> {
          for(int i=0;i<30;i++){
              try {
                  Thread.sleep(100);   //阻塞状态
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("...");
          }
        };  //运行完run()方法，结束状态

        Thread ntest = new Thread(test);

        System.out.println(ntest.getState()); //新生状态：NEW

        ntest.start();
        System.out.println(ntest.getState()); //就绪和运行状态：RUNNABLE

        //监控状态，方法一
//        while(true){
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(ntest.getState());
//
//        }

        //监控状态，方法二
        while(ntest.getState() != Thread.State.TERMINATED){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ntest.getState());
        }


        //方法三：监控活跃线程点数量
        /*
        while(Thread.activeCount() != 1 ){
            int count = Thread.activeCount();
            System.out.println(count);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ntest.getState());

        }
        */

        System.out.println("end");


    }
}
