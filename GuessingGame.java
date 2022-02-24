import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.util.Random;

public class GuessingGame {
    private JFrame frame;
    private JPanel panel;
    private JButton guessButton;
    private JTextField guessField;

    private final int answer;

    public GuessingGame() {
        answer = new Random().nextInt(0, 100);
        guessButton.addActionListener(event -> {
            int guess;

            try {
                guess = Integer.parseInt(guessField.getText());
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(frame, "You entered a value that is not a number. Please enter a number.", "Guessing Game", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (guess < answer) JOptionPane.showMessageDialog(frame, "It's higher!", "Guessing Game", JOptionPane.INFORMATION_MESSAGE);
            else if (guess > answer) JOptionPane.showMessageDialog(frame, "It's lower!", "Guessing Game", JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(frame, "Well done! It's correct!", "Guessing Game", JOptionPane.INFORMATION_MESSAGE);
        });

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        }

        frame = new JFrame("Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(853, 480);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) { new GuessingGame(); }
}