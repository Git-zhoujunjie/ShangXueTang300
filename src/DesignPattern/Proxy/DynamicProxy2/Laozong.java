package DesignPattern.Proxy.DynamicProxy2;

public class Laozong implements Gongneng {
    @Override
    public void chifan() {
        System.out.println("老总吃饭");
    }

    @Override
    public void tanshi() {
        System.out.println("老总谈事");
    }
}
