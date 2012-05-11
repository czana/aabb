package aabb;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import aabb.figures.*;

public class Main {

    public void createGUI() {
        JFrame frame = new JFrame("AABB Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(initCanvas());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.show();
    }

    private Canvas initCanvas() {
        Canvas canvas = new Canvas();
        canvas.addFigure(new Circle(500, 150, 60, 20));
        canvas.addFigure(new Circle(200, 150, 40, 15));
        canvas.addFigure(new Circle(500, 350, 55, 20));
        canvas.addFigure(new Circle(200, 350, 90, 25));
        return canvas;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Main().createGUI();
            }
        });
    }
}
