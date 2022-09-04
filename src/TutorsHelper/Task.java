package TutorsHelper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static TutorsHelper.Libs.*;
import static TutorsHelper.Libs.HorizontalAlign;
import static TutorsHelper.Student.getTempStudent;

public class Task {
    private static Dimension size = new Dimension(28, 22);
    private static ArrayList<JLabel> taskList = new ArrayList<>();
    private static JLabel tempTask = setTempTask();

    public static void setTasks() {
        JLabel previousTask = new JLabel("");
        for (int i = 0; i < tasksAmount; i++) {
            JLabel task = newTaskLabel("#" + Integer.toString(i + 1));
            VerticalAlign(task, "top");
            if (i == 0) {
                HorizontalAlign(task, "left");
                task.setLocation(task.getX() + getTempStudent().getX() + getTempStudent().getWidth(), task.getY() + 30);
            }
            else {
                HorizontalAlign(task, "toRight", previousTask);
                task.setLocation(task.getX(), task.getY() + 30);
            }
            previousTask = task;
            taskList.add(task);
        }
    }
    public static ArrayList<JLabel> getTasks() {
        return taskList;
    }

    public static Dimension getSize() {
        return size;
    }

    private static JLabel newTaskLabel(String number) {
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

    private static JLabel setTempTask() {
        JLabel label = newTaskLabel("temp");
        VerticalAlign(label, "top");
        HorizontalAlign(label, "left");
        label.setLocation(label.getX() + 200, label.getY() + 30);
        return label;
    }
    public static JLabel getTempTask() {
        return tempTask;
    }
}
