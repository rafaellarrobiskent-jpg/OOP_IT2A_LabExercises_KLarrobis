public class StressTester {
    public static void main(String[] args) {
        Stress s1 = new Stress(7, "Headache, Fatigue", "Work-related");
        Stress s2 = new Stress(4, "Anxiety, Restlessness", "Academic");
        Stress s3 = new Stress(6, "Muscle tension, Sleep disturbances", "Financial");

        System.out.println("Initial Stress Level: " + s1.getLevel());
        System.out.println("Initial Symptoms: " + s1.getSymptoms());
        System.out.println("Initial Type: " + s1.getType());
        s1.setLevel(5);
        s1.setSymptoms("Irritability, Difficulty concentrating");
        s1.setType("Personal");
        System.out.println("Modified Stress Level: " + s1.getLevel());
        System.out.println("Modified Symptoms: " + s1.getSymptoms());
        System.out.println("Modified Type: " + s1.getType());

        s2.setLevel(3);
        s2.setSymptoms("Nervousness, Sweating");
        s2.setType("Social");
        System.out.println("Stress Level of s2: " + s2.getLevel());
        System.out.println("Symptoms of s2: " + s2.getSymptoms());
        System.out.println("Type of s2: " + s2.getType());

        s3.setLevel(8);
        s3.setSymptoms("Overthinking, Headaches");
        s3.setType("Health-related");
        System.out.println("Stress Level of s3: " + s3.getLevel());
        System.out.println("Symptoms of s3: " + s3.getSymptoms());
        System.out.println("Type of s3: " + s3.getType());


    }
}