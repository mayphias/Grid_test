import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Square extends JPanel implements ComponentListener {
    private int ponto_x;
    private int ponto_y;
    private int h;
    
    public Square(int ponto_x, int ponto_y, int h){
        super();
        this.ponto_x = ponto_x;
        this.ponto_y = ponto_y;
        this.h = h;
        addComponentListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1));  //grossura do traço
        g.drawLine(ponto_x, ponto_y + h, ponto_x + h, ponto_y + h);
        g.drawLine(ponto_x + h, ponto_y + h, ponto_x + h, ponto_y);
        g.drawLine(ponto_x + h, ponto_y, ponto_x, ponto_y);
        g.drawLine(ponto_x, ponto_y, ponto_x, ponto_y + h);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void componentShown(ComponentEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // TODO Auto-generated method stub
    }

    /*@Override
    public void draw(Graphics2D g2d) {
        super.paintComponent(g2d);
        g2d.setStroke(new BasicStroke(1));  //grossura do traço
        g2d.drawLine(ponto_x, ponto_y + h, ponto_x + h, ponto_y + h);
        g2d.drawLine(ponto_x + h, ponto_y + h, ponto_x + h, ponto_y);
        g2d.drawLine(ponto_x + h, ponto_y, ponto_x, ponto_y);
        g2d.drawLine(ponto_x, ponto_y, ponto_x, ponto_y + h);
    }*/
}
