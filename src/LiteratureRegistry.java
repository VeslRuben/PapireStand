import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;


/**
 * A class for collecting and keeping track of literature objects.
 * The class contains various methods for sorting, organising and printing information on literature.
 *
 * @author Ruben S. J., Håkon B. W., Jan Tore S. M., Gruppe 16
 * @version 2018-02-15
 */
public class LiteratureRegistry {

    private ArrayList<Book> listOfAllBooks;
    private HashMap<String, ArrayList<Book>> authorList;
    private HashMap<String, ArrayList<Book>> genreList;



    /**
     * Constructs the object
     * @param books A initial ArrayList off books
     */
    public LiteratureRegistry(ArrayList<Book> books) {
        this.authorList = new HashMap<>();
        this.genreList = new HashMap<>();

        //Sorts out the duplicates before initialising listOfAllBooks
        for (int i = 0; i < books.size(); i++) {
            for (int j = i + 1; j < books.size(); j++) {
                if (books.get(i).getTitle().toLowerCase().equals(books.get(j).getTitle().toLowerCase()) &&
                        books.get(i).getAuthor().toLowerCase().equals(books.get(j).getAuthor().toLowerCase()) && books.get(i).getEdition().equals(books.get(j).getEdition())) {

                    books.get(i).setQuantity(books.get(i).getQuantity() + books.get(j).getQuantity());
                    books.remove(j);
                    j--;
                }
            }
        }
        this.listOfAllBooks = books;
        this.sortToAuthorMap();
        this.sortToGenreMap();
    }

    /**
     * Constructs the object.
     */
    public LiteratureRegistry() {
        this.listOfAllBooks = new ArrayList<>();
        this.authorList = new HashMap<>();
        this.genreList = new HashMap<>();
    }

    /**
     * Puts all books by the same author in to a HashMap with the name of the author as key.
     */
    private void sortToAuthorMap() {
        ArrayList<Book> tmpNumberOfBooks = (ArrayList<Book>)this.listOfAllBooks.clone();
        for (int i = 0; i < tmpNumberOfBooks.size(); i++) {
            ArrayList<Book> tmpAuthorList = new ArrayList<>();
            Book book = tmpNumberOfBooks.get(i);

            for (int j = i + 1; j < tmpNumberOfBooks.size(); j++) {
                if (book.getAuthor().equals(tmpNumberOfBooks.get(j).getAuthor())) {
                    tmpAuthorList.add(tmpNumberOfBooks.get(j));
                    tmpNumberOfBooks.remove(j);
                    j--;
                }

            }

            tmpAuthorList.add(book);
            this.authorList.put(book.getAuthor().toLowerCase(), tmpAuthorList);


        }

    }


    /**
     * Puts all books in the same genre in to a HashMap with the name of the genre as key.
     */
    private void sortToGenreMap() {
        ArrayList<Book> tmpNumberOfBooks = (ArrayList<Book>)this.listOfAllBooks.clone();
        for (int i = 0; i < tmpNumberOfBooks.size(); i++) {
            ArrayList<Book> tmpList = new ArrayList<>();
            Book book = tmpNumberOfBooks.get(i);

            for (int j = i + 1; j < tmpNumberOfBooks.size(); j++) {
                if (book.getGenre().equals(tmpNumberOfBooks.get(j).getGenre())) {
                    tmpList.add(tmpNumberOfBooks.get(j));
                    tmpNumberOfBooks.remove(j);
                    j--;

                }
            }

            tmpList.add(book);
            this.genreList.put(book.getGenre().toLowerCase(), tmpList);


        }
    }

    /**
     * Checks if the book already exists in the registry.
     * @param book The book to check.
     * @return the matching book int the registry if found. null i no match is found.
     */
    private Book isDuplicate(Book book) {
        Book duplicate = null;
        for (Book bookInReg : this.listOfAllBooks) {
            if (book.getTitle().toLowerCase().equals(bookInReg.getTitle().toLowerCase()) && book.getAuthor().toLowerCase().equals(bookInReg.getAuthor().toLowerCase()) && book.getEdition().toLowerCase().equals(bookInReg.getEdition().toLowerCase())) {
                duplicate = bookInReg;
            }
        }
        return duplicate;
    }


    /**
     * Removes a book from the registry.
     * @param bookToRemove book to remove (Book)
     */
    private void removeBook(Book bookToRemove) {
        for (int i = 0; i < this.listOfAllBooks.size(); i++) {
            if (this.listOfAllBooks.get(i) == bookToRemove) {
                this.listOfAllBooks.remove(i);
            }
        }
        sortToAuthorMap();
        sortToGenreMap();
    }

