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


public class Canvas extends JPanel {

	private ArrayList<RectangularShape> list = new ArrayList<RectangularShape>();

	public Canvas() {
		setPreferredSize(new Dimension(800, 600));
		setBackground(Color.GREEN);

        bindListeners();
	}

	public void addFigure(RectangularShape figure) {
		list.add(figure);
	}

    private void bindListeners() {
        MouseSupport mouseSupport = new MouseSupport();
        this.addMouseListener(mouseSupport);
        this.addMouseListener(mouseSupport);
    }

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);


	}

    private class MouseSupport extends MouseAdapter implements MouseMotionListener {

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

    }

}
