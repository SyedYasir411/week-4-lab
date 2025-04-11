import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Checked_Exception {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\vcher\\IdeaProjects\\Week5\\Exception_Handling\\src\\data.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            System.out.println("Contents of the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File not found");
        }

        System.out.println("Program ended.");
    }
}
