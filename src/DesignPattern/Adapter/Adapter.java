package DesignPattern.Adapter;

/**
 * 适配器
 * USB转ps/2接口
 *
 * 方式一：类适配方式，将适配器继承自被适配对象
 */
public class Adapter extends Adaptee implements Target{

    /**
     * 处理请求
     */
    @Override
    public void handleReq() {
        super.request();  //直接调用父类的请求
    }
}
