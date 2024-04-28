import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin1 {
    public void adm() {
        JFrame f = new JFrame("ADMIN PANEL");
        Color clr1 = new Color(218, 247, 166);
        f.setBounds(100, 100, 800, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); // Changed Container to JPanel
        panel.setBackground(clr1);
        panel.setLayout(null);

        JLabel label1 = new JLabel("ADMINISTRATION PAGE");
        label1.setBounds(200, 20, 700, 150);
        panel.add(label1);

        JButton bb2 = new JButton("ADD ROUTE");
        bb2.setBounds(100, 200, 500, 40);
        panel.add(bb2);

        Font f1 = new Font("Trebuchet MS", Font.BOLD, 30);
        label1.setFont(f1);
        Font f2 = new Font("Trebuchet MS", Font.BOLD, 20);
        f.add(panel); // Adding panel to the JFrame
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Admin1 a = new Admin1();
        a.adm();
    }
}
