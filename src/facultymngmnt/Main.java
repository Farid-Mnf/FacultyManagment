package facultymngmnt;

import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
        while(true){
            int choice = systemUsage();
            switch (choice){
                case 1:
                    showFileInfo("doctor.txt");
                    break;
                case 2:
                    showFileInfo("employees.txt");
                    break;
                case 3:
                    showFileInfo("students.txt");
                    break;
                case 4:
                    showFileInfo("course.txt");
                    break;
                case 5:
                    addNewCourse();
                    break;
                case 6:
                    Doctor doctor = addNewDoctor();
                    System.out.println("Doctor: "+doctor.getName()+"" +
                            " has been added successfully");
                    if(doctor==null){
                        return;
                    }
                    break;
                case 7:
                    Student student = addNewStudent();
                    System.out.println("Student: "+student.getName()+" has been added successfully");
                    break;
                case 8:
                    Employee employee = addNewEmployee();
                    System.out.println("Employee: "+employee.getName()+
                            " has been added successfully");
                    break;
                case 9:
                    System.out.println("Enter Employee name: ");
                    Scanner emp = new Scanner(System.in);
                    String name = emp.nextLine();
                    String result = search(name,"employees.txt");
                    System.out.println(result);
                    break;
                case 10:
                    System.out.println("Enter Student name: ");
                    Scanner stu = new Scanner(System.in);
                    String stuName = stu.nextLine();
                    String res = search(stuName,"students.txt");
                    System.out.println(res);
                    break;
                case 11:
                    System.out.println("Enter Course name: ");
                    Scanner course = new Scanner(System.in);
                    String coureName = course.nextLine();
                    String s = search(coureName,"course.txt");
                    System.out.println(s);
                    break;
                case 12:
                    System.out.println("Enter Doctor name: ");
                    Scanner in = new Scanner(System.in);
                    String doctorName = in.nextLine();
                    String doc = search(doctorName,"doctor.txt");
                    System.out.println(doc);
                    break;
                default:
                    return;
            }
        }
    }

    public static int systemUsage() {
        System.out.println("1-  Show doctors");
        System.out.println("2-  Show employees");
        System.out.println("3-  Show students");
        System.out.println("4-  Show courses");
        System.out.println("5-  add new course");
        System.out.println("6-  add new doctor");
        System.out.println("7-  add new student");
        System.out.println("8-  add new employee");
        System.out.println("9-  search for employee");
        System.out.println("10- search for Student");
        System.out.println("11- search for Course");
        System.out.println("12- search for Doctor");
        System.out.print("\n-->Enter your choice: $");
        Scanner choice = new Scanner(System.in);
        int getChoice = choice.nextInt();
        return getChoice;
    }
    public static String search(String arg,String fileName) throws IOException{
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.contains(arg)){
                return line;
            }
        }
        return "not found!";
    }
    public static Student addNewStudent() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Student id: ");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("Enter Student name: ");
        String name = in.nextLine();
        System.out.println("Enter Student Department: ");
        String dept = in.nextLine();
        System.out.println("Enter Student Grade: ");
        double grade = in.nextDouble();
        Student student = new Student(id,name,dept,grade);
        File file = new File("students.txt");
        FileWriter fileWriter = new FileWriter(file,true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(student.getId()+" "+student.getName()+" "+
                student.getGrade()+" "+student.getDept());
        printWriter.close();
        return student;
    }
    public static Employee addNewEmployee() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Employee id: ");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("Enter Employee name: ");
        String name = in.nextLine();
        System.out.println("Enter Employee Position: ");
        String position = in.nextLine();
        System.out.println("Enter Employee Salary: ");
        double salary = in.nextDouble();
        Employee employee = new Employee(name,salary,id,position);
        File file = new File("employees.txt");
        FileWriter fileWriter = new FileWriter(file,true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(employee.getId()+" "+employee.getName()+" "+
                employee.getSalary()+" "+employee.getPosition());
        printWriter.close();
        return employee;
    }

    public static Doctor addNewDoctor() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter doctor name: ");
        String name = in.nextLine();
        if(!findDoctor(name)){

            System.out.println("Enter doctor id: ");
            int doctorId = in.nextInt();
            System.out.println("Enter doctor salary: ");
            double salary = in.nextDouble();
            in.nextLine();
            System.out.println("Enter doctor department: ");
            String dept = in.next();
            Doctor newDoctor = new Doctor(name,doctorId,salary,dept);
            File file= new File("doctor.txt");
            FileWriter fileWriter = new FileWriter(file,true);
            PrintWriter doc = new PrintWriter(fileWriter);
            doc.println("Doctor name: "+newDoctor.getName()+
                    " Id: "+newDoctor.getId()+
                    " Salary: "+newDoctor.getSalary()+
                    " Dept: "+newDoctor.getDept());
            doc.close();
            return newDoctor;
        }else
        {
            System.out.println("Doctor: "+name+" already exist!");
            return null;
        }
    }
    public static boolean findDoctor(String docName) throws IOException{
        File file = new File("doctor.txt");
        Scanner docFile = new Scanner(file);
        while(docFile.hasNext()){
            String getter = docFile.next();
            if(getter.equals(docName))
                return true;
        }
        return false;
    }
    public static void showFileInfo(String fileName) throws IOException{
        File file = new File(fileName);
        Scanner docFile = new Scanner(file);
        while(docFile.hasNextLine()){
            String getter = docFile.nextLine();
            System.out.println(getter);
        }
    }
    public static Course addNewCourse() throws IOException {
        System.out.println("Enter course name: ");
        Scanner in = new Scanner(System.in);
        String courseName = in.nextLine();
        System.out.println("Enter course Description: ");
        String desc = in.nextLine();
        System.out.println("Enter course Id: ");
        int id = in.nextInt();
        Doctor doctor = addNewDoctor();
        if(doctor!=null){
            Course newCourse = new Course(courseName,desc,id,doctor);
            File file = new File("course.txt");
            FileWriter writer = new FileWriter(file,true);
            PrintWriter courseWriter = new PrintWriter(writer);
            courseWriter.println(newCourse.getId()+" "+
                    newCourse.getName()+" "+
                    newCourse.getDescription().replace(' ','.')+" "+
                    newCourse.getDoctor().getName());
            courseWriter.close();
            return newCourse;
        }
        return null;
    }
}
