import java.util.regex.*;
public class License {
    public static void main(String[] args){
        String text = "AB1234";
        String PatternString = "^[a-zA-Z]{2}[0-9]{4}";
        Pattern pattern = Pattern.compile(PatternString);
        Matcher match = pattern.matcher(text);
        if(match.find()){
            System.out.println(match.group());
        }else{
            System.out.println("Invalid_Input");
        }
    }
}