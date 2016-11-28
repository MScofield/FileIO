package IronYard;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    static String make;
    static String model;
    static int year;
    static boolean turbine;
    static int passengerCapacity;
    static String exit;


    public Main() {
    }

    public static void main(String[] args) throws IOException {
        Helicopter h = new Helicopter(make,model,year,turbine,passengerCapacity);
        make = "Robinson";
        model = "R22";
        year = 1984;
        turbine = false;
        passengerCapacity = 2;

        File f = new File("Helicopter.json");
        do {
            exit = "never";

            FileWriter fw = new FileWriter(f);
            JsonSerializer serial = new JsonSerializer();
            Scanner scan = new Scanner(f);
            Scanner userInput = new Scanner(System.in);
            JsonParser p = new JsonParser();

            String json = serial.include("*").serialize(h);
            fw.write(json);
            fw.close();

            scan.useDelimiter("\\Z");
            String contents = scan.next();

            System.out.println("This simple app stores the basic attributes for any Helicopter,");
            System.out.println("Your current Helicopter has the following attributes: ");
            System.out.printf("%s\n", contents);
            System.out.println("Press enter to update the Helicopter attributes or type exit to exit.");
            exit = userInput.nextLine();
                if (exit.equalsIgnoreCase("exit")){
                    System.exit(0);
                }
            System.out.println("Please begin by typing the the manufacurer name or make on the line below:");
            make = userInput.nextLine();
            System.out.printf("Thank you. Next please enter the model of your %s Helicopter on the line below:\n", make);
            model = userInput.nextLine();
            System.out.printf("Excellent. You have entered a %s, %s; that's one badd mutha.\n", make, model);
            System.out.printf("Let's get a couple more details about this Helicopter.\n");
            System.out.printf("On the line below please key the year of manufacture for the %s using numbers only:\n", model);
            year = userInput.nextInt();
            System.out.printf("%d is a very good year!\n", year);
            System.out.println("Just two more questions!!");
            System.out.printf("If your %d %s, %s is turbine powered please type true on the first empty line below:\n", year, make, model);
            System.out.println("If she's combustion, electric, hybrid, or thermo-nuclear-hybrid - please type false:");
            turbine = userInput.nextBoolean();
            System.out.println("Awesome! Sick ride yo!");
            System.out.println("Let's start hovering! How many people can we bring?");
            System.out.printf("Please key the total passenger capacity of the %d %s %s on the line below:\n", year, make, model);
            passengerCapacity = userInput.nextInt();
            System.out.printf("%d passengers!!??? That's killer!! So stinking excited!!\n", passengerCapacity);
            System.out.println("Let's Roll.");

        }while (true);
    }
    public static class Helicopter extends Main {

        public Helicopter (String make, String model, int year, boolean turbine, int passengerCapacity){
            this.make = make;
            this.model = model;
            this.year = year;
            this.turbine = turbine;
            this.passengerCapacity = passengerCapacity;

        }
        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public boolean isTurbine() {
            return turbine;
        }

        public void setTurbine(boolean turbine) {
            this.turbine = turbine;
        }

        public int getPassengerCapacity() {
            return passengerCapacity;
        }

        public void setPassengerCapacity(int passengerCapacity) {
            this.passengerCapacity = passengerCapacity;
        }


}}


