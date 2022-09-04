package TutorsHelper;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static TutorsHelper.Libs.*;

public class Elements {

    public Elements() {}

    public static JLabel newTaskLabel(String number) {
        JLabel label = new JLabel(number, SwingConstants.CENTER);
        label.setSize(28, 22);
        label.setBackground(taskColor);
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
        label.setBackground(studentColor);
        label.setForeground(Color.decode("#000000"));
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setFont(new Font("Arial", 0, 12));
        Window.components.add(label);
        return label;
    }


    private static void UpdateConfig() {
        StringBuilder updatedConfig = new StringBuilder();
        int cnt = 0;
        for (JButton checkbobx:
             CheckBoxes) {
            updatedConfig.append(checkbobx.getBackground() == checkBoxColor__true ?
                    "+" : "-");
            updatedConfig.append(cnt % tasksAmount == (tasksAmount - 1) && cnt != tasksAmount * Students.size() - 1 ?
                    "\n" : "");
            cnt++;
        }
        try {
            List<StringBuilder> lines = Arrays.asList(updatedConfig);
            Files.write(Paths.get("TasksConfig.txt"), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static JButton newCheckbox() {
        JButton checkbox = new JButton();
        checkbox.setSize(28, 20);
        checkbox.setBackground(checkBoxColor__false);
        checkbox.setOpaque(true);
        checkbox.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        Window.components.add(checkbox);

        checkbox.addActionListener(e -> {
            checkbox.setBackground(
                    checkbox.getBackground() == checkBoxColor__true ?
                            checkBoxColor__false :
                            checkBoxColor__true

            );
            UpdateConfig();
            System.out.println("he");
            /*checkbox.setBorder(
                    checkbox.getBackground() == checkBoxColor__true ?
                            BorderFactory.createLineBorder(borderColor, 0) :
                            BorderFactory.createLineBorder(borderColor, 1)
            );*/
        });

        return checkbox;
    }
    public static void ConfigureCheckboxes(ArrayList<JButton> CheckBoxes, List<String> config) {
        for(int i = 0; i < config.size(); i++) {
            for (int j = 0; j < tasksAmount; j++) {
                CheckBoxes.get(i*config.size() + j).setBackground(
                        config.get(i).charAt(j) == '+' ?
                                checkBoxColor__true :
                                checkBoxColor__false
                );
                /*CheckBoxes.get(i*config.size() + j).setBorder(
                        config.get(i).charAt(0) == '+' ?
                                BorderFactory.createLineBorder(borderColor, 1) :
                                BorderFactory.createLineBorder(borderColor, 1)
                );*/

            }
        }
    }

}
