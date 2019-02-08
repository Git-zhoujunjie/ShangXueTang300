package MyGame01;

import java.awt.*;

/**
 * 该类是所有物体的父类，包含物体的坐标，大小，画出物体
 */
public class GameObject {
    Image img;
    double x,y,speed,width,height;

    public void drawMySelf(Graphics g){
        g.drawImage(img,(int)x,(int)y,null);
    }

    public GameObject(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public GameObject(Image img, double x, double y, double speed, double width, double height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,(int)width,(int)height);
    }
}
