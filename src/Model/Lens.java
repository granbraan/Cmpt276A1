package Model;

public class Lens {
    String make;
    float maxAperture;
    int focalLength;

    public Lens(String make, float maxAperture, int focalLength) {
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

    public float getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(float maxAperture) {
        this.maxAperture = maxAperture;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }
}
