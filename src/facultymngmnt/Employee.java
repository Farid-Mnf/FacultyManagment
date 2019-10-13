package facultymngmnt;

public class Employee {
    private String name;
    private double salary;
    private int id;
    private String position;

    public Employee(String name, double salary, int id, String position) {
        this.name = name;
        this.salary = salary;
        this.id = id;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }
}
