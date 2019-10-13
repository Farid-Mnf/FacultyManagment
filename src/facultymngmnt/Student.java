package facultymngmnt;

public class Student {
    private int id;
    private String name;
    private String dept;
    private double grade;

    public Student(int id, String name, String dept, double grade) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public double getGrade() {
        return grade;
    }
}
