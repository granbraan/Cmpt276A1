package Model;

public class DOFCalculator {


    public static double hyperfocalDistance(int focalLength, double aperture, double circleOfConfusion)
    {
        double focal = Math.pow(focalLength,2);
        return focal/(aperture*circleOfConfusion);
    }

    public static double nearFocalPoint(int focalLength, double aperture, double circleOfConfusion, double distance)
    {
        double hyperFocal = hyperfocalDistance(focalLength, aperture, circleOfConfusion);
        return  (hyperFocal * (distance*1000)) / (hyperFocal + ((distance*1000) - focalLength));
    }

    public static double farFocalPoint(int focalLength, double aperture, double circleOfConfusion, double  distance)
    {
        double hyperFocal = hyperfocalDistance(focalLength, aperture, circleOfConfusion);
        return (hyperFocal * (distance*1000)) / (hyperFocal - ((distance*1000) - focalLength));
    }

    public static double depthOfField(int focalLength, double aperture, double circleOfConfusion, double distance)
    {
        double farFocal = farFocalPoint(focalLength, aperture, circleOfConfusion, distance);
        double nearFocal = nearFocalPoint(focalLength, aperture, circleOfConfusion, distance);
        return farFocal - nearFocal;
    }
}
