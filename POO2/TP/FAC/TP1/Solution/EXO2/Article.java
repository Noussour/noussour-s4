package EXO2;

public class Article {
    int number ;
    String name ;
    float price ;

    public Article(int number, String name, float price){
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public void display(){
        System.out.println("Number : " + this.number + " Name : " + this.name + " Price : " + this.price);
    }
}
