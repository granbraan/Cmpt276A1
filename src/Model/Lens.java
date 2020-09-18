package Model;

public class Lens {
    String make;
    double maxAperture;
    int focalLength;

    public Lens(String make, double maxAperture, int focalLength) {
        this.make = make;
        this.maxAperture = maxAperture;
        this.focalLength = focalLength;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }
}
