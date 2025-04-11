import java.awt.print.Book;
import java.util.ArrayList;

interface category {
    void display();
}

class BookCategory implements category{
    String name;
    double price;
    String category = "Book";
    BookCategory(String name,double price){
        this.name=name;
        this.price=price;
    }

    public double getprice(){
        return price;
    }

    public void setprice(double newprice){
        this.price = newprice;
    }
    @Override
    public void display(){
        System.out.println("Category: "+category+" ,Name: "+name +" ,Price:"+price);
    }
}

class ClothingCategory implements category{
    String name;
    double price;
    String category="Clothing";
    ClothingCategory(String name,double price){
        this.name = name;
        this.price=price;
    }

    public double getprice(){
        return price;
    }

    public void setprice(double newprice){
        this.price=newprice;
    }

    @Override
    public void display(){
        System.out.println("Category: "+category+" ,Name: "+name +" ,Price:"+price);
    }
}

class Product<T extends category>{
    T product;
    Product(T product){
        this.product=product;
    }
    public static <T extends category> void CalculateDis(T product, double percentage){
        if(product instanceof BookCategory){
            BookCategory b = (BookCategory) product;
            double newprice = (b.getprice()-(b.getprice()*percentage/100));
            b.setprice(newprice);
        }else if(product instanceof ClothingCategory){
            ClothingCategory c = (ClothingCategory) product;
            double newprice = (c.getprice()-(c.getprice()*percentage/100));
            c.setprice(newprice);
        }

    }
}

public class Main{
    public static void main(String[] args){

        BookCategory book = new BookCategory("Chamber",999);
        ClothingCategory shirt = new ClothingCategory("U.S",999);

        Product<BookCategory> p1 = new Product<>(book);
        Product<ClothingCategory> p2 = new Product<>(shirt);
        ArrayList<category> arr = new ArrayList<>();
        arr.add(book);
        arr.add(shirt);

        Product.CalculateDis(book,10);
        Product.CalculateDis(shirt,20);

        for(category item : arr){
            item.display();
        }
    }
}