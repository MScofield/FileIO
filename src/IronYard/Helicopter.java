package IronYard;

/**
 * Created by scofieldservices on 11/29/16.
 */
public class Helicopter {
    String make;
    String model;
    int year;
    boolean turbine;
    int passengerCapacity;

    public Helicopter(){

    }

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


}