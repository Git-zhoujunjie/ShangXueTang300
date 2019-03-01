package DesignPattern.Adapter;

/**
 * 适配器
 * USB转ps/2接口
 *
 * 方式二：组合适配方式，避免了单继承的局限性
 */
public class Adapter2 implements Target{

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * 处理请求
     */
    @Override
    public void handleReq() {
        adaptee.request();
    }
}
