package TutorsHelper;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static TutorsHelper.Libs.*;

public class Grid {
    public Grid() {};
    static void setGrid() {
        UpdateButton.setBtn();
        Task.setTasks();
        Student.setStudents();
        Checkbox.setCheckboxes();

        // delete trash
        Window.components.remove(Task.getTempTask());
    }
}
