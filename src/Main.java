import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Sex på stallen", "råger", "porno", "Frank", "5520", "1", 2, 1));
        list.add(new Book("Hest er best", "finn", "porno/Ikke spørr", "Frank", "5520", "1", 2, 2));
        list.add(new Book("Playboy", "råger", "porno", "Frank", "5520", "1", 2, 3));
        list.add(new Book("Hvordan få orgasme", "inn", "porno", "Frank", "5520", "1", 2, 3));
        list.add(new Book("Blowjob på kjøpesenter", "finn", "porno", "Frank", "5520", "1", 2, 5));
        list.add(new Book("single søte jenter", "finn", "porno", "Frank", "5520", "1", 2, 7));
        list.add(new Book("Playboy", "finn", "porno", "Frank", "5520", "1", 2, 2));
        list.add(new Book("Playboy", "finn", "porno", "Frank", "5520", "1", 2, 2));
        list.add(new Book("Playboy", "finn", "porno", "Frank", "5520", "2", 2, 7));

        LiarRegistry reg = new LiarRegistry(list);

        //reg.addBook(new Book("finn", "finn", "porno", "Frank", "5520", "1", 2, 9));



        reg.printAllInfo();



    }
}
