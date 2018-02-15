/**
 * This class represents the common attributes of all literature,
 * and includes methods to return and/or change this information.
 *
 * @author Ruben S. J., Håkon B. W., Jan Tore S. M., Gruppe 16
 * @version 2018-02-15
 */
public class Literature {

    private String title;
    private String publisher;
    private String datePublished;
    private int numberOfPages;
    private String genre;
    private int quantity;

    public Literature(String title, String publisher, String datePublished, int numberOfPages, String genre, int quantity){
        this.title = title;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.quantity = quantity;
    }

    /**
     * Returns the title of the book
     * @return The title of the book
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the book
     * @param title The title of the book
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Returns the name of the publisher
     * @return The name of the publisher
     */
    public String getPublisher(){
        return this.publisher;
    }

    /**
     * Sets the name of the publisher
     * @param publisher The name of the publisher
     */
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    /**
     * Returns the publishing date
     * @return The publishing date
     */
    public String getDatePublished(){
        return this.datePublished;
    }

    /**
     * Sets the publishing date
     * @param yearPublished The publishing date
     */
    public void setDatePublished(String yearPublished){
        this.datePublished = yearPublished;
    }

    /**
     * Returns the number of pages
     * @return The number of pages
     */
    public int getNumberOfPages(){
        return this.numberOfPages;
    }

    /**
     * Sets the number of pages
     * @param numberOfPages The number of pages
     */
    public void setNumberOfPages(int numberOfPages){
        this.numberOfPages = numberOfPages;
    }

    /**
     * Returns the genre of the book
     * @return The genre of the book
     */
    public String getGenre(){
        return this.genre;
    }

    /**
     * Sets the genre of the book
     * @param genre The genre of the book
     */
    public void setGenre(String genre){
        this.genre = genre;
    }

    /**
     * Returns the quantity of the book available
     * @return The quantity of the book available
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of books available
     * @param quantity The quantity of books available
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

