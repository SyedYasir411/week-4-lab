import java.util.*;

public class Binary{
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("1");

        for (int i = 0; i < N; i++) {
            String current = queue.poll();
            result.add(current);

            queue.offer(current + "0");
            queue.offer(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println("First " + N + " binary numbers: " + binaryNumbers);
    }
}
