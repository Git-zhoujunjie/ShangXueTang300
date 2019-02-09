package SynchronizedStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个电影院买票的过程2
 * 能够选择位置
 */
public class HappyCinema2 {
    public static void main(String[] args) {
        List<Integer> ct = new ArrayList<>();
        ct.add(1);
        ct.add(2);
        ct.add(3);
        ct.add(6);
        ct.add(7);

        List<Integer> c1 = new ArrayList<>();
        c1.add(1);
        c1.add(2);
        c1.add(3);
        List<Integer> c2 = new ArrayList<>();
        //c2.add(5);
        c2.add(6);
        c2.add(7);

        Cinema2 cinema = new Cinema2(ct,"zhoujunjie");

        new Thread(new Customer2(cinema,c1),"老周").start();
        new Thread(new Customer2(cinema,c2),"老婆").start();
    }
}

class Customer2 implements Runnable{
    private Cinema2 cinema;
    private List<Integer> bookTickets;

    public Customer2(Cinema2 cinema, List<Integer> bookTickets) {
        this.cinema = cinema;
        this.bookTickets = bookTickets;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(bookTickets);
            if (flag) {
                System.out.println("订票成功！" + Thread.currentThread().getName() + "订票数：" + bookTickets);
            } else {
                System.out.println("订票失败！" + Thread.currentThread().getName() + "票不足！");
            }
        }
    }
}

class Cinema2{
    List<Integer> tickets;
    String name;

    public Cinema2(List<Integer> tickets, String name) {
        this.tickets = tickets;
        this.name = name;
    }

    //购票过程可用容器的减法 removeAll()
    //[1,2,3]-[1,2] = [3] , [1,2,3]-[1,3,4]=[2]
    public boolean bookTickets(List<Integer> bts){
        System.out.println("欢迎观临"+this.name+",剩余票："+tickets);
        //先对原来的票进行拷贝
        List<Integer> copy = new ArrayList<>();
        copy.addAll(tickets);

        //容器相减
        copy.removeAll(bts);

        if(tickets.size()-copy.size() == bts.size()){
            tickets = copy;
            return true;
        }
        return false;
    }
}
