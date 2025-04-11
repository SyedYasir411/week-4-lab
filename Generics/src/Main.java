class First<T>{
    T value;
    First(T value){
        this.value=value;
    }

    void display(){
        System.out.println("value : "+value);
    }
}

public class Main{
    public static void main(String[] args){
        First<Integer> n = new First<>(10);
        First<String> str= new First<>("one");
        n.display();
        str.display();
    }
}