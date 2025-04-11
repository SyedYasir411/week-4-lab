import java.io.*;
class Student {
    private int rollNumber;
    private String name;
    private double gpa;
    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}
public class DataStreams{
    public static void main(String[] args) {
        String filePath = "C:\\Users\\vcher\\IdeaProjects\\Week5\\IOStreams\\src\\student.txt";
        Student student1 = new Student(101, "sdvsdv", 8.4);
        Student student2 = new Student(102, "vsdvsv", 6.7);
        Student student3 = new Student(103, "vssvasv", 9.5);
        try {
            storeStudentDetails(filePath, student1, student2,student3);
            System.out.println("Student details stored successfully in "+filePath);
            getStudentDetails(filePath);
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
    public static void storeStudentDetails(String filePath, Student... students) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            for (Student student : students) {
                dos.writeInt(student.getRollNumber());
                dos.writeUTF(student.getName()); 
                dos.writeDouble(student.getGpa());
            }
        }
    }
    public static void getStudentDetails(String filePath) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            System.out.println("Student Details Retrieved:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        }
    }
}

