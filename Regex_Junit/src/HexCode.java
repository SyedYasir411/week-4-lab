import java.util.regex.*;
public class HexCode {
    public static void main(String[] args){
        String text = "#FF2980";
        String regex = "^#[A-Fa-f0-9]{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(text);

        if(match.matches()){
            System.out.println(match.group());
        }else{
            System.out.println("Invalid Input");
        }
    }
}
