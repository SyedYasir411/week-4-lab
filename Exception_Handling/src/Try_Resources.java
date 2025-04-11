import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Try_Resources {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\vcher\\IdeaProjects\\Week5\\Exception_Handling\\src\\info.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
        System.out.println("Program ended.");
    }
}
