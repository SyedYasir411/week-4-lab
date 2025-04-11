import java.util.*;
public class RotateElements {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(10,20,30,40,50));
        Scanner input= new Scanner(System.in);
        int shifts = input.nextInt();
        while(shifts>0){
            int temp=list.get(0);
            for(int i=0;i<list.size();i++){
                if(i==list.size()-1){
                    list.set(i,temp);
                }else{
                    list.set(i,list.get(i+1));
                }
            }
            shifts--;
        }

        for(int i : list){
            System.out.print(i+" ");
        }

    }
}
