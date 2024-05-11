import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class Booking implements ActionListener {
    JFrame frame = new JFrame();

    Color clr1 = new Color(211, 211, 211);
    Color clr2 = new Color(192, 192, 192);

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    Font headerFont = new Font("Trebuchet MS", Font.BOLD, 30);
    Font fieldFont = new Font("Trebuchet MS", Font.BOLD, 13);
    Font buttonFont = new Font("Trebuchet MS", Font.BOLD, 14);
    Font infoFont = new Font("Trebuchet MS", Font.ITALIC, 12);

    Container container = frame.getContentPane();

    JLabel headerLabel = new JLabel("Booking Form");

    JTextField txtP_id = new JTextField();
    JTextField txtName = new JTextField();
    JTextField txtSource = new JTextField();
    JTextField txtDestination = new JTextField();
    JTextField txtDay = new JTextField();
    JTextField txtMonth = new JTextField();
    JTextField txtSeats = new JTextField();

    JButton btnSubmit = new JButton("Submit");
    JButton btnClear = new JButton("Clear");

    public Booking() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(467, 50, 475, 500);
        frame.setTitle("Travel Booking");
        frame.setResizable(false);

        container.setBackground(clr1);
        container.setLayout(null);

        headerLabel.setBounds(57, 20, 350, 50);
        headerLabel.setText("Booking Details");
        headerLabel.setFont(headerFont);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(headerLabel);

        //setupLabelAndField(txtP_id, "P_id:", 80);
        setupLabelAndField(txtName, "Name:", 120);
        setupLabelAndField(txtSource, "Source:", 160);
        setupLabelAndField(txtDestination, "Destination:", 200);
        setupLabelAndField(txtDay, "Day:", 240);
        setupLabelAndField(txtMonth, "Month:", 280);
        setupLabelAndField(txtSeats, "Seats:", 320);

        setupButton(btnSubmit, 120, 380, "Submit");
        setupButton(btnClear, 275, 380, "Clear");

        frame.setVisible(true);
    }

    private void setupLabelAndField(JTextField textField, String labelText, int y) {
        JLabel label = new JLabel(labelText);
        label.setBounds(75, y, 130, 30);
        label.setFont(fieldFont);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(label);

        textField.setBounds(215, y, 185, 30);
        textField.setFont(fieldFont);
        container.add(textField);
    }

    private void setupButton(JButton button, int x, int y, String text) {
        button.setBounds(x, y, 100, 30);
        button.setText(text);
        button.setBackground(clr2);
        button.setForeground(Color.BLACK);
        button.setFont(buttonFont);
        button.setCursor(cursor);
        button.addActionListener(this);
        container.add(button);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnSubmit) {
            saveBookingData();
        } else if (evt.getSource() == btnClear) {
            txtP_id.setText("");
            txtName.setText("");
            txtSource.setText("");
            txtDestination.setText("");
            txtDay.setText("");
            txtMonth.setText("");
            txtSeats.setText("");
        }
    }

    private void saveBookingData() {

        // Variable to hold the first element of the last row
        String firstElementOfLastRow = null;
        String p_id;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("booking_data.txt"))) {
            String line;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split each line into parts using the comma as the delimiter
                String[] data = line.split(",");
                // Update the first element of the last row on each read
                if (data.length > 0) {
                    firstElementOfLastRow = data[0];

                }
            }
        } catch (IOException e) {
            // Handle possible IOExceptions
            e.printStackTrace();
        }

        // Print the first element of the last row, if it exists
        if (firstElementOfLastRow != null) {
            int number = Integer.parseInt(firstElementOfLastRow);
            int result = number + 1;
            p_id = Integer.toString(result);

        } else {
            p_id = "01";
        }

        try (FileWriter fw = new FileWriter("booking_data.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw)) {
            pw.println(p_id + "," + txtName.getText() + "," + txtSource.getText() + "," +
                    txtDestination.getText() + "," + txtDay.getText() + ", " + txtMonth.getText() + "," +
                    txtSeats.getText());
            JOptionPane.showMessageDialog(frame, "Booking saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving booking data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Booking();
    }
}
