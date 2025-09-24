class User {
    protected String name;
    protected int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Student extends User {
    private String course;

    public Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Student, Course: " + course);
    }
}

class Counselor extends User {
    private String specialization;

    public Counselor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Counselor, Specialization: " + specialization);
    }
}

// ========== RESOURCE CLASSES ==========
class SupportResource {
    protected String title;
    protected String description;

    public SupportResource(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void displayResource() {
        System.out.println("Resource: " + title + "\n" + description);
    }
}

class Article extends SupportResource {
    private String author;

    public Article(String title, String description, String author) {
        super(title, description);
        this.author = author;
    }

    @Override
    public void displayResource() {
        super.displayResource();
        System.out.println("Author: " + author);
    }
}

class RelaxationTip extends SupportResource {
    private int duration; // in minutes

    public RelaxationTip(String title, String description, int duration) {
        super(title, description);
        this.duration = duration;
    }

    @Override
    public void displayResource() {
        super.displayResource();
        System.out.println("Suggested Duration: " + duration + " minutes");
    }
}

class Helpline extends SupportResource {
    private String contactNumber;

    public Helpline(String title, String description, String contactNumber) {
        super(title, description);
        this.contactNumber = contactNumber;
    }

    @Override
    public void displayResource() {
        super.displayResource();
        System.out.println("Contact Number: " + contactNumber);
    }
}