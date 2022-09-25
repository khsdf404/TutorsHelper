package TutorsHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    private static final ArrayList<JButton> checkboxList = new ArrayList<>();
    private static final List<String> config = getConfig();
    private static final Dimension size = new Dimension(28, 22);

    public static Dimension getSize() { return size; }
    public static ArrayList<JButton> getCheckboxes() {
        return checkboxList;
    }


    private static JButton newCheckbox() {
        JButton checkbox = new JButton();
        checkbox.setSize(size);
        checkbox.setBackground(checkBoxColor__false);
        checkbox.setOpaque(true);
        checkbox.setBorder(BorderFactory.createLineBorder(borderColor, 0));
        checkbox.addMouseListener(new CheckboxMouseListener(checkbox));
        Window.components.add(checkbox);
        return checkbox;
    }
    public static JLabel newLine(Dimension size) {
        JLabel line = new JLabel();
        line.setSize(size);
        line.setOpaque(true);
        line.setBackground(Color.decode("#969992"));
        line.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        // Window.mainPanel.add(line, 2, 0);
        return line;
    }
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
        ConfigureCheckboxes();
    }


    private static List<String> getConfig() {
        try {
            return Files.readAllLines(Paths.get("TasksConfig.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void setConfig() {
        StringBuilder updatedConfig = new StringBuilder();
        int cnt = 0;
        for (JButton checkbox: checkboxList) {
            Color background = checkbox.getBackground();
            updatedConfig.append(
                background == checkBoxColor__true ?
                    "+" :
                    background == checkBoxColor__waiting ?
                        "&" :
                        "-"
            );
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
    public static void ConfigureCheckboxes() {
        if (config.size() != getStudents().size()) {
            for (JButton checkbox: checkboxList)
                checkbox.setBackground(checkBoxColor__false);
            return;
        }
        for(int i = 0; i < config.size(); i++) {
            for (int j = 0; j < tasksAmount; j++) {
                char state = config.get(i).charAt(j);
                checkboxList.get(i*tasksAmount + j).setBackground(
                        state == '+' ?
                                checkBoxColor__true :
                                state == '&' ?
                                    checkBoxColor__waiting :
                                    checkBoxColor__false
                );
            }
        }
    }
}
