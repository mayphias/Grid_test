import javax.swing.JFrame;

public class Window {
    JFrame frame;
    
    public Window(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 500);
        
        Drawer panel = new Drawer();
        frame.add(panel);

        frame.setVisible(true);
    }
}