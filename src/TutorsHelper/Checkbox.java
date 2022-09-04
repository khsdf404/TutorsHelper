package TutorsHelper;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static TutorsHelper.Libs.*;
import static TutorsHelper.Student.getStudents;
import static TutorsHelper.Task.getTempTask;

public class Checkbox {
    private static ArrayList<JButton> checkboxList = new ArrayList<>();
    private static List<String> config = getConfig();

    public static void setCheckboxes() {
        for (int i = 0; i < getStudents().size(); i++) {
            JLabel currStudent = getStudents().get(i);
            int startX = currStudent.getX() + currStudent.getWidth();
            int yPos = currStudent.getY();
            for (int j = 0; j < tasksAmount; j++) {
                int xPos = startX + getTempTask().getWidth() * j;
                JButton checkbox = newCheckbox();
                checkbox.setLocation(xPos, yPos);
                checkboxList.add(checkbox);
            }
        }
        ConfigureCheckboxes(checkboxList, config);
    }
    public static ArrayList<JButton> getCheckboxes() {
        return checkboxList;
    }

    private static JButton newCheckbox() {
        JButton checkbox = new JButton();
        checkbox.setSize(28, 20);
        checkbox.setBackground(checkBoxColor__false);
        checkbox.setOpaque(true);
        checkbox.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        Window.components.add(checkbox);
        setClickListener(checkbox);
        return checkbox;
    }
    private static void setClickListener(JButton checkbox) {
        checkbox.addActionListener(e -> {
            checkbox.setBackground(
                    checkbox.getBackground() == checkBoxColor__true ?
                            checkBoxColor__false :
                            checkBoxColor__true

            );
            setConfig();
        });
    }

    private static List<String> getConfig() {
        try {
            return Files.readAllLines(Paths.get("TasksConfig.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void setConfig() {
        StringBuilder updatedConfig = new StringBuilder();
        int cnt = 0;
        for (JButton checkbox:
                checkboxList) {
            updatedConfig.append(checkbox.getBackground() == checkBoxColor__true ?
                    "+" : "-");
            updatedConfig.append(cnt % tasksAmount == (tasksAmount - 1) && cnt != tasksAmount * getStudents().size() - 1 ?
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
    private static void ConfigureCheckboxes(ArrayList<JButton> CheckBoxes, List<String> config) {
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
