package TutorsHelper;

import javax.swing.*;
import java.awt.*;

import static TutorsHelper.Libs.*;

public class Elements {

    public Elements() {}

    public static JLabel newTaskLabel(String number) {
        JLabel label = new JLabel(number, SwingConstants.CENTER);
        label.setSize(28, 22);
        label.setBackground( Color.decode(taskColor));
        label.setForeground(Color.decode("#000000"));
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setFont(new Font("Arial", 0, 12));
        Window.components.add(label);
        return label;
    }

    public static JLabel newStudentLabel(String name) {
        JLabel label = new JLabel(name, SwingConstants.LEFT);
        label.setSize(130, 20);
        label.setBackground( Color.decode(studentColor));
        label.setForeground(Color.decode("#000000"));
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setFont(new Font("Arial", 0, 12));
        Window.components.add(label);
        return label;
    }

    public static JButton newCheckbox() {
        JButton checkbox = new JButton();
        checkbox.setSize(28, 20);
        checkbox.setBackground(Color.decode(checkBoxColor__false));
        checkbox.setOpaque(true);
        checkbox.setBorder(BorderFactory.createLineBorder(Color.decode(borderColor)));
        Window.components.add(checkbox);
        return checkbox;
    }

}
