package rotating_cube;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.round;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Jecihjoy
 */
public class RotateCube extends JPanel {
    double[][] nodes = {{-1, -1, -1}, {-1, -1, 1}, {-1, 1, -1}, {-1, 1, 1},
    {1, -1, -1}, {1, -1, 1}, {1, 1, -1}, {1, 1, 1}};
 
    int[][] edges = {{0, 1}, {1, 3}, {3, 2}, {2, 0}, {4, 5}, {5, 7}, {7, 6},
    {6, 4}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
 
    public RotateCube(double t) {
        setPreferredSize(new Dimension(640, 640));
        setBackground(Color.GREEN);
        
            new Timer(17, (ActionEvent e) -> {
            rotateCube(PI / t, 0);
            repaint();
        }).start();
 
        scale(100);
        rotateCube(PI / 4, atan(sqrt(2)));
 
    }
 
    final void scale(double s) {
        for (double[] node : nodes) {
            node[0] *= s;
            node[1] *= s;
            node[2] *= s;
        }
    }
 
    final void rotateCube(double angleX, double angleY) {
        double sinX = sin(angleX);
        double cosX = cos(angleX);
 
        double sinY = sin(angleY);
        double cosY = cos(angleY);
 
        for (double[] node : nodes) {
            double x = node[0];
            double y = node[1];
            double z = node[2];
 
            node[0] = x * cosX - z * sinX;
            node[2] = z * cosX + x * sinX;
 
            z = node[2];
 
            node[1] = y * cosY - z * sinY;
            node[2] = z * cosY + y * sinY;
        }
    }
 
    void drawCube(Graphics2D g) {
        g.translate(getWidth() / 2, getHeight() / 2);
 
        for (int[] edge : edges) {
            double[] xy1 = nodes[edge[0]];
            double[] xy2 = nodes[edge[1]];
            g.drawLine((int) round(xy1[0]), (int) round(xy1[1]),
                    (int) round(xy2[0]), (int) round(xy2[1]));
        }
 
        for (double[] node : nodes) 
            g.fillOval((int) round(node[0]) - 4, (int) round(node[1]) - 4, 8, 8);        
    }
 
    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
 
        drawCube(g);
    }
    
}
