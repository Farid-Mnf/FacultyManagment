package facultymngmnt;

public class Doctor {
    private String name;
    private int id;
    private double salary;
    private String dept;

    public Doctor(String name, int id, double salary, String dept) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public String getDept() {
        return dept;
    }
}
