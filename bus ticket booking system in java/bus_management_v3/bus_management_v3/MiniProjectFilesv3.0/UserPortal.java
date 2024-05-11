import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserPortal implements ActionListener {
    JFrame fr = new JFrame();

    Color clr1 = new Color(218,247,166);
    Color clr2 = new Color(141,212,145);

    Cursor cr = new Cursor(Cursor.HAND_CURSOR);

    Font fh = new Font("Trebuchet MS", Font.BOLD, 30);
    Font fl = new Font("Trebuchet MS", Font.BOLD, 14);

    Container c = fr.getContentPane();

    JLabel lbl1 = new JLabel();

    JButton btn = new JButton();
    JButton btn1 = new JButton();
    JButton btn2 = new JButton();


    public void up() {
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(467,50,600,700); // Increased window size
        fr.setTitle("User Portal");
        fr.setResizable(false);

        c.setBackground(clr1);
        c.setLayout(null);

        lbl1.setBounds(57,40,500,100); // Increased label size
        lbl1.setText("User Portal");
        lbl1.setFont(fh);
        lbl1.setForeground(Color.BLACK);
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);

        btn.setBounds(200,195,200,50); // Increased button size
        btn.setText("Book Ticket");
        btn.setBackground(clr2);
        btn.setForeground(Color.BLACK);
        btn.setFont(fl);
        btn.setCursor(cr);
        btn.addActionListener(this);

        btn1.setBounds(200,295,200,50); // Increased button size
        btn1.setText("Log Out");
        btn1.setBackground(clr2);
        btn1.setForeground(Color.BLACK);
        btn1.setFont(fl);
        btn1.setCursor(cr);
        btn1.addActionListener(this);

        btn2.setBounds(200,395,200,50); // Increased button size
        btn2.setText("Log Out");
        btn2.setBackground(clr2);
        btn2.setForeground(Color.BLACK);
        btn2.setFont(fl);
        btn2.setCursor(cr);
        btn2.addActionListener(this);

        c.add(lbl1);
        c.add(btn);
        c.add(btn1);
        c.add(btn2);

        fr.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        try {
            if(evt.getSource() == btn) {
				fr.dispose();
                Booking u = new Booking();
                u.book();
            }

            if(evt.getSource() == btn1) {
                fr.dispose(); 
                new Home();
            }

            if(evt.getSource() == btn2) {
                // mock
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserPortal a = new UserPortal();
        a.up();
    }
}
