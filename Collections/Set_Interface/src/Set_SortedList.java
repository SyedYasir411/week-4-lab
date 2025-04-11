import java.util.*;
public class Set_SortedList {
    public static void main(String[] args){
        Set<Integer> s = new HashSet<>(Arrays.asList(5,3,9,1));
        List<Integer> list = new ArrayList<>(s);
        Collections.sort(list,(a,b) -> b-a);
        System.out.println(list);
    }
}
