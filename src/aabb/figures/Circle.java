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
    public ArrayList<AABB> boxes = new ArrayList<AABB>();
    double x_move;
    double y_move;
    Color color;
    boolean collide = false;
    public static int BOX_SIZE = 10;
    static int tmp = 0;
    boolean curve;

    public Circle(double x, double y, double size, int colRange, boolean curve) {
        super(x, y, size, size);
        color = new Color(getR(100), getR(100), getR(120) + 100);
        this.curve = curve;

        RANGE = colRange;
        collisionRange = new Ellipse2D.Double(getX() - RANGE, getY() - RANGE, getWidth() + RANGE * 2, getHeight() + RANGE * 2);

        setAabb();
    }

    public void checkAabbCollision(ArrayList<Circle> circles) {//AABB
        for (Circle circle : circles) {
            if (circle != this) {
                for (AABB aabb : boxes) {
                    for (AABB box : circle.boxes) {

                        if (Math.sqrt(Math.pow(box.getCenterX() - aabb.getCenterX(), 2) + Math.pow(box.getCenterY() - aabb.getCenterY(), 2)) < circle.collisionRange.width / 2 + collisionRange.width / 2
                                && !box.equals(aabb)) {

                            if (aabb.getMinX() > box.getMaxX() || aabb.getMaxX() < box.getMinX() || aabb.getMinY() > box.getMaxY() || aabb.getMaxY() < box.getMinY()) {
                                aabb.collide = false;
                                box.collide = false;
                            } else {
                                System.out.println(tmp++);
                                aabb.collide = true;
                                box.collide = true;
                            }

                        }
                    }
                }
            }
        }
    }

    public boolean collide(AABB aabb, ArrayList<AABB> boxes) {
        for (AABB box : boxes) {
            if (aabb.getMinX() > box.getMaxX() || aabb.getMaxX() < box.getMinX() || aabb.getMinY() > box.getMaxY() || aabb.getMaxY() < box.getMinY()) {
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(color);
        g2.fill(this);

        g2.setColor(Color.lightGray);
        g2.draw(collisionRange);

        if (curve) {
            Rectangle2D.Double r1 = new Rectangle2D.Double(this.x, this.y + getWidth() / 2 - 4, 25, 60);
            Rectangle2D.Double r2 = new Rectangle2D.Double(this.x + 25, this.y - getWidth() / 2 - 6, 25, 60);
            g2.setColor(color);
            g2.fill(r1);
            g2.fill(r2);
        }

        for (AABB aabb : boxes) {
            aabb.paint(g);
        }
    }

    public void updatePosition(int x, int y) {
        x_move = this.x;
        y_move = this.y;
        this.x = x - width / 2;
        this.y = y - width / 2;
        x_move -= this.x;
        y_move -= this.y;
        setAabb();
        setCollisionRange();
    }

    public void setAabb() {
        for (AABB aabb : boxes) {
            aabb.setRect(aabb.getX() - x_move, aabb.getY() - y_move, BOX_SIZE, BOX_SIZE);
        }
    }

    public void setCollisionRange() {
        collisionRange.setFrame(getX() - RANGE, getY() - RANGE, getWidth() + RANGE * 2, getHeight() + RANGE * 2);
    }

    private int getR(int range) {
        return new Random().nextInt(range);
    }
}
