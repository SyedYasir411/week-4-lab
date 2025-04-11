import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class ReverseList {
    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        List<Integer> Linked_arr = new LinkedList<>();

        arr.add(12);
        arr.add(5);
        arr.add(20);
        arr.add(6);
        arr.add(2);

        Linked_arr.add(0,34);
        Linked_arr.add(1,3);
        Linked_arr.add(2,4);
        Linked_arr.add(3,7);

        List<Integer> new_arr = new ArrayList<>();
        List<Integer> new_linked = new LinkedList<>();
        int k=0;
        for(int i=arr.size()-1;i>=0;i--){
            new_arr.add(k,arr.get(i));
            k++;
        }
        System.out.println("Old ArrayList");
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println("\nNew ArrayList");
        for(int i: new_arr){
            System.out.print(i + " ");
        }

        for(int i=Linked_arr.size()-1;i>=0;i--){
            new_linked.add(Linked_arr.get(i));
        }
        System.out.println("\nOld LinkedList");
        for(int i: Linked_arr){
            System.out.print(i+" ");
        }

        System.out.println("\nNew LinkedList");
        for(int i: new_linked){
            System.out.print(i + " ");
        }
    }
}