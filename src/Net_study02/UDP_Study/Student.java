package Net_study02.UDP_Study;

/**
 * 学生：加入多线程，实现双向交流
 */
public class Student {
    public static void main(String[] args) {
        new Thread(new TalkServer02("学生",8888)).start();
        new Thread(new TalkClient02("学生",8889,"localhost",11111)).start();
    }
}
