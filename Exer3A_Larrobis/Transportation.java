// Base Class
class Transportation {
    String name;
    int capacity;

    public Transportation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void move() {
        System.out.println(name + " is moving.");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Capacity: " + capacity);
    }
}

// Intermediate Classes
class AirTransport extends Transportation {
    public AirTransport(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void move() {
        System.out.println(name + " is flying in the air.");
    }
}

class LandTransport extends Transportation {
    public LandTransport(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void move() {
        System.out.println(name + " is traveling on land.");
    }
}

class WaterTransport extends Transportation {
    public WaterTransport(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void move() {
        System.out.println(name + " is sailing on water.");
    }
}

// AirTransport Subclasses
class Helicopter extends AirTransport {
    public Helicopter() {
        super("Helicopter", 5);
    }
}

class Airplane extends AirTransport {
    public Airplane() {
        super("Airplane", 180);
    }
}

class SpaceShuttle extends AirTransport {
    public SpaceShuttle() {
        super("Space Shuttle", 7);
    }
}

// LandTransport Subclasses
class Truck extends LandTransport {
    public Truck() {
        super("Truck", 3);
    }
}

class SUV extends LandTransport {
    public SUV() {
        super("SUV", 7);
    }
}

class Tricycle extends LandTransport {
    public Tricycle() {
        super("Tricycle", 3);
    }
}

class Motorcycle extends LandTransport {
    public Motorcycle() {
        super("Motorcycle", 2);
    }
}

class Kariton extends LandTransport {
    public Kariton() {
        super("Kariton", 1);
    }
}

// WaterTransport Subclasses
class Boat extends WaterTransport {
    public Boat() {
        super("Boat", 10);
    }
}

class Submarine extends WaterTransport {
    public Submarine() {
        super("Submarine", 50);
    }
}