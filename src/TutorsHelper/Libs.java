package TutorsHelper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Libs {
    public static int FRAME__WIDTH = 1280;
    public static int FRAME__HEIGHT = 720;
    public static Color backgroundColor = Color.decode("#e5e5e5");
    public static Color taskColor = Color.decode("#cdc5c2");
    public static Color studentColor = Color.decode("#cdc5c2");
    public static Color checkBoxColor__true = Color.decode("#6495ed");
    public static Color checkBoxColor__false = Color.decode("#fc8e86");
    public static Color borderColor = Color.decode("#4d5542");

    public static final int tasksAmount = 32;
    public static ArrayList<JLabel> Tasks = new ArrayList<>();
    public static ArrayList<JLabel> Students = new ArrayList<>();
    public static ArrayList<JButton> CheckBoxes = new ArrayList<>();

    public static void HorizontalAlign(JComponent button, String aligment) {
        if (aligment == "center")
            button.setLocation((FRAME__WIDTH - button.getWidth())/2, button.getY());
        else if (aligment == "left")
            button.setLocation(0, button.getY());
        else if (aligment == "right")
            button.setLocation(FRAME__WIDTH - button.getWidth(), button.getY());
        else return;
    }
    public static void HorizontalAlign(JComponent button, String aligment, JComponent element) {
        if (aligment == "toLeft")
            button.setLocation(element.getX() - button.getWidth(), button.getY());
        else if (aligment == "toRight")
            button.setLocation(element.getX() + element.getWidth(), button.getY());
        else return;
    }
    public static void VerticalAlign(JComponent button, String aligment) {
        if (aligment == "center")
            button.setLocation(button.getX(), (FRAME__HEIGHT - button.getHeight())/2);
        else if (aligment == "top")
            button.setLocation(button.getX(), 0);
        else if (aligment == "bottom")
            button.setLocation(button.getX(), FRAME__HEIGHT - button.getHeight());
        else return;
    }
    public static void VerticalAlign(JComponent button, String aligment, JComponent element) {
        if (aligment == "toTop")
            button.setLocation(button.getX(), element.getY() - button.getHeight());
        else if (aligment == "under")
            button.setLocation(button.getX(), element.getY() + element.getHeight());
    }
}
