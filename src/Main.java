import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("yolo", "råger", "Fantasi", "Frank", "01.05.1985", "1", 2, 1));
        list.add(new Book("Hest er best", "finn", "Fantasi/Ikke spør", "Frank", "19 Pil og bue", "1", 2, 2));
        list.add(new Book("Natur og Vitenskap", "råger", "Krig", "Frank", "5520", "1", 2, 3));
        list.add(new Book("Yolo 2", "inn", "Fantasi", "Frank", "11.12.2003", "1", 2, 3));
        list.add(new Book("dsfkjh", "finn", "Fantasi", "Frank", "01.05.1985", "1", 2, 5));
        list.add(new Book("ikke spør", "finn", "Fantasi", "Frank", "01.05.1985", "1", 2, 7));
        list.add(new Book("Natur og Vitenskap", "finn", "Krig", "Frank", "01.05.1985", "1", 2, 2));
        list.add(new Book("Natur og Vitenskap", "finn", "Krig", "Frank", "01.05.1985", "1", 2, 2));
        list.add(new Book("Natur og Vitenskap", "finn", "Krig", "Frank", "01.05.1985", "2", 2, 7));


        LiteratureRegistry reg = new LiteratureRegistry(list);

        reg.addBook(new Book("Yolo", "Marit", "Livsstil", "Frank", "5520", "8", 2, 9));
        reg.removeBook("Hest er Best");

        System.out.println(reg.getBookByAuthor("finn"));
        System.out.println(reg.getBookByGenre("Fantasi"));
        System.out.println(reg.getBookBytitle("Natur og Vitenskap"));
        System.out.println(reg.getAllBooks());
        System.out.println("");





        reg.printAllInfo();
        System.out.println("");
        reg.printAllInfo2();



    }
}
