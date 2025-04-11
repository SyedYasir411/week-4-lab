import java.util.*;
public class Subset {
    public static void main(String[] args){
        Set<Integer> s = new HashSet<>(Arrays.asList(2,4,5,65,23,1));
        Set<Integer> s1 = new HashSet<>(Arrays.asList(23,2,1));
        System.out.println(s.containsAll(s1));
    }
}
