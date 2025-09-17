public class Stress{
    private String type;
    private int level;
    private String symptoms;

    public Stress(int level, String symptoms, String type) {
        this.level = level;
        this.symptoms = symptoms;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}
