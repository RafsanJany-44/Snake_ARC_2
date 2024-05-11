import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class RemoveRowsWindow extends JFrame {
    private JTextField pidField;
    private JTextField nameField;
    private JButton removeButton;
    private JButton backButton;

    public RemoveRowsWindow() {
        setTitle("Remove Rows");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(4, 2, 5, 5));

        JLabel pidLabel = new JLabel("P_id:");
        pidField = new JTextField();
        getContentPane().add(pidLabel);
        getContentPane().add(pidField);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        getContentPane().add(nameLabel);
        getContentPane().add(nameField);

        removeButton = new JButton("Remove Bookings");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pid = pidField.getText();
                String name = nameField.getText();
                if (!pid.isEmpty() && !name.isEmpty()) {
                    removeRows(pid, name);
                    JOptionPane.showMessageDialog(null, "Rows removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter both P_id and Name.");
                }
            }
        });
        getContentPane().add(removeButton);

        backButton = new JButton("Back to Admin Portal");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current RemoveRowsWindow frame
                new Admin1().adm(); // Show the Admin1 frame
            }
        });
        getContentPane().add(backButton);

        setVisible(true);
    }

    private void removeRows(String pid, String name) {
        try {
            File inputFile = new File("booking_data.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");
                if (!data[0].equals(pid) || !data[1].equals(name)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();

            
            Files.copy(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Delete the temporary file
            tempFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RemoveRowsWindow::new);
    }
}
