import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationFrame extends JFrame implements ActionListener {
    private SimulationPanel panel;
    private JButton playButton, pauseButton, stepForwardButton, stepBackwardButton;
    private JLabel dayLabel;
    private Timer timer;

    public SimulationFrame() {
        setTitle("Orbital Simulation");
        setPreferredSize(new Dimension(850, 700));  // Adjust the preferred size as needed
        pack();  // Pack the frame components snugly within the frame
        setResizable(true);  // Allow resizing to see how components adjust
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new SimulationPanel();
        add(panel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        stepForwardButton = new JButton("Step Forward");
        stepBackwardButton = new JButton("Step Backward");
        dayLabel = new JLabel("Day: 0");

        playButton.addActionListener(this);
        pauseButton.addActionListener(this);
        stepForwardButton.addActionListener(this);
        stepBackwardButton.addActionListener(this);

        controlPanel.add(playButton);
        controlPanel.add(pauseButton);
        controlPanel.add(stepForwardButton);
        controlPanel.add(stepBackwardButton);
        controlPanel.add(dayLabel);

        add(controlPanel, BorderLayout.SOUTH);

        timer = new Timer(100, e -> stepForward());  // Simulate one day per second
    }

    private void stepForward() {
        panel.stepSimulation(1);
        updateDayLabel();
    }


    private void stepBackward() {
        panel.stepSimulation(-1);
        updateDayLabel();
    }

    private void updateDayLabel() {
        dayLabel.setText("Day: " + panel.getDays());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            timer.start();
        } else if (e.getSource() == pauseButton) {
            timer.stop();
        } else if (e.getSource() == stepForwardButton) {
            stepForward();
        } else if (e.getSource() == stepBackwardButton) {
            stepBackward();
        }
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimulationFrame frame = new SimulationFrame();
            frame.setVisible(true);
        });
    }
}
