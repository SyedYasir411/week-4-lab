import java.util.*;
public class EqualSets {
    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>(Set.of(3,2,1));
        set.add(2);
        set.add(13);
        set.add(3);
        System.out.println(set);
        System.out.println(set1);
        System.out.println(set.equals(set1));
    }

}
