import java.util.regex.*;
public class Username {
    public static void main(String[] args){
        String text = "UserName_123";
        String patternString = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher match = pattern.matcher(text);

        if(match.find()){
            System.out.println(match.group());
        }else{
            System.out.println("Invalid_Format");
        }
    }
}