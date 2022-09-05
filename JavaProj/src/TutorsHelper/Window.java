package TutorsHelper;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import static TutorsHelper.Libs.*;

public class Window extends JFrame {
    public static Vector<JComponent> components = new Vector<>();
    public static JLayeredPane mainPanel = new JLayeredPane();

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
    Window() {
        super("ИКБО-02-21, JAVA_3sem");

        // set content
        Grid.setGrid();
        mainPanel.setOpaque(true);
        mainPanel.setBackground(backgroundColor);
        components.forEach(mainPanel::add);
        getContentPane().add(mainPanel);


        // window params
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(FRAME__WIDTH + 16, FRAME__HEIGHT + 39);
        setResizable(false);
        setLocation(GetCentralLocation());
    }
}