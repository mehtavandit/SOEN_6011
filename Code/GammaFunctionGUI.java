/**
 * This package contains the GUI application for calculating the Gamma function
 * using Euler's method.
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * A GUI application for calculating the Gamma function using Euler's method.
 */
public final class GammaFunctionGUI {

    /**
     * Width of the welcome frame in pixels.
     */
    private static final int WELCOME_FRAME_WIDTH = 400;

    /**
     * Height of the welcome frame in pixels.
     */
    private static final int WELCOME_FRAME_HEIGHT = 200;

    /**
     * Width of the main frame in pixels.
     */
    private static final int MAIN_FRAME_WIDTH = 600;

    /**
     * Height of the main frame in pixels.
     */
    private static final int MAIN_FRAME_HEIGHT = 400;

    /**
     * Padding size for borders in pixels.
     */
    private static final int BORDER_PADDING = 20;

    /**
     * Font size for labels in points.
     */
    private static final int LABEL_FONT_SIZE = 16;

    /**
     * Number of rows in the result display area.
     */
    private static final int RESULT_AREA_ROWS = 10;

    /**
     * Number of columns in the result display area.
     */
    private static final int RESULT_AREA_COLUMNS = 30;

    /**
     * Number of columns in the text field.
     */
    private static final int TEXT_FIELD_COLUMNS = 20;

    /**
     * Color for the welcome button background.
     */
    private static final Color WELCOME_BUTTON_COLOR = new Color(70, 130, 180);

    /**
     * Color for the close button background.
     */
    private static final Color CLOSE_BUTTON_COLOR = new Color(178, 34, 34);

    /**
     * Background color for the panel.
     */
    private static final Color PANEL_BACKGROUND_COLOR = new Color(
            245, 245, 245
    );

    /**
     * Font size for the title label in points.
     */
    private static final int LABEL_TITLE_FONT_SIZE = 18;

    /**
     * Maximum number of iterations for the gamma function calculation.
     */
    private static final int MAX_ITERATIONS = 10000;

    /**
     * Size of insets in the grid bag layout.
     */
    private static final int INSETS_SIZE = 10;

    /**
     * Private constructor to prevent instantiation.
     */
    private GammaFunctionGUI() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated"
        );
    }


    /**
     * Calculates the Gamma function using Euler's method.
     *
     * @param x the value to calculate the Gamma function for
     * @return the calculated Gamma function value
     * @throws IllegalArgumentException if x is less than or equal to 0
     */
    public static double gamma(final double x) {
        if (x <= 0.0) {
            throw new IllegalArgumentException(
                    "Gamma function is not defined for non-positive numbers.");
        }

        double term;
        double product = 1.0;
        double oneOverX = 1.0 / x;

        for (int n = 1; n <= MAX_ITERATIONS; n++) {
            term = Math.pow(1.0 + 1.0 / n, x) / (1.0 + x / n);
            product *= term;
        }

        return oneOverX * product;
    }

    /**
     * Main method to launch the Gamma function calculator GUI.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args) {
        JFrame welcomeFrame = new JFrame("Welcome");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(WELCOME_FRAME_WIDTH, WELCOME_FRAME_HEIGHT);
        welcomeFrame.setLocationRelativeTo(null);

        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(
                BORDER_PADDING,
                BORDER_PADDING,
                BORDER_PADDING,
                BORDER_PADDING
        ));


        JLabel welcomeLabel = new JLabel(
                "Welcome to Gamma Calculator", JLabel.CENTER);
        welcomeLabel.setFont(new Font(
                "Serif",
                Font.BOLD,
                LABEL_TITLE_FONT_SIZE
        ));

        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);

        JButton continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Serif", Font.PLAIN, LABEL_FONT_SIZE));
        continueButton.setBackground(WELCOME_BUTTON_COLOR);
        continueButton.setForeground(Color.WHITE);
        welcomePanel.add(continueButton, BorderLayout.SOUTH);

        welcomeFrame.add(welcomePanel);
        welcomeFrame.setVisible(true);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                welcomeFrame.dispose();
                createMainFrame();
            }
        });
    }

    /**
     * Creates and displays the main frame for the GUI.
     */
    private static void createMainFrame() {
        JFrame frame = new JFrame(
                "Gamma Function Calculator using Euler's Method");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(
                BORDER_PADDING,
                BORDER_PADDING,
                BORDER_PADDING,
                BORDER_PADDING
        ));

        panel.setBackground(PANEL_BACKGROUND_COLOR);
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    /**
     * Places the components on the panel for the Gamma function calculator GUI.
     *
     * @param panel the panel to place components on
     */
    private static void placeComponents(final JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(
                INSETS_SIZE,
                INSETS_SIZE,
                INSETS_SIZE,
                INSETS_SIZE
        );

        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = new JLabel("Enter a positive number:");
        userLabel.setFont(new Font("Serif", Font.PLAIN, LABEL_FONT_SIZE));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        JTextField userText = new JTextField(TEXT_FIELD_COLUMNS);
        userText.setFont(new Font("Serif", Font.PLAIN, LABEL_FONT_SIZE));
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userText, gbc);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Serif", Font.PLAIN, LABEL_FONT_SIZE));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(resultLabel, gbc);

        JTextArea resultArea = new JTextArea(
                RESULT_AREA_ROWS,
                RESULT_AREA_COLUMNS
        );

        resultArea.setFont(new Font("Serif", Font.PLAIN, LABEL_FONT_SIZE));
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(scrollPane, gbc);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Serif", Font.PLAIN, LABEL_FONT_SIZE));
        calculateButton.setBackground(WELCOME_BUTTON_COLOR);
        calculateButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(calculateButton, gbc);

        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Serif", Font.PLAIN, LABEL_FONT_SIZE));
        closeButton.setBackground(CLOSE_BUTTON_COLOR);
        closeButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(closeButton, gbc);

        ActionListener calculateAction = new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                String userInput = userText.getText();
                try {
                    double x = Double.parseDouble(userInput);
                    double gammaValue = gamma(x);
                    resultArea.setText("Gamma(" + x + ") = " + gammaValue);
                } catch (NumberFormatException ex) {
                    resultArea.setText(
                            "Invalid input. Please enter a valid number."
                    );

                } catch (IllegalArgumentException ex) {
                    resultArea.setText(ex.getMessage());
                }
            }
        };

        calculateButton.addActionListener(calculateAction);

        userText.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calculateAction.actionPerformed(null);
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
