import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Drawer extends JPanel implements ComponentListener {

    private TickDrawer tickDrawer;
    private String selectedShape = "Square"; // default to square
    Square square = new Square(0, 0, 0);
    


    public Drawer() {
        this.addComponentListener(this);
        tickDrawer = new TickDrawer();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));  //grossura do traço

        // desenha eixo X
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2); 
        
        // desenha eixo Y
        g.drawLine(getWidth() / 2 , 0, getWidth() / 2, getHeight()); 

        // desenha as marcas de divisão
        tickDrawer.paintComponent(g);

        // desenha eixo X e números abaixo
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2); 
        for (int x = -15; x <= 15; x++) {
            int xPixel = getWidth() / 2 + x * 50;
            g.drawString(Integer.toString(x), xPixel, getHeight() / 2 + 15 + g.getFont().getSize() / 2);
        }

        // desenha eixo Y e números à esquerda
        g.drawLine(getWidth() / 2 , 0, getWidth() / 2, getHeight()); 
        for (int y = -15; y <= 15; y++) {
            int yPixel = getHeight() / 2 - y * 50;
            g.drawString(Integer.toString(y), getWidth() / 2 - 30 - g.getFontMetrics().stringWidth(Integer.toString(y)), yPixel + g.getFont().getSize() / 2);
        }

        //desenha quadrado
        if(selectedShape.equals("Square")) {
            square.paintComponent(g2d);
        }


    }


    @Override
    public void componentResized(ComponentEvent e) {
        int tickOffsetx = getHeight() / 2; // deslocamento vertical das marcas
        int tickOffsety = getWidth() / 2; //deslocamento horizontal das marcas
        tickDrawer.setTickOffsety(tickOffsety);
        tickDrawer.setTickOffsetx(tickOffsetx); // update the tick offset
        repaint();
    }

    @Override
    public void componentHidden(ComponentEvent e) {} //modifications on hidden components of the window not necessery

    @Override
    public void componentMoved(ComponentEvent e) {} //modifications when the window is moved not neccessary

    @Override
    public void componentShown(ComponentEvent e) {} //Don't know what it does
}

class TickDrawer extends JPanel {
    private int tickOffsetx = 0;
    private int tickOffsety = 0;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        int tickSize = 10; // tamanho dos traços
        
        // desenha as marcas de divisão do eixo X
        int xSpacing = 50; // espaçamento entre as marcas
        int xStart = -1500; // valor da primeira marca (150 inicia em 0)
        int xEnd = 1500; // valor da última marca
        for (int x = xStart; x <= xEnd; x += xSpacing) {
            int xPixel = getWidth() / 2 + x;
            g.drawLine(xPixel, tickOffsetx - tickSize, xPixel, tickOffsetx + tickSize);
        }

        // desenha as marcas de divisão do eixo Y
        int ySpacing = 50; // espaçamento entre as marcas
        int yStart = -1500; // valor da primeira marca
        int yEnd = 1500; // valor da última marca
        for (int y = yStart; y <= yEnd; y += ySpacing) {
            int yPixel = getHeight() / 2 - y;
            g.drawLine(tickOffsety- tickSize, yPixel, tickOffsety + tickSize, yPixel);
        }

    }
        public void setTickOffsetx(int tickOffsetx) {
        this.tickOffsetx = tickOffsetx;
    }
        public void setTickOffsety(int tickOffsety) {
        this.tickOffsety = tickOffsety;
    }
}
