import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GammaFunctionGUI {

    public static double gamma(double x) {
        if (x <= 0.0) {
            throw new IllegalArgumentException("Gamma function is not defined for non-positive numbers.");
        }

        double term;
        double product = 1.0;
        double oneOverX = 1.0 / x;

        int maxIterations = 10000;

        for (int n = 1; n <= maxIterations; n++) {
            term = Math.pow(1.0 + 1.0 / n, x) / (1.0 + x / n);
            product *= term;
        }

        return oneOverX * product;
    }

    public static void main(String[] args) {
        // Create the welcome frame
        JFrame welcomeFrame = new JFrame("Welcome");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(400, 200);
        welcomeFrame.setLocationRelativeTo(null); // Center the frame

        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel welcomeLabel = new JLabel("Welcome to Gamma Calculator", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 18));
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);

        JButton continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Serif", Font.PLAIN, 16));
        continueButton.setBackground(new Color(70, 130, 180));
        continueButton.setForeground(Color.WHITE);
        welcomePanel.add(continueButton, BorderLayout.SOUTH);

        welcomeFrame.add(welcomePanel);
        welcomeFrame.setVisible(true);

        // Action listener for the continue button
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeFrame.dispose(); // Close the welcome frame
                createMainFrame(); // Open the main frame
            }
        });
    }

    private static void createMainFrame() {
        // Create the main frame
        JFrame frame = new JFrame("Gamma Function Calculator using Euler's Method");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // Center the frame

        // Create the input panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 245));
        frame.add(panel);
        placeComponents(panel);

        // Display the frame
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label for input
        JLabel userLabel = new JLabel("Enter a positive number:");
        userLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        // Text field for input
        JTextField userText = new JTextField(20);
        userText.setFont(new Font("Serif", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userText, gbc);

        // Label for result
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(resultLabel, gbc);

        // Result display area with word wrap
        JTextArea resultArea = new JTextArea(10, 30); // Increased rows and columns for larger area
        resultArea.setFont(new Font("Serif", Font.PLAIN, 16));
        resultArea.setEditable(false);
        resultArea.setLineWrap(true); // Enable line wrapping
        resultArea.setWrapStyleWord(true); // Wrap on word boundaries
        JScrollPane scrollPane = new JScrollPane(resultArea);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH; // Allow the text area to expand
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(scrollPane, gbc);

        // Calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Serif", Font.PLAIN, 16));
        calculateButton.setBackground(new Color(70, 130, 180));
        calculateButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(calculateButton, gbc);

        // Close button
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Serif", Font.PLAIN, 16));
        closeButton.setBackground(new Color(178, 34, 34));
        closeButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(closeButton, gbc);

        // Define the action to be performed for calculation
        ActionListener calculateAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = userText.getText();
                try {
                    double x = Double.parseDouble(userInput);
                    double gammaValue = gamma(x);
                    resultArea.setText("Gamma(" + x + ") = " + gammaValue);
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid input. Please enter a valid number.");
                } catch (IllegalArgumentException ex) {
                    resultArea.setText(ex.getMessage());
                }
            }
        };

        // Add action listener to the calculate button
        calculateButton.addActionListener(calculateAction);

        // Add key listener to the text field for Enter key
        userText.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calculateAction.actionPerformed(null);
                }
            }
        });

        // Add action listener to the close button
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
