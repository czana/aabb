package aabb;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import aabb.*;
import aabb.figures.*;

public class AABB {
	public void createGUI() {
        JFrame frame = new JFrame("AABB Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(initCanvas());
        frame.pack();
        frame.show();
	}

    private Canvas initCanvas() {
        Canvas canvas = new Canvas();

        canvas.addFigure(new Circle());
        canvas.addFigure(new Square());

        return canvas;
    }

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new AABB().createGUI();
            }
        });
		
	}
}