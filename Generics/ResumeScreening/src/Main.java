import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    String candidateName;

    JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    abstract void displayResume();
}

class SoftwareEngineer extends JobRole {
    String primaryLanguage;

    SoftwareEngineer(String candidateName, String primaryLanguage) {
        super(candidateName);
        this.primaryLanguage = primaryLanguage;
    }

    @Override
    public void displayResume() {
        System.out.println("Software Engineer Resume - Name: " + candidateName + ", Language: " + primaryLanguage);
    }
}

class DataScientist extends JobRole {
    String tool;

    DataScientist(String candidateName, String tool) {
        super(candidateName);
        this.tool = tool;
    }

    @Override
    public void displayResume() {
        System.out.println("Data Scientist Resume - Name: " + candidateName + ", Tool: " + tool);
    }
}

class ProductManager extends JobRole {
    int yearsOfExperience;

    ProductManager(String candidateName, int yearsOfExperience) {
        super(candidateName);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void displayResume() {
        System.out.println("Product Manager Resume - Name: " + candidateName + ", Experience: " + yearsOfExperience + " years");
    }
}

class Resume<T extends JobRole> {
    List<T> resumes = new ArrayList<>();

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public List<T> getResumes() {
        return resumes;
    }
}

class ResumeProcessor {
    public static void screenResumes(List<? extends JobRole> resumes) {
        System.out.println("\n Screening Resumes ");
        for (JobRole resume : resumes) {
            resume.displayResume();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResumes = new Resume<>();
        seResumes.addResume(new SoftwareEngineer("Alice", "Java"));
        seResumes.addResume(new SoftwareEngineer("Bob", "Python"));

        Resume<DataScientist> dsResumes = new Resume<>();
        dsResumes.addResume(new DataScientist("Charlie", "TensorFlow"));
        dsResumes.addResume(new DataScientist("Diana", "Pandas"));

        Resume<ProductManager> pmResumes = new Resume<>();
        pmResumes.addResume(new ProductManager("Eve", 5));
        pmResumes.addResume(new ProductManager("Frank", 7));

        // Screen each type
        ResumeProcessor.screenResumes(seResumes.getResumes());
        ResumeProcessor.screenResumes(dsResumes.getResumes());
        ResumeProcessor.screenResumes(pmResumes.getResumes());
    }
}
