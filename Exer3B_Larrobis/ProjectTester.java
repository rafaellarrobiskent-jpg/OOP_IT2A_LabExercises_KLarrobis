public class ProjectTester {
    public static void main(String[] args) {
        // Users
        Student s1 = new Student("Juan Dela Cruz", 19, "BSIT");
        Counselor c1 = new Counselor("Dr. Maria Santos", 35, "Stress Management");

        // Resources
        Article a1 = new Article("Coping with Stress", "An article about handling academic stress.", "Dr. Lopez");
        RelaxationTip tip1 = new RelaxationTip("Breathing Exercise", "Practice deep breathing to relax.", 5);
        Helpline h1 = new Helpline("Mental Health Hotline", "Available 24/7 for urgent support.", "1553");

        // Display info
        System.out.println("=== Users ===");
        s1.displayInfo();
        System.out.println();
        c1.displayInfo();

        System.out.println("\n=== Support Resources ===");
        a1.displayResource();
        System.out.println();
        tip1.displayResource();
        System.out.println();
        h1.displayResource();
    }
}