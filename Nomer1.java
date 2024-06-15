import javax.swing.*;
import java.awt.*;


class MyPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int x0 = 50; // x-coordinate of the starting point
        int y0 = 50; // y-coordinate of the starting point
        int x1 = 200; // x-coordinate of the ending point
        int y1 = 100; // y-coordinate of the ending point

        int dx = x1 - x0;
        int dy = y1 - y0;

        int x = x0;
        int y = y0;
        int d = 2 * dy - dx;

        g2d.drawLine(x0, y0, x1, y1);

        while (x < x1) {
            if (d <= 0) {
                d += 2 * dy;
            } else {
                d += 2 * (dy - dx);
                y++;
            }
            x++;
            g2d.drawLine(x, y, x, y);
        }
    }
}

class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Midpoint Line Drawing Algorithm");
        MyPanel panel = new MyPanel();
        frame.add(panel);
        frame.setSize(300, 200);
        frame.addWindowListener(new MyFinishWindow());
        frame.setVisible(true);
    }
}
