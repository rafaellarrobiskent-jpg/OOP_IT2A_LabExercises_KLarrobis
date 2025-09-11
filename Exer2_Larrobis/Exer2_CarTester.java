public class Exer2_CarTester {

    public static void main(String[] args) {
        // Car 1 (default constructor)
        Car car1 = new Car();

        // Car 2 (parameterized constructor)
        Car car2 = new Car("Red", "ABC-1234", "CHS-001");

        // Car 3 (parameterized constructor)
        Car car3 = new Car("Blue", "XYZ-5678", "CHS-002");

        // Display all cars
        car1.displayInfo();
        System.out.println("---------------");
        car2.displayInfo();
        System.out.println("---------------");
        car3.displayInfo();
    }
}