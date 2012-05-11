package aabb;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Point;

import aabb.figures.IFigure;
import aabb.figures.Circle;
import java.awt.RenderingHints;

public class Canvas extends JPanel {
    
    public static int tmp = 0;
    private ArrayList<Circle> list = new ArrayList<Circle>();
    private Circle draggedFigure = null;

    public Canvas() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);

        bindListeners();
    }

    public void addFigure(Circle figure) {
        list.add(figure);
    }

    private void bindListeners() {
        MouseSupport mouseSupport = new MouseSupport();
        this.addMouseListener(mouseSupport);
        this.addMouseMotionListener(mouseSupport);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Iterator<Circle> i = list.iterator();
        while (i.hasNext()) {
            Circle figure = i.next();
            figure.paint(g);
        }
    }

    public Circle findFigure(Point point) {
        Iterator<Circle> i = list.iterator();

        while (i.hasNext()) {
            Circle figure = i.next();
            if (figure.contains(point)) {
                return figure;
            }
        }
        return null;
    }

    private class MouseSupport extends MouseAdapter implements MouseMotionListener {

        @Override
        public void mousePressed(MouseEvent e) {
            draggedFigure = findFigure(e.getPoint());
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            draggedFigure.updatePosition(e.getX(), e.getY());
            draggedFigure.checkAabbCollision(list);
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }
}
