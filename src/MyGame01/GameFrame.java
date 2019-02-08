package MyGame01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 该类用于显示图像
 */
public class GameFrame extends Frame {

    Image i1 = GameUtil.getImage("images/bg.jpg");
    Image i2 = GameUtil.getImage("Images/astarte.png");

    public void launchFrame(){
        setTitle("简单飞机炮弹游戏");
        setSize((int)Constant.GAME_WIDTH,(int)Constant.GAME_HEIGH);
        setLocation(200,200);
        setVisible(true);

        new PaintThread().start(); //启动重画线程
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g){

        g.drawImage(i1,200,200,500,500,null);
       // Plane p = new Plane(i2,250,250);
        //p.drawMySelf();
    }

    class PaintThread extends Thread{
        public void run(){
            while(true){
                repaint();  //重画
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Image offScreenImage = null;

    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(500,500);//这是游戏窗口的宽度和高度

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public static void main(String[] args){
        GameFrame test = new GameFrame();
        test.launchFrame();
    }
}
