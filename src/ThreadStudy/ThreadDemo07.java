package ThreadStudy;

/**
 * 静态代理的实现 StaticPoxy    后期用于记录日志
 * 类似 new Thread().start();
 *
 * 实现接口：
 * 1、真实角色
 * 2、代理角色
 */
public class ThreadDemo07 {
    public static void main(String[] args) {
        //You ii = new You();
        new AgentWedding(new You()).HappyMarry(); //匿名
    }
}

interface Wedding{
    void HappyMarry();
}

class You implements Wedding{

    @Override
    public void HappyMarry() {
        System.out.println("I am very happy!");
    }
}


class AgentWedding implements Wedding{
    private You you;

    public AgentWedding(You you) {
        this.you = you;
    }

    public void HappyMarry(){
        before();
        this.you.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("婚礼前...");
    }

    private void after() {
        System.out.println("婚礼后...");

    }
}
