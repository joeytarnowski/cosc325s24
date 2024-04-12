import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends JPanel {
    private CelestialBody sun, earth, moon;
    private int days = 0;

    public SimulationPanel() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.BLACK);
        sun = new Sun(0, 0);
        earth = new Earth(200, 360 / 365.25);
        moon = new Moon((Earth) earth, 50, 360 / 27.3);
    }


    public void stepSimulation(int direction) {
        earth.move(direction);
        moon.move(direction);
        days += direction;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Draw the Sun
        g.setColor(Color.YELLOW);
        g.fillOval(centerX - 15, centerY - 15, 30, 30);

        // Calculate Earth position
        int earthX = earth.getX(centerX);
        int earthY = earth.getY(centerY);

        // Draw the Earth
        g.setColor(Color.BLUE);
        g.fillOval(earthX - 10, earthY - 10, 20, 20);

        // Calculate Moon position relative to Earth
        int moonX = moon.getX(centerX);
        int moonY = moon.getY(centerY);

        // Draw the Moon
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(moonX - 5, moonY - 5, 10, 10);
    }


    public int getDays() {
        return days;
    }
}

