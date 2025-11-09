public class UserTester {
    public static void main(String[] args) {
        // Using superclass references for runtime polymorphism
        User u1 = new Student("Juan Dela Cruz", 19, "BSIT");
        User u2 = new Counselor("Dr. Maria Santos", 35, "Stress Management");

        SupportResource r1 = new Article("Coping with Stress", "An article about handling academic stress.", "Dr. Lopez");
        SupportResource r2 = new RelaxationTip("Breathing Exercise", "Practice deep breathing to relax.", 5);
        SupportResource r3 = new Helpline("Mental Health Hotline", "Available 24/7 for urgent support.", "1553");

        System.out.println("=== USERS (Runtime Polymorphism) ===");
        u1.displayInfo();  // Calls Student version
        System.out.println();
        u2.displayInfo();  // Calls Counselor version

        System.out.println("\n=== RESOURCES (Runtime Polymorphism) ===");
        r1.displayResource();  // Calls Article version
        System.out.println();
        r2.displayResource();  // Calls RelaxationTip version
        System.out.println();
        r3.displayResource();  // Calls Helpline version

        System.out.println("\n=== METHOD OVERLOADING (Compile-time Polymorphism) ===");
        u1.displayInfo("Student Information");
        r1.displayResource("Featured Article");
    }
}