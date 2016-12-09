package IronYard;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        Helicopter h = new Helicopter();
        File f = new File("Helicopter.json");

        Scanner userInput = new Scanner(System.in);
        String exit;
        try {
            Scanner scan = new Scanner(f);
            JsonParser p = new JsonParser();
            scan.useDelimiter("\\Z");
            String contents = scan.next();
            h = p.parse(contents, Helicopter.class);
        } catch (Exception e){
            System.out.println("friendly error message: 'You have become void of empathy and are technically less human than my alarm clock.'");

        }
            System.out.println("This simple app stores the basic attributes for any Helicopter,");
            System.out.println("Your current Helicopter has the following attributes: ");
            System.out.printf("%d %s %s %d-passenger.\n", h.year, h.make, h.model, h.passengerCapacity);
            System.out.println("Press enter to update the Helicopter attributes or type exit to exit.");
            exit = userInput.nextLine();
            if (exit.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            System.out.println("Please begin by typing the the manufacurer name or make on the line below:");
            h.make = userInput.nextLine();
            System.out.printf("Thank you. Next please enter the model of your %s Helicopter on the line below:\n", h.make);
            h.model = userInput.nextLine();
            System.out.printf("Excellent. You have entered a %s, %s; that's one badd mutha.\n", h.make, h.model);
            System.out.printf("Let's get a couple more details about this Helicopter.\n");
            System.out.printf("On the line below please key the year of manufacture for the %s using numbers only:\n", h.model);
            h.year = userInput.nextInt();
            System.out.printf("%d is a very good year!\n", h.year);
            System.out.println("Just two more questions!!");
            System.out.printf("If your %d %s, %s is turbine powered please type true on the first empty line below:\n", h.year, h.make, h.model);
            System.out.println("If she's combustion, electric, hybrid, or thermo-nuclear-hybrid - please type false:");
            h.turbine = userInput.nextBoolean();
            System.out.println("Awesome! Sick ride yo!");
            System.out.println("Let's start hovering! How many people can we bring?");
            System.out.printf("Please key the total passenger capacity of the %d %s %s on the line below:\n", h.year, h.make, h.model);
            h.passengerCapacity = userInput.nextInt();
            System.out.printf("%d passengers!!??? That's killer!! So stinking excited!!\n", h.passengerCapacity);
            System.out.println("Let's Roll.");

            FileWriter fw = new FileWriter(f);
            JsonSerializer serial = new JsonSerializer();
            String json = serial.include("*").serialize(h);
            fw.write(json);
            fw.close();


    }
}


