package aabb.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Circle extends Ellipse2D.Double implements IFigure {

    private Shape figure;
    Color color;
    Rectangle2D.Double aabb;
    boolean collide = false;
    int MARGIN = 2;

    public Circle(double x, double y, double size) {
        super(x, y, size, size);
        color = new Color(getR(), getR(), getR());

        // init aabb
        aabb = new Rectangle2D.Double();
        setAabb();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // draw aabb
        if (collide)
            g2.setColor(Color.RED);
        else
            g2.setColor(Color.CYAN.darker());
        g2.draw(aabb);

        // draw circle
        g2.setColor(color);
        g2.fill(this);
    }

    public void setAabb() {
        aabb.setRect(getX() - MARGIN, getY() - MARGIN, getWidth() + MARGIN * 2, getHeight() + MARGIN * 2);
    }

    private int getR() {
        return new Random().nextInt(150);
    }

//    AABB
    public void checkAabbCollision(Circle circle) {
        Rectangle2D.Double box = circle.aabb;
        if (aabb.getMinX() > box.getMaxX() || aabb.getMaxX() < box.getMinX() || aabb.getMinY() > box.getMaxY() || aabb.getMaxY() < box.getMinY()) {
            collide = false;
            circle.collide = false;
        } else {
            collide = true;
            circle.collide = true;
        }
    }
//    ----
}
