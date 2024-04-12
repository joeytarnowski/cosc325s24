public abstract class CelestialBody {
    protected String name;
    protected double angle;  // Current angle in degrees
    protected int orbitRadius;
    protected double orbitalSpeed;  // Degrees per day

    public CelestialBody(String name, int orbitRadius, double orbitalSpeed) {
        this.name = name;
        this.orbitRadius = orbitRadius;
        this.orbitalSpeed = orbitalSpeed;
        this.angle = 0;  // Initialize at angle 0
    }

    public void move(int direction) {
        this.angle = (this.angle + direction * this.orbitalSpeed) % 360;
        if (this.angle < 0) this.angle += 360; // Correct negative angles
    }


    public int getX(int centerX) {
        return centerX + (int) (Math.cos(Math.toRadians(this.angle)) * this.orbitRadius);
    }

    public int getY(int centerY) {
        return centerY + (int) (Math.sin(Math.toRadians(this.angle)) * this.orbitRadius);
    }
    public double getAngle() {
        return this.angle;
    }

    // Method to calculate the angular distance between two celestial bodies
    public static double angularDistance(CelestialBody b1, CelestialBody b2) {
        double angle1 = b1.getAngle();
        double angle2 = b2.getAngle();
        double distance = Math.abs(angle2 - angle1) % 360;
        distance = distance > 180 ? 360 - distance : distance;
        return distance;
    }

}
