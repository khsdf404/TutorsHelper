package TutorsHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOError;
import java.util.ArrayList;

import static TutorsHelper.Libs.*;

public class CheckboxMouseListener implements MouseListener {
        private final JButton checkbox;
        private int col, row;
        private JLabel xLineLeft, xLineRight;
        private JLabel yLineAbove, yLineUnder;

        public CheckboxMouseListener(JButton checkbox) {
                this.checkbox = checkbox;
        }

        public void mouseClicked(MouseEvent e) {
                checkbox.setBackground(
                        checkbox.getBackground() == checkBoxColor__false ?
                                checkBoxColor__true :
                                checkBoxColor__false
                );
                Checkbox.setConfig();
        }
        public void mouseEntered(MouseEvent e) {
                addLighting();
        }
        public void mouseExited(MouseEvent e) {
                removeLighting();
        }


        private void addLines() {
                int stepX = Checkbox.getSize().width;
                int stepY = Checkbox.getSize().height;
                int firstX = Checkbox.getCheckboxes().get(0).getX();
                int firstY = Checkbox.getCheckboxes().get(0).getY();
                Point firstPos = new Point(firstX, firstY);
                Point currPos = new Point(checkbox.getX(), checkbox.getY());
                int col = (int)((currPos.x - firstPos.x) / stepX);
                int row = (int)((currPos.y - firstPos.y) / stepY);


                xLineLeft = Checkbox.newLine(new Dimension(
                        col * checkbox.getWidth(),
                        checkbox.getHeight()));
                xLineRight = Checkbox.newLine(new Dimension(
                        (tasksAmount - col - 1) * checkbox.getWidth(),
                        checkbox.getHeight()));
                yLineAbove = Checkbox.newLine(new Dimension(
                        checkbox.getWidth(),
                        row * checkbox.getHeight()));
                yLineUnder = Checkbox.newLine(new Dimension(
                        checkbox.getWidth(),
                        (Student.getStudents().size() - row - 1) * checkbox.getHeight()));

                xLineLeft.setLocation(Checkbox.getCheckboxes().get(0).getX(), currPos.y);
                xLineRight.setLocation((currPos.x + stepX), currPos.y);
                yLineAbove.setLocation(currPos.x, Checkbox.getCheckboxes().get(0).getY());
                yLineUnder.setLocation(currPos.x, (currPos.y  + stepY));
        }
        private void removeLines() {
               /* Window.mainPanel.remove(xLineLeft);
                Window.mainPanel.remove(xLineRight);
                Window.mainPanel.remove(yLineAbove);
                Window.mainPanel.remove(yLineUnder);*/
        }
        private void addLighting() {
                int stepX = Checkbox.getSize().width;
                int stepY = Checkbox.getSize().height;
                int firstX = Checkbox.getCheckboxes().get(0).getX();
                int firstY = Checkbox.getCheckboxes().get(0).getY();
                Point firstPos = new Point(firstX, firstY);
                Point currPos = new Point(checkbox.getX(), checkbox.getY());
                col = (int)((currPos.x - firstPos.x) / stepX);
                row = (int)((currPos.y - firstPos.y) / stepY);

                Task.getTasks().get(col).setBackground(activeColor);
                Student.getStudents().get(row).setBackground(activeColor);
        }
        private void removeLighting() {
                Task.getTasks().get(col).setBackground(taskColor);
                Student.getStudents().get(row).setBackground(studentColor);
        }


        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {};
}

