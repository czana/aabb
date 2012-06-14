package aabb;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import aabb.figures.*;

public class Main {

    public void createGUI() {
        JFrame frame = new JFrame("AABB Tomasz Czana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(initCanvas());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private Canvas initCanvas() {
        Canvas canvas = new Canvas();

        Circle c1 = new Circle(230, 250, 50, 46, true);
        c1.boxes.add(new AABB(c1.x - 4, c1.y + 19, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 43, c1.y + 19, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 19, c1.y - 4, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 21, c1.y - 13, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 21, c1.y - 24, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 21, c1.y - 35, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 43, c1.y - 13, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 43, c1.y - 24, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 43, c1.y - 35, (double) Circle.BOX_SIZE));        
        c1.boxes.add(new AABB(c1.x + 43, c1.y - 4, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 43, c1.y + 7, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 43, c1.y + 18, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 19, c1.y + 43, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 17, c1.y + 52, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 17, c1.y + 63, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 17, c1.y + 74, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x - 4, c1.y + 52, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x - 4, c1.y + 63, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x - 4, c1.y + 74, (double) Circle.BOX_SIZE));        
        c1.boxes.add(new AABB(c1.x - 4, c1.y + 43, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x - 4, c1.y + 32, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x - 4, c1.y + 21, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 3, c1.y + 3, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 37, c1.y + 36, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x -2, c1.y + 10, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 41, c1.y + 28, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 10, c1.y - 2, (double)Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 29, c1.y + 41, (double)Circle.BOX_SIZE));

        c1.boxes.add(new AABB(c1.x + 7, c1.y + 74, (double) Circle.BOX_SIZE));
        c1.boxes.add(new AABB(c1.x + 32, c1.y - 35, (double) Circle.BOX_SIZE));
        canvas.addFigure(c1);

        Circle c2 = new Circle(530, 250, 50, 15, false);
        c2.boxes.add(new AABB(c2.x - 4, c2.y + 19, (double) Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 43, c2.y + 19, (double) Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 19, c2.y - 4, (double) Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 19, c2.y + 43, (double) Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 3, c2.y + 3, (double) Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 37, c2.y + 3, (double) Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 3, c2.y + 36, (double) Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 37, c2.y + 36, (double) Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x -2, c2.y + 10, (double) Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 41, c2.y + 10, (double) Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x -2, c2.y + 28, (double) Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 41, c2.y + 28, (double) Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 10, c2.y - 2, (double)Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 29, c2.y - 2, (double)Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 10, c2.y + 41, (double)Circle.BOX_SIZE));
        c2.boxes.add(new AABB(c2.x + 29, c2.y + 41, (double)Circle.BOX_SIZE));
        canvas.addFigure(c2);
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
