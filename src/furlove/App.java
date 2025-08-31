package furlove;

import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginGUI login = new LoginGUI();
                login.setExtendedState(JFrame.MAXIMIZED_BOTH);
                login.setVisible(true);

            }

        });

    }

}
