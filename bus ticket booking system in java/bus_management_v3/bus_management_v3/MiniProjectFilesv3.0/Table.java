import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Table extends JFrame {
    private JTable table;

    public Table() {
        setTitle("Booking Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 240, 240)); // Set background color of the JFrame using RGB values

        // Read data from the file and populate the table
        String filename = "booking_data.txt";
        DefaultTableModel model = readDataFromFile(filename);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(240, 240, 240)); // Set background color of the JTable using RGB values
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Create a new Color object with RGB values for the button color
        Color buttonColor = new Color(255, 100, 100); // Change RGB values as needed

        // Add a button to render Admin1 class
        JButton backButton = new JButton("Back to Admin Portal");
        backButton.setBackground(buttonColor); // Set button background color
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Table frame
                new Admin1().adm(); // Show the Admin1 frame
            }
        });
        getContentPane().add(backButton, BorderLayout.SOUTH);

        
        JButton removeButton = new JButton("Remove Booking");
        removeButton.setBackground(buttonColor); // Set button background color
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current Table frame
                dispose();
                new RemoveRowsWindow().setVisible(true);
            }
        });
        getContentPane().add(removeButton, BorderLayout.NORTH);

        setVisible(true);
    }

    // Read data from the file and return as a DefaultTableModel
    private DefaultTableModel readDataFromFile(String filename) {



                // Variable to hold the first element of the last row
                String firstElementOfLastRow = null;
        
                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
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
                    System.out.println("First element of the last row: " + firstElementOfLastRow);
                } else {
                    System.out.println("The file is empty or no valid entries were found.");
                }

        DefaultTableModel model = new DefaultTableModel();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // Read the header
            String headerLine = br.readLine();
            String[] columnNames = headerLine.split(",");
            model.setColumnIdentifiers(columnNames);

            // Read the data rows
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                model.addRow(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Table::new);
    }
}
