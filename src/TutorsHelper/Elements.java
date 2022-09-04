package TutorsHelper;

import javax.swing.*;
import java.awt.*;

import static TutorsHelper.Libs.*;

public class Elements {

    public Elements() {}

    public static JLabel newTaskLabel(String number) {
        JLabel label = new JLabel(number, SwingConstants.CENTER);
        label.setSize(24, 24);
        label.setBackground( Color.decode("#777777"));
        label.setForeground(Color.decode("#000000"));
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setFont(new Font("Arial", 0, 10));
        Window.components.add(label);
        return label;
    }

    public static JLabel newStudentLabel(String name) {
        JLabel label = new JLabel(name, SwingConstants.LEFT);
        label.setSize(130, 20);
        label.setBackground( Color.decode("#777777"));
        label.setForeground(Color.decode("#000000"));
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setFont(new Font("Arial", 0, 12));
        Window.components.add(label);
        return label;
    }

    public static JButton newButton(String text, Dimension size, int fontSize, JComponent component) {
        JButton button = new JButton(text);
        button.setSize(size);
        HorizontalAlign(button, "center");
        VerticalAlign(button, "under", component);
        button.setBackground( Color.decode("#777788"));
        button.setForeground(Color.decode("#000000"));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", 0, fontSize));
        button.addActionListener(e -> {
            if (text == "++Real") {
                realScore++;
                lastScored = "Real";
            }
            else {
                madridScore++;
                lastScored = "Madrid";
            }
        });
        Window.components.add(button);
        return button;
    }


}
