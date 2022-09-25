package TutorsHelper;


import javax.swing.*;
import java.awt.*;

import static TutorsHelper.Libs.*;

public class UpdateButton {
    private static JLabel btn;

    public static JLabel getBtn() {
        return btn;
    }

    public UpdateButton() {
    }

    public static JLabel setBtn() {
        JLabel label = new JLabel("Update checked", SwingConstants.CENTER);
        btn = label;
        label.setSize(200, 22);
        label.setBackground(studentColor);
        label.setForeground(Color.decode("#000000"));
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setFont(new Font("Arial", 0, 14));
        Window.components.add(label);
        HorizontalAlign(label, "left");
        VerticalAlign(label, "top");
        label.addMouseListener(new UpdateCheckedMouseListener(label));
        label.setLocation(label.getX() + 100, label.getY() + Task.getTempTask().getY());
        return label;

    }
}