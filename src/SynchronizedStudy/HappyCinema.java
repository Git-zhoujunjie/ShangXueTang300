package SynchronizedStudy;

/**
 * 实现一个电影院买票的过程
 */
public class HappyCinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(3,"zhoujunjie");
        Customer c1 = new Customer(cinema,2);
        Customer c2 = new Customer(cinema,1);

        new Thread(c1).start();
        new Thread(c2).start();
    }
}

class Customer implements Runnable{
    private Cinema cinema;
    private int bookTickets;

    public Customer(Cinema cinema, int bookTickets) {
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
class Cinema{
    int tickets;
    String name;

    public Cinema(int tickets, String name) {
        this.tickets = tickets;
        this.name = name;
    }

    //购票
    public boolean bookTickets(int bts){
        System.out.println("剩余票数："+tickets);
        tickets -= bts;
        if(tickets<0) return false;

        return true;
    }
}
