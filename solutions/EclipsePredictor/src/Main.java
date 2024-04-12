import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        SimulationFrame frame = new SimulationFrame(); // Create the frame as defined previously
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // Fit the frame around the contents
        frame.setVisible(true); // Make the frame visible
        frame.setResizable(false); // Optional: make the window non-resizable
    }
}
