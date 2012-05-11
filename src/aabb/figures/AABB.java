package aabb.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

public class AABB extends Rectangle2D.Double {

    boolean collide = false;

    public AABB(double x, double y, double size) {
        super(x, y, size, size);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (collide)
            g2.setColor(Color.RED);
        else
            g2.setColor(Color.GRAY);
        g2.draw(this);
    }
}
