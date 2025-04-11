import java.sql.SQLOutput;
import java.util.ArrayList;

abstract class CourseType{
    void display(){}
}

class ExamCouse extends CourseType{
    String category="Exam";
    String date;
    ExamCouse(String date){
        this.date = date;
    }

    @Override
    public void display(){
        System.out.println("category: "+category+" ,date: "+ date);
    }
}

class AssignmentCourse extends CourseType{
    String category = "Assignment";
    String date;
    AssignmentCourse(String date){
        this.date=date;
    }
    @Override
    public void display(){
        System.out.println("category: "+category+" ,date: "+ date);
    }
}

class ResearchCourse extends CourseType{
    String category = "Research";
    String date;
    ResearchCourse(String date){
        this.date = date;
    }
    @Override
    public void display(){
        System.out.println("category: "+category+" ,date: "+ date);
    }
}

class Course<T extends CourseType>{
    ArrayList<T> arr = new ArrayList<>();

    public void add_course(T course){
        arr.add(course);
    }

    public void display(){
        for(T course:arr){
            course.display();
        }
    }
}

public class Main{
    public static void main(String[] args){
        ExamCouse e1 = new ExamCouse("12-12-24");
        AssignmentCourse a1= new AssignmentCourse("23-4-25");
        ResearchCourse r1 = new ResearchCourse("12-3-25");
        Course<ExamCouse> examList = new Course<>();
        Course<AssignmentCourse> assignmentList = new Course<>();
        Course<ResearchCourse> researchList = new Course<>();

        examList.add_course(e1);
        assignmentList.add_course(a1);
        researchList.add_course(r1);
        System.out.println("Exam List:");
        examList.display();
        System.out.println("assignment list");
        assignmentList.display();
        System.out.println("research list");
        researchList.display();

    }
}