package TutorsHelper;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static TutorsHelper.Libs.*;
import static TutorsHelper.Task.getTempTask;

public class Student {
    private static ArrayList<JLabel> studentList = new ArrayList<>();
    private static JLabel tempStudent = setTempStudent();

    public static void setStudents() {
        // set students
        for (int i = 0; i < getStudentsList().size(); i++) {
            JLabel student = newStudentLabel((i+1) + ". " + getStudentsList().get(i));
            HorizontalAlign(student, "left");
            if (i == 0 ) {
                VerticalAlign(student, "top");
                student.setLocation(student.getX() + 100, student.getY() + 30 + Task.getSize().height);
            }
            else {
                VerticalAlign(student, "under", studentList.get(i - 1));
                student.setLocation(student.getX() + 100, student.getY());
            }
            studentList.add(student);
        }
    }
    public static ArrayList<JLabel> getStudents() {
        return studentList;
    }

    private static JLabel newStudentLabel(String name) {
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

    private static List<String> getStudentsList() {
        try {
            return Files.readAllLines(Paths.get("GroupMembers.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static JLabel setTempStudent() {
        JLabel label = newStudentLabel("temp");
        HorizontalAlign(label, "left");
        VerticalAlign(label, "top");
        label.setLocation(label.getX() + 100, label.getY() + 30 + getTempTask().getHeight());
        return label;
    }
    public static JLabel getTempStudent() {
        return tempStudent;
    }
}

