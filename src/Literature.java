/**
 *
 * @author Ronkalot Co
 * uy
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public String getDatePublished(){
        return this.datePublished;
    }

    public void setDatePublished(String yearPublished){
        this.datePublished = yearPublished;
    }

    public int getNumberOfPages(){
        return this.numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages){
        this.numberOfPages = numberOfPages;
    }

    public String getGenre(){
        return this.genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
