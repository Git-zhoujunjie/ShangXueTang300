package MyGame01;

import java.awt.*;

/**
 * 飞机类
 */
public class Plane extends GameObject {
    public void drawMySelf(Graphics g){
        super.drawMySelf(g);
        this.x += 3;
    }

    public Plane(Image img, double x, double y) {
        super(img, x, y);
    }
}
