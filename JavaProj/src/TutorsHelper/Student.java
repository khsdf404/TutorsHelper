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
    public static ArrayList<JLabel> getStudents() {
        return studentList;
    }
    private static List<String> getConfig() {
        try {
            return Files.readAllLines(Paths.get("GroupMembers.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setStudents() {
        List<String> studentConfig = getConfig();
        for (int i = 0; i < studentConfig.size(); i++) {
            JLabel student = newStudentLabel("  " + (i+1) + ". " + studentConfig.get(i));
            HorizontalAlign(student, "left");
            if (i == 0 ) {
                VerticalAlign(student, "under", UpdateButton.getBtn());
                student.setLocation(student.getX() + 100, student.getY());
            }
            else {
                VerticalAlign(student, "under", studentList.get(i - 1));
                student.setLocation(student.getX() + 100, student.getY());
            }
            studentList.add(student);
        }
    }


    private static JLabel newStudentLabel(String name) {
        JLabel label = new JLabel(name, SwingConstants.LEFT);
        label.setSize(200, 22);
        label.setBackground(studentColor);
        label.setForeground(Color.decode("#000000"));
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setFont(new Font("Arial", 0, 14));
        Window.components.add(label);
        return label;
    }

}

