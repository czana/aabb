package aabb.figures;

import aabb.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class Circle extends Ellipse2D.Double implements IFigure {

    private Shape figure;
    Ellipse2D.Double collisionRange;
    int RANGE;
    int MARGIN = 1;
    private ArrayList<AABB> boxes = new ArrayList<AABB>();
    Color color;

    public Circle(double x, double y, double size, int colRange) {
        super(x, y, size, size);
        color = new Color(getR(100), getR(100), getR(100) + 100);

        RANGE = colRange;
        collisionRange = new Ellipse2D.Double(getX() - RANGE, getY() - RANGE, getWidth() + RANGE * 2, getHeight() + RANGE * 2);

        boxes.add(new AABB(getX() - MARGIN, getY() - MARGIN, getWidth() + MARGIN * 2));
        setAabb();
    }

    public void checkAabbCollision(ArrayList<Circle> circles) {//AABB
        for (Circle circle : circles) {
            AABB box = circle.boxes.get(0);
            AABB aabb = boxes.get(0);

            if (Math.sqrt(Math.pow(box.getCenterX() - aabb.getCenterX(), 2) + Math.pow(box.getCenterY() - aabb.getCenterY(), 2)) < circle.collisionRange.width / 2 + collisionRange.width / 2
                    && !box.equals(aabb)) {

                System.out.println(Canvas.tmp++);

                if (aabb.getMinX() > box.getMaxX() || aabb.getMaxX() < box.getMinX() || aabb.getMinY() > box.getMaxY() || aabb.getMaxY() < box.getMinY()) {
                    aabb.collide = false;
                    box.collide = false;
                } else {
                    aabb.collide = true;
                    box.collide = true;
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(color);
        g2.fill(this);

        g2.setColor(Color.lightGray);
        g2.draw(collisionRange);

        for (AABB aabb : boxes) {
            aabb.paint(g);
        }
    }

    public void updatePosition(int x, int y) {
        this.x = x - width / 2;
        this.y = y - width / 2;
        setAabb();
        setCollisionRange();
    }

    public void setAabb() {
        boxes.get(0).setRect(getX() - MARGIN, getY() - MARGIN, getWidth() + MARGIN * 2, getHeight() + MARGIN * 2);
    }

    public void setCollisionRange() {
        collisionRange.setFrame(getX() - RANGE, getY() - RANGE, getWidth() + RANGE * 2, getHeight() + RANGE * 2);
    }

    private int getR(int range) {
        return new Random().nextInt(range);
    }
}
