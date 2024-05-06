import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JFrame fr = new JFrame();

    Color clr2 = new Color(0, 236, 255);

    Cursor cr = new Cursor(Cursor.HAND_CURSOR);

    Font fh = new Font("Trebuchet MS", Font.BOLD, 30);
    Font fl = new Font("Trebuchet MS", Font.BOLD, 14);

    JLabel background; // JLabel to hold the background image

    JButton btn = new JButton();
    JButton btn1 = new JButton();
    JButton btn2 = new JButton();

    public Home() {
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(467, 50, 800, 700);
        fr.setTitle("Main Portal");
        fr.setResizable(false);

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("bg.jpg");
        background = new JLabel(backgroundImage);
        background.setLayout(new BorderLayout());

        // Set layout for JPanel
        JPanel panel = new JPanel();
        panel.setOpaque(false); // Make the panel transparent
        panel.setLayout(null);

        JLabel lbl1 = new JLabel("Welcome to BMS Portal!");
        lbl1.setFont(fh);
        lbl1.setForeground(Color.BLACK);
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setBounds(100, 40, 350, 100);
        panel.add(lbl1);

        btn.setText("Admin Login");
        btn.setBackground(clr2);
        btn.setForeground(Color.BLACK);
        btn.setFont(fl);
        btn.setCursor(cr);
        btn.addActionListener(this);
        btn.setBounds(150, 195, 125, 50);
        panel.add(btn);

        btn1.setText("User Login");
        btn1.setBackground(clr2);
        btn1.setForeground(Color.BLACK);
        btn1.setFont(fl);
        btn1.setCursor(cr);
        btn1.addActionListener(this);
        btn1.setBounds(150, 295, 125, 50);
        panel.add(btn1);

        btn2.setText("User Sign Up");
        btn2.setBackground(clr2);
        btn2.setForeground(Color.BLACK);
        btn2.setFont(fl);
        btn2.setCursor(cr);
        btn2.addActionListener(this);
        btn2.setBounds(150, 395, 125, 50);
        panel.add(btn2);

        background.add(panel, BorderLayout.CENTER); // Add panel to the background label

        fr.add(background); // Adding JLabel with background image to JFrame

        fr.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        try {
            if (evt.getSource() == btn) {
                fr.dispose();
                new Admin();
            }

            if (evt.getSource() == btn1) {
                fr.dispose();
                User obbj = new User();
                obbj.usr();
            }

            if (evt.getSource() == btn2) {
                fr.dispose();
                new SignUp();
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
