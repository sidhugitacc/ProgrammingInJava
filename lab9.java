import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab9 {

    private JFrame frame;
    private JTextField domainNameField;
    private JTextField parkingCostField;
    private JTextArea receiptArea;
    private double totalParkingCost;

    public lab9() {
        initialize();
        totalParkingCost = 0.0; // Initialize total parking cost
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Domain Parking System");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblDomainName = new JLabel("Vehicle :");
        lblDomainName.setBounds(30, 30, 100, 20);
        frame.getContentPane().add(lblDomainName);

        domainNameField = new JTextField();
        domainNameField.setBounds(140, 30, 150, 20);
        frame.getContentPane().add(domainNameField);
        domainNameField.setColumns(10);

        JLabel lblParkingCost = new JLabel("Parking Cost:");
        lblParkingCost.setBounds(30, 60, 100, 20);
        frame.getContentPane().add(lblParkingCost);

        parkingCostField = new JTextField();
        parkingCostField.setBounds(140, 60, 150, 20);
        frame.getContentPane().add(parkingCostField);
        parkingCostField.setColumns(10);

        JButton btnParkDomain = new JButton("Print Bill");
        btnParkDomain.setBounds(30, 100, 120, 30);
        frame.getContentPane().add(btnParkDomain);

        receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setBounds(30, 150, 400, 150);
        frame.getContentPane().add(receiptArea);

        btnParkDomain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parkDomain();
            }
        });
    }

    private void parkDomain() {
        String domainName = domainNameField.getText();
        String parkingCostStr = parkingCostField.getText();

        if (!domainName.isEmpty() && !parkingCostStr.isEmpty()) {
            double parkingCost = Double.parseDouble(parkingCostStr);

            // Display parked domain in the receipt area
            String domainInfo = "Vehicle " + domainName + "\tParking Cost: $" + parkingCost + "\n";
            receiptArea.append(domainInfo);

            // Update total parking cost
            totalParkingCost += parkingCost;

            // Display total parking cost in the receipt area
            receiptArea.append("Total Parking Cost: $" + totalParkingCost + "\n");

            // Clear input fields after parking the domain
            domainNameField.setText("");
            parkingCostField.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Please enter domain details.");
        }
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    lab9 window = new lab9();
                    window.display();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
