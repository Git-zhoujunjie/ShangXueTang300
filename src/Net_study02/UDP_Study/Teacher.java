package Net_study02.UDP_Study;

/**
 * 老师：加入多线程，实现双向交流
 */
public class Teacher {
    public static void main(String[] args) {

        new Thread(new TalkServer02("老师",11111)).start();
        new Thread(new TalkClient02("老师",11112,"localhost",8888)).start();
    }
}
