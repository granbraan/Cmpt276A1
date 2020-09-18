package UI;

import Model.DOFCalculator;
import Model.Lens;
import Model.LensManager;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Sample (incomplete) text UI to interact with the user.
 * You may change any part of this!
 */
public class CameraTextUI {
    private static double distance = 0;
    private static final double COC = 0.029;    // "Circle of Confusion" for a "Full Frame" camera
    private static double aperture = 0;
    private LensManager manager;
    private Scanner in = new Scanner(System.in);// Read from keyboard


    public CameraTextUI(LensManager manager) {
        // Accept and store a reference to the lens manager (the model)
        // (this design is called "dependency injection")
        this.manager = manager;

        // Populate lenses (Make, max aperture (smallest supported F number), focal length [mm]):
        manager.add(new Lens("Canon", 1.8, 50));
        manager.add(new Lens("Tamron", 2.8, 90));
        manager.add(new Lens("Sigma", 2.8, 200));
        manager.add(new Lens("Nikon", 4, 200));
    }

    public void show() {
        {
            int option;
            do {
                System.out.println("Lenses to pick from: ");
                outputLenses();
                System.out.println("(-1 to exit)");
                in = new Scanner(System.in);
                option = in.nextInt();
                if(option > 3 || option < -1)
                {
                    System.out.println("ERROR: Invalid lens index.");
                }
                else
                {
                    for(Lens lenses: manager)
                    {
                        if(option == manager.getIndex(lenses))
                        {
                            System.out.print("Aperture [the F number]: ");
                            in = new Scanner(System.in);
                            aperture = in.nextDouble();

                            if(aperture < lenses.getMaxAperture())
                            {
                                System.out.println("ERROR: This aperture is not possible with this lens\n");
                            }
                            else
                            {
                                System.out.print("Distance to subject [m]: ");
                                in = new Scanner(System.in);
                                distance = in.nextDouble();

                                double near = DOFCalculator.nearFocalPoint(lenses.getFocalLength(), aperture, COC, distance);
                                double far = DOFCalculator.farFocalPoint(lenses.getFocalLength(), aperture, COC, distance);
                                String DoF = formatM((far-near)/1000);
                                String hyper = formatM((DOFCalculator.hyperfocalDistance(lenses.getFocalLength(),aperture, COC))/1000);

                                System.out.print("In focus: " + formatM(near/1000) + "m" + " to " + formatM(far/1000) + "m ");
                                System.out.print("[DoF = " + DoF + "m]\n");
                                System.out.println("Hyperfocal point: " + hyper + "m\n");
                            }
                        }
                    }
                }
            }while(option != -1);
        }
    }

    private String formatM(double distanceInM) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }

    private void outputLenses()
    {
        for(Lens lenses: manager)
        {
            System.out.println(manager.getIndex(lenses) + ". " + lenses.getMake() + " " + lenses.getFocalLength() + "mm" + " " + "F" + lenses.getMaxAperture());
        }
    }
}

