import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GeometryInput extends JFrame {
    private JComboBox<String> shapeList;
    private JLabel position_xLabel;
    private JTextField position_xField;
    private JLabel position_yLabel;
    private JTextField position_yField;
    private JLabel sizeLabel;
    private JTextField sizeField;
    private JButton submitButton;

    public GeometryInput(){
        super("Geometry Input");

        // create shape list
        String[] shapes = {"Square"/* , "Circle", "Triangle"*/};
        shapeList = new JComboBox<>(shapes);

        // create form components
        position_xLabel = new JLabel("Position X:");
        position_xField = new JTextField(10);
        position_yLabel = new JLabel("Position Y:");
        position_yField = new JTextField(10);
        sizeLabel = new JLabel("Size:");
        sizeField = new JTextField(10);
        submitButton = new JButton("Submit");

        // create panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // add JComboBox to top left corner of layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(shapeList, gbc);

        // add other form components
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(position_xLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(position_xField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(position_yLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(position_yField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(sizeLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(sizeField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(submitButton, gbc);

        // set panel as content pane
        getContentPane().add(panel);

        // set frame properties
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display() {
        setVisible(true);

        // add submit button action listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get selected shape
                String selectedShape = (String) shapeList.getSelectedItem();

                // get input values
                int position_x = Integer.parseInt(position_xField.getText());
                int position_y = Integer.parseInt(position_yField.getText());
                int size = Integer.parseInt(sizeField.getText());

                // create shape object based on selected shape and input values
                switch (selectedShape) {
                    case "Square":
                        Square square = new Square(position_x, position_y, size);
                        // do something with square object
                        break;
                    /*
                    case "Circle":
                        Circle circle = new Circle(position_x, position_y, Double.parseDouble(size));
                        // do something with circle object
                        break;
                    case "Triangle":
                        Triangle triangle = new Triangle(position_x, position_y, Double.parseDouble(size));
                        // do something with triangle object
                        */
                    default:
                        // handle invalid selection
                        break;
                }
            }
        });
    }
    @Override
    public void componentResized(ComponentEvent e) {
        repaint();
    }

    @Override
    public void componentHidden(ComponentEvent e) {} //modifications on hidden components of the window not necessery

    @Override
    public void componentMoved(ComponentEvent e) {} //modifications when the window is moved not neccessary

    @Override
    public void componentShown(ComponentEvent e) { //Don't know what it does

    }
}
