import java.util.regex.*;
public class Practise{
    public static void main(String[] args){
        String word = "should contain for digits 2025";
        String PatternString ="\\d{4}";

        Pattern pattern = Pattern.compile(PatternString);
        Matcher match = pattern.matcher(word);

        if(match.find()){
            System.out.println("Found : "+match.group());
        }
    }
}

