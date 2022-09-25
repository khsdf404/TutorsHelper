package TutorsHelper;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static TutorsHelper.Libs.*;
import static TutorsHelper.Checkbox.getCheckboxes;

public class UpdateCheckedMouseListener implements MouseListener {
    private final JLabel btn;

    public UpdateCheckedMouseListener(JLabel btn) {
        this.btn = btn;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        for (JButton checkbox: getCheckboxes()) {
            if (checkbox.getBackground() == checkBoxColor__waiting) {
                checkbox.setBackground(checkBoxColor__true);
            }
        }
        Checkbox.setConfig();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        btn.setBackground(updatedBtnColor);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        btn.setBackground(studentColor);
    }
}