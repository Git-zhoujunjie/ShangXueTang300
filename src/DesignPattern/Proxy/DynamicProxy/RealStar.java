package DesignPattern.Proxy.DynamicProxy;

/**
 * 真实角色
 */
public class RealStar implements Star {
    /**
     * 真实角色核心业务
     */
    @Override
    public void sing() {
        System.out.println("RealStar(Aimer本人).sing()");
    }


}