    /**
     * Removes a book from the registry with the index as the identifier.
     * @param index The index of the book in the registry.
     */
    private void removeBook(int index) {
        this.listOfAllBooks.remove(index);
        sortToAuthorMap();
        sortToGenreMap();
    }

    /**
     * Removes a book from the Literature Registry with String as the identifier.
     * @param title Title of the book
     */
    public void removeBook(String title) {
        title = title.toLowerCase();
        for (int i = 0; i < this.listOfAllBooks.size(); i++) {
            if (title.equals(this.listOfAllBooks.get(i).getTitle().toLowerCase())) {
                removeBook(i);
            }
        }
    }

    /**
     * Adds a book to the list off books.
     * if the book already exists in the registry the quantity is added to the existing book.
     * @param book the book to add
     */
    public void addBook(Book book) {
        Book matchingBookInReg = this.isDuplicate(book);
        if (matchingBookInReg != null) {
            int quantity = book.getQuantity();
            matchingBookInReg.setQuantity(matchingBookInReg.getQuantity() + quantity);
        }
        else {
            this.listOfAllBooks.add(book);
            this.sortToGenreMap();
            this.sortToAuthorMap();
        }

    }

    /**
     * Adds an ArrayList of books to the list of books.
     * if a book already exists in the registry the quantity is added to the existing book.
     * @param books an ArrayList of books
     */
    public void addBooks (ArrayList<Book> books) {
        boolean newBookRegistered = false;
        for (Book book : books) {
            Book matchingBookInReg = this.isDuplicate(book);
            if (matchingBookInReg != null) {
                int quantity = book.getQuantity();
                matchingBookInReg.setQuantity(matchingBookInReg.getQuantity() + quantity);
            }
            else {
                this.listOfAllBooks.add(book);
                newBookRegistered = true;
            }
        }
        if (newBookRegistered) {
            this.sortToGenreMap();
            this.sortToAuthorMap();
        }
    }


    /**
     * Gets all book by that author.
     * @param author Name of the author
     * @return An ArrayList of the books. the list is empty if no books ar found.
     */
    public ArrayList<Book> getBookByAuthor(String author) {
        ArrayList<Book> temp = new ArrayList<>();
        Set<String> keys = this.authorList.keySet();
        for (String key : keys) {
            if (key.toLowerCase().contains(author.toLowerCase())) {
                temp.addAll(this.authorList.get(key));
            }
        }
        return temp;

    }

    /**
     * Gets all books in that genre.
     * @param genre the wanted genre
     * @return An ArrayList of the books. the list is empty if no books ar found.
     */
    public ArrayList<Book> getBookByGenre(String genre) {
        ArrayList<Book> temp = new ArrayList<>();
        Set<String> keys = this.genreList.keySet();
        for (String key : keys) {
            if (key.toLowerCase().contains(genre.toLowerCase())) {
                temp.addAll(this.genreList.get(key));
            }
        }
        return temp;
    }

    /**
     * Gets all Books containing that title.
     * @param title Title of the Book
     * @return An ArrayList of the books. the list is empty if no books ar found.
     */
    public ArrayList<Book> getBookBytitle(String title) {
        ArrayList<Book> temp = new ArrayList<>();
        for (Book book : this.listOfAllBooks) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                temp.add(book);
            }
        }
        return temp;
    }

    /**
     * Returns all books i the system.
     * @return An ArrayList of all the books in the system.
     */
    public ArrayList<Book> getAllBooks() {
        return this.listOfAllBooks;
    }

    /**
     * Prints out all info about all books.
     */
    public void printAllInfo() {
        for (Book book : this.listOfAllBooks) {
            String info = String.format("Title %s, Author %s, Series %s, Genre %s, Publisher %s, Date Published %s, Edition %s, Number of pages %o, In stock %o",
                    book.getTitle(), book.getAuthor(), book.getSeriesTitle(), book.getGenre(), book.getPublisher(), book.getDatePublished(), book.getEdition(), book.getNumberOfPages(), book.getQuantity());
            System.out.println(info);
        }
    }

    public void printAllInfo2() {
        this.listOfAllBooks.forEach((Book book) -> System.out.println(String.format("Title %s, Author %s, Genre %s, Publisher %s, Date Published %s, Edition %s, Number of pages %o, In stock %o",
                book.getTitle(), book.getAuthor(), book.getGenre(), book.getPublisher(), book.getDatePublished(), book.getEdition(), book.getNumberOfPages(), book.getQuantity())));
    }




}
