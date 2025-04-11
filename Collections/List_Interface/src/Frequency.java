import java.util.*;

public class Frequency {
    public static void main(String[] args){
        List<String> arr= new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange"));
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() +" : "+entry.getValue());
        }
    }
}
