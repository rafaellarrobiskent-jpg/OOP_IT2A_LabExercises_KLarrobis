public class Car {
    private String color;
    private String plateNo;
    private String chassisNo;

    // Default constructor
    public Car() {
        this.color = "No Color";
        this.plateNo = "No Platenumber";
        this.chassisNo = "No chassis no yet";
    }

    // Parameterized constructor
    public Car(String color, String plateNo, String chassisNo) {
        this.color = color;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
    }

    // Display info method
    public void displayInfo() {
        String info = "";
        info += "Color: " + this.color;
        info += "\nPlateNo: " + this.plateNo;
        info += "\nChassisNo: " + this.chassisNo;
        System.out.println(info);
    }
}