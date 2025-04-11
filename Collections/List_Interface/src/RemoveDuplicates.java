import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
        List<Integer> new_list = new ArrayList<>();
        for(int i : list){
            if(!new_list.contains(i)){
                new_list.add(i);
            }
        }
        for(int i : new_list){
            System.out.println(i);
        }
    }
}
