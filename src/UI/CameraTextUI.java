package UI;

import Model.Lens;
import Model.LensManager;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Sample (incomplete) text UI to interact with the user.
 * You may change any part of this!
 */
public class CameraTextUI {
    private static final double COC = 0.029;    // "Circle of Confusion" for a "Full Frame" camera
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
        boolean isDone = false;
        while(!isDone)
        {
            System.out.println("Enter a number: (1= Display Lenses 2=Find Lens 3=Aperture 4= Distance to Subject");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.println("Current Lenses:\n" +
                            "  0. Canon 50mm F1.8\n" +
                            "  1. Tamron 90mm F2.8\n" +
                            "  2. Sigma 200mm F2.8\n" +
                            "  3. Nikon 200mm F4.0");
                    break;

                case 2:
                    System.out.println("Lenses to pick from:\n" +
                            "  0. Canon 50mm F1.8\n" +
                            "  1. Tamron 90mm F2.8\n" +
                            "  2. Sigma 200mm F2.8\n" +
                            "  3. Nikon 200mm F4.0");
                    in = new Scanner(System.in);
                    int option = in.nextInt();
                    for(Lens l: manager)
                    {
                        if(option == manager.getIndex(l));
                        {
                            System.out.println("Aperture [the F number]: \n" +
                                    "Distance to subject [m]: \n" +
                                    "  In focus: 1.08m to 1.12m [DoF = 0.05m]\n" +
                                    "  Hyperfocal point: 47.89m");
                        }
                    }
            }
        }



    }

    private String formatM(double distanceInM) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }
}

