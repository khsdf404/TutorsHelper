package TutorsHelper;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static TutorsHelper.Libs.*;

public class Grid {




    public Grid() {};
    static void setGrid() {
        // GroupMembers.txt
        List<String> studentLines;
        try {
            studentLines = Files.readAllLines(Paths.get("GroupMembers.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // GroupMembers.txt
        List<String> configLines;
        try {
            configLines = Files.readAllLines(Paths.get("TasksConfig.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // for grid settings
        JLabel tempTask = Elements.newTaskLabel("temp");
        VerticalAlign(tempTask, "top");
        HorizontalAlign(tempTask, "left");
        tempTask.setLocation(tempTask.getX() + 200, tempTask.getY() + 30);
        JLabel tempStudent = Elements.newStudentLabel("temp");
        HorizontalAlign(tempStudent, "left");
        VerticalAlign(tempStudent, "top");
        tempStudent.setLocation(tempStudent.getX() + 100, tempStudent.getY() + 30 + tempTask.getHeight());


        // set tasks
        JLabel previousTask = new JLabel("");
        for (int i = 0; i < tasksAmount; i++) {
            JLabel task = Elements.newTaskLabel("#" + Integer.toString(i + 1));
            VerticalAlign(task, "top");
            if (i == 0) {
                HorizontalAlign(task, "left");
                task.setLocation(task.getX() + tempStudent.getX() + tempStudent.getWidth(), task.getY() + 30);
            }
            else {
                HorizontalAlign(task, "toRight", previousTask);
                task.setLocation(task.getX(), task.getY() + 30);
            }
            previousTask = task;
            Tasks.add(task);
        }
        // set students
        for (int i = 0; i < studentLines.size(); i++) {
            JLabel student = Elements.newStudentLabel((i+1) + ". " + studentLines.get(i));
            HorizontalAlign(student, "left");
            if (i == 0 ) {
                VerticalAlign(student, "top");
                student.setLocation(student.getX() + 100, student.getY() + 30 + previousTask.getHeight());
            }
            else {
                VerticalAlign(student, "under", Students.get(i - 1));
                student.setLocation(student.getX() + 100, student.getY());
            }
            Students.add(student);
        }
        // set checkboxes
        for (int i = 0; i < Students.size(); i++) {
            JLabel currStudent = Students.get(i);
            int startX = currStudent.getX() + currStudent.getWidth();
            int yPos = currStudent.getY();
            for (int j = 0; j < tasksAmount; j++) {
                int xPos = startX + tempTask.getWidth() * j;
                JButton checkbox = Elements.newCheckbox();
                checkbox.setLocation(xPos, yPos);
                CheckBoxes.add(checkbox);
            }
        }
        Elements.ConfigureCheckboxes(CheckBoxes, configLines);



        // delete trash
        Window.components.remove(tempTask);
        Window.components.remove(tempStudent);
    }
}
