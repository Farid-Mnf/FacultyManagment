package facultymngmnt;

public class Course {
    private String name;
    private String description;
    private int id;
    private Doctor doctor;

    public Course(String name, String description, int id, Doctor doctor) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.doctor = doctor;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
