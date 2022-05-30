package Day3;

class Book
{
    public String title;
    public String author;
    public int price;

    public void printBookInfo(){
    System.out.println("Book: Title = "+ title +",Author : "+author +"Price :"+ price );
}
}
public class Demo5 {
    public static void main(String[] args) {
        
        Book bookobj=new Book();
         bookobj.author="Dan Brown";
        bookobj.title="Davinci Code";
        bookobj.price=900;

        bookobj.printBookInfo();


    }
}
