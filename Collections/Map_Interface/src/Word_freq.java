import java.util.*;

public class Word_freq{
    public static void main(String[] args){
        String text = "Hello world, hello Java!";
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = text.split("\\s+");
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        System.out.println(frequencyMap);
    }
}