import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Admin implements ActionListener {
    JFrame fr = new JFrame();
    Color clr1 = new Color(218, 247, 166); // Background color
    Color clr2 = new Color(141, 212, 145); // Login button color
    JTextField txt1 = new JTextField();
    JPasswordField pass = new JPasswordField();
    JLabel lbl = new JLabel();
    JLabel lbl1 = new JLabel();
    JLabel lbl2 = new JLabel();
    JButton btn = new JButton();
    Cursor cr = new Cursor(Cursor.HAND_CURSOR);
    Font fh = new Font("Trebuchet MS", Font.BOLD, 20);
    Font fs = new Font("Trebuchet MS", Font.BOLD, 13);
    JPanel panel = new JPanel(); // Using JPanel

    public Admin() {
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(430, 120, 425, 375);
        fr.setTitle("Administrator Login");
        fr.setResizable(false);

        panel.setBackground(clr1);
        panel.setLayout(null);

        txt1.setBounds(192, 127, 160, 30);
        txt1.setFont(fs);
        txt1.setForeground(Color.BLACK);

        pass.setBounds(192, 188, 160, 30);
        pass.setFont(fs);
        pass.setEchoChar('*');
        pass.setForeground(Color.BLACK);

        lbl.setBounds(30, 32, 350, 50);
        lbl.setText("Administrator Login");
        lbl.setFont(fh);
        lbl.setForeground(Color.BLACK);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);

        lbl1.setBounds(43, 130, 110, 25);
        lbl1.setText("Admin Username:");
        lbl1.setForeground(Color.BLACK);
        lbl1.setFont(fs);
        lbl1.setHorizontalAlignment(SwingConstants.RIGHT);

        lbl2.setBounds(43, 192, 110, 25);
        lbl2.setText("Password:");
        lbl2.setForeground(Color.BLACK);
        lbl2.setFont(fs);
        lbl2.setHorizontalAlignment(SwingConstants.RIGHT);

        btn.setBounds(155, 270, 100, 28);
        btn.setText("Log In");
        btn.setBackground(clr2);
        btn.setForeground(Color.BLACK);
        btn.setCursor(cr);
        btn.addActionListener(this);

        panel.add(lbl);
        panel.add(lbl1);
        panel.add(lbl2);
        panel.add(btn);
        panel.add(txt1);
        panel.add(pass);
        fr.add(panel); // Adding panel to the JFrame
        fr.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        try {
            if (evt.getSource() == btn) {
                System.out.println("log in button pressed");
                String providedAdminName, providedPassword;
                providedAdminName = txt1.getText();
                providedPassword = pass.getText();

                System.out.println(providedAdminName);
                System.out.println(providedPassword);

                String txtFile = "Admin_Log.txt"; // Changed to .txt
                boolean found = false;

                try (BufferedReader reader = new BufferedReader(new FileReader(txtFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] columns = line.split(","); // Assuming the format is similar to CSV
                        if (columns.length >= 2) {
                            String adminName = columns[0].trim();
                            String pass = columns[1].trim();
    
                            if (adminName.equals(providedAdminName) && pass.equals(providedPassword)) {
                                found = true;
                                break;
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (found) {
                    System.out.println("Admin credentials matched.");
                    Admin1 obj = new Admin1();
                    obj.adm(); // Assuming Admin1 and adm() are correctly defined
                    
                } else {
                    System.out.println("No matching admin name found. Access Denied!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
