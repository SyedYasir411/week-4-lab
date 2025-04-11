import java.util.ArrayList;
import java.util.List;

abstract class WareHouse{
    protected String Name;

    WareHouse(String name){
        this.Name=name;
    }

    public abstract String getCategory();
}

class Electronics extends WareHouse{
    private String category="Electronics";
    Electronics(String name){
        super(name);
    }
    @Override
    public String getCategory(){
        return "Electronics";
    }
}

class Groceries extends WareHouse{
    private String category="groceries";
    Groceries(String name){
        super(name);
    }

    @Override
    public String getCategory(){
        return "groceries";
    }
}

class Furniture extends WareHouse{
    private String category="Furniture";
    Furniture(String name){
        super(name);
    }

    @Override
    public String getCategory(){
        return "Furniture";
    }
}

class Storage<T extends WareHouse> {

    ArrayList<T> arr = new ArrayList<>();

    public void add(T addi) {
        arr.add(addi);
    }

    public void display(List<? extends WareHouse> list) {
        for(WareHouse item : list){
            System.out.println(item.Name +" "+ item.getCategory());
        }
    }

}
public class Main{
    public static void main(String[] args) {
        WareHouse n1 = new Electronics("Mobile");
        WareHouse n2 = new Electronics("PC");
        WareHouse n3 = new Furniture("Sofa");
        WareHouse n4 = new Groceries("Milk");
        Storage<WareHouse> dis = new Storage<>();
        dis.add(n1);
        dis.add(n2);
        dis.add(n3);
        dis.add(n4);
//        dis.add(n1);
        dis.display(dis.arr);
    }
}