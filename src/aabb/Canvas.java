package aabb;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import aabb.figures.IFigure;


public class Canvas extends JPanel {

	private ArrayList<IFigure> list = new ArrayList<IFigure>();

	public Canvas() {
		setPreferredSize(new Dimension(800, 600));
		setBackground(Color.GREEN);

        bindListeners();
	}

	public void addFigure(IFigure figure) {
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


	}

    private class MouseSupport extends MouseAdapter implements MouseMotionListener {

        @Override
        public void mousePressed(MouseEvent e) {
            //System.out.println("start dnd at " + e.);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("stop drag");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.println("start drag");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //not used here
        }

    }

}
