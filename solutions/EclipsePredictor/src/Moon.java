public class Moon extends CelestialBody {
    private Earth earth;

    public Moon(Earth earth, int orbitRadius, double orbitalSpeed) {
        super("Moon", orbitRadius, orbitalSpeed);
        this.earth = earth;
    }

    @Override
    public int getX(int centerX) {
        int earthXRelativeToSun = earth.getX(centerX);
        double moonXRelativeToEarth = Math.cos(Math.toRadians(this.angle)) * this.orbitRadius;
        return earthXRelativeToSun + (int) moonXRelativeToEarth;
    }

    @Override
    public int getY(int centerY) {
        int earthYRelativeToSun = earth.getY(centerY);
        double moonYRelativeToEarth = Math.sin(Math.toRadians(this.angle)) * this.orbitRadius;
        return earthYRelativeToSun + (int) moonYRelativeToEarth;
    }


}