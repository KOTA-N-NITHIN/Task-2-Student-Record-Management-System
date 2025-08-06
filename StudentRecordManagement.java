import java.util.ArrayList;
import java.util.Scanner;
class StudentRecordManagement{
   static Scanner sc=new Scanner(System.in);
    static ArrayList<Student> studentList =new ArrayList<>();


    public static void main(String[] args) 
    {
        int choice;
        do
        {
            System.out.println("====Student Record Management====");
            System.out.println("1.Add student");
            System.out.println("2.view Student");
            System.out.println("3.Delete Student");
            System.out.println("4.update Student");
            System.out.println("5.Exit");
            System.out.println("enter an option");
            choice=sc.nextInt();

                switch (choice) 
                {
                    case 1 -> addstudent();
                    case 2 -> viewstudnet();
                    case 3 -> Deletestudent();
                    case 4 -> updatestudent();
                    case 5 -> System.out.println("exiting program");
                    default -> System.out.println("Invalid choice. Please select 1-5.");
                }
        } while(choice!=5);
        System.out.println("program exicted");


    }
    static void  addstudent(){
        String name;
        int id;
        double marks;
        System.out.println("enter student name");
        name=sc.next();
        System.out.println("enter student id");
        id=sc.nextInt();
        System.out.println("enter student marks");
        marks=sc.nextDouble();
        Student student =new Student(id,name,marks);
        studentList.add(student);
        System.out.println("Student added sucessfully");
    }
    public static void  viewstudnet(){
        if(studentList.isEmpty()){
            System.out.println("no student record found");
        }
        else{
            System.out.println("===student records===");
            for(Student s:studentList){
                System.out.println(s);
            }
        }
    }
    public static void Deletestudent(){
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        boolean removed = studentList.removeIf(s -> s.getId() == id);

        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }
    public static void updatestudent(){
            System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getId() == id) {
                sc.nextLine(); // Consume newline
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student record updated successfully.");
                found = true;
                break;
            }
    }
        if (!found) {
            System.out.println("Student ID not found.");
        }
}
}



class Student{
    private int id;
    private String name;
    private double  marks;
    
    public Student(int id, String name,double marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
    @Override
    public String toString(){
        return "ID: "+id+"  name:"+name+"  marks"+marks;
    }
    
    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getMarks() { return marks; }

    public void setMarks(double marks) { this.marks = marks; }
}