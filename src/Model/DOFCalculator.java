package Model;

public class DOFCalculator {

    double hyperfocalDistance(int focalLength, double aperture, double circleOfConfusion)
    {
        double focal = Math.pow(focalLength,2);
        return focal/(aperture*circleOfConfusion);
    }

    double nearFocalPoint(int focalLength, double aperture, double circleOfConfusion, int distance)
    {
        double hyperFocal = hyperfocalDistance(focalLength, aperture, circleOfConfusion);
        return (hyperFocal * distance)/ (hyperFocal + (distance - focalLength));
    }

    double farFocalPoint(int focalLength, double aperture, double circleOfConfusion, int distance)
    {
        double hyperFocal = hyperfocalDistance(focalLength, aperture, circleOfConfusion);
        return (hyperFocal * distance)/ (hyperFocal - (distance - focalLength));
    }

    double depthOfField(int focalLength, double aperture, double circleOfConfusion, int distance)
    {
        double farFocal = farFocalPoint(focalLength, aperture, circleOfConfusion, distance);
        double nearFocal = nearFocalPoint(focalLength, aperture, circleOfConfusion, distance);
        return farFocal - nearFocal;
    }
}
