package furlove;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIHelper {

    public static void styleComponents(Container container) {

        String fontName = "Swis721 Lt BT";
        String headingFontName = "Imprint MT Shadow";
        String titleFontName = "Segoe UI";
        for (Component comp : container.getComponents()) {

            Font currentFont = comp.getFont();
            if (currentFont != null) {

                comp.setFont(new Font(fontName, currentFont.getStyle(), currentFont.getSize()));

                String fontToUse = (currentFont.getSize() >= 24) ? headingFontName : fontName;
                comp.setFont(new Font(fontToUse, currentFont.getStyle(), currentFont.getSize()));

                if (currentFont.getSize() == 18) {
                    comp.setFont(new Font(titleFontName, Font.BOLD, 18));
                }

            }

            if (comp instanceof JButton jButton) {
                comp.setBackground(Color.WHITE);
                jButton.setFocusPainted(false);

                jButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent evt) {
                        jButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }

                    @Override
                    public void mouseExited(MouseEvent evt) {
                        jButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                });
            }

            if (comp instanceof JComboBox jComboBox) {
                jComboBox.setBackground(Color.WHITE);
            }

            if (comp instanceof Container subContainer) {
                styleComponents(subContainer);
            }
        }
    }
}
