package aabb;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;


public class Canvas extends JPanel {

	private ArrayList<RectangularShape> list = new ArrayList<RectangularShape>();

	public Canvas() {
		setPreferredSize(new Dimension(800, 600));
		setBackground(Color.WHITE);
	}

	public void addFigure(RectangularShape figure) {
		list.add(figure);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		
	}

}