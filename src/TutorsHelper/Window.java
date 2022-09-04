package TutorsHelper;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import static TutorsHelper.Libs.*;

public class Window extends JFrame {
    private Point GetCentralLocation() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        // FIXME: need to divide by a screen's scaling below:
        int centerX = (screenWidth - Libs.FRAME__WIDTH)/2;
        int centerY = (screenHeight - Libs.FRAME__HEIGHT)/2;
        Point coordinates = new Point(centerX, centerY);
        return coordinates;
    }
    public static Vector<JComponent> components = new Vector<>();
    Window() {
        super("Football match");

        // set content
        Grid.setGrid();
        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.decode("#454545"));
        components.forEach((elem) -> mainPanel.add(elem));
        getContentPane().add(mainPanel);


        // window params
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(FRAME__WIDTH + 16, FRAME__HEIGHT + 39);
        setResizable(false);
        setLocation(GetCentralLocation());
    }
}