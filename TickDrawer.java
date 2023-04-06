/*import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

class TickDrawer extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1));
        int tickSize = 10; // tamanho dos traços
        
        // desenha as marcas de divisão do eixo X
        int xSpacing = 50; // espaçamento entre as marcas
        int xStart = -100; // valor da primeira marca
        int xEnd = 100; // valor da última marca
        for (int x = xStart; x <= xEnd; x += xSpacing) {
            int xPixel = getWidth() / 2 + x;
            g.drawLine(xPixel, getHeight() / 2 - tickSize, xPixel, getHeight() / 2 + tickSize);
        }
        
        // desenha as marcas de divisão do eixo Y
        int ySpacing = 50; // espaçamento entre as marcas
        int yStart = -100; // valor da primeira marca
        int yEnd = 100; // valor da última marca
        for (int y = yStart; y <= yEnd; y += ySpacing) {
            int yPixel = getHeight() / 2 - y;
            g.drawLine(getWidth() / 2 - tickSize, yPixel, getWidth() / 2 + tickSize, yPixel);
        }
    }
}
*/