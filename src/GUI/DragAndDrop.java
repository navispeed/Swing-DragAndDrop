package GUI;

import com.oracle.tools.packager.Log;
import model.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class DragAndDrop implements MouseMotionListener {
    private static final long REFRESH_INTERVAL_MS = 17;
    public ArrayList<Line2D> lineList;
    public JPanel panel1;
    private JButton button;
    private boolean dragging = false;
    private int x;
    private int y1;
    private int y2;
    private long nextTime= 0;


    public DragAndDrop(JFrame frame) {
        lineList = new ArrayList<>();
        panel1.addMouseMotionListener(this);
        button.addMouseMotionListener(this);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dragging = true;
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
                lineList.add(new Line2D.Float(x, y1, x, y2));
                super.mouseReleased(e);
            }
        });
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!dragging) {
            return;
        }
        Graphics2D g2 = (Graphics2D) panel1.getGraphics();
        y1 = e.getY() - 50;
        x = e.getX();
        y2 = e.getY() + 50;
        Line2D lin = new Line2D.Float(x, y1, x, y2);
//        System.out.println(e.getPoint().toString());
        if (this.nextTime < System.currentTimeMillis()) {
            this.nextTime = System.currentTimeMillis() + REFRESH_INTERVAL_MS;
            panel1.paint(g2);
            for (Line2D l : this.lineList) {
                g2.draw(l);
            }
            g2.draw(lin);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    private void paint() {

    }
}
