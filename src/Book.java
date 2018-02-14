/**
 * YOLO
 * @author Ronkalot Co
 */
public class Book extends Literature {
    private String author;
    private String seriesTitle;
    private String edition;


    /**
     * Constructor for books not part of a series. Sets the seriesTitle-field to null.
     *
     * @param title Title of the book
     * @param author Author of the book
     * @param genre Genre of the book
     * @param publisher Publisher of the book
     * @param datePublished Date published
     * @param edition Edition of the book
     * @param numberOfPages Number of pages in the book
     */
    public Book(String title, String author, String genre, String publisher, String datePublished, String edition, int numberOfPages, int quantity){
        super(title, publisher, datePublished, numberOfPages, genre, quantity);
        this.author = author;
        this.seriesTitle = null;
        this.edition = edition;
    }

    /**
     * Constructor for books that are part of a series.
     *
     * @param title Title of the book
     * @param author Author of the book
     * @param genre Genre of the book
     * @param publisher Publisher of the book
     * @param datePublished Date published
     * @param edition Edition of the book
     * @param numberOfPages Number of pages in the book
     * @param seriesTitle Title of the series
     */
    public Book(String title, String author, String genre, String publisher, String datePublished, String edition, int numberOfPages, int quantity, String seriesTitle) {
        super(title, publisher, datePublished, numberOfPages, genre, quantity);
        this.author = author;
        this.seriesTitle = seriesTitle;
        this.edition = edition;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    /**
     * Checks if the book is part of a series by checking if seriesTitle is null or not. Returns a text with series-name
     * if it is not null, and returns message that the book is not part of a series if seriesTitle = null.
     *
     * @return The name of the series, if the book is part of one.
     */
    public String getSeriesTitle(){
        if (seriesTitle != null) {
            return this.seriesTitle;
        }
        else {
            return "Not part of a series";
        }
    }

    public void setSeriesTitle(String seriesTitle){
        this.seriesTitle = seriesTitle;
    }

    public String getEdition(){
        return this.edition;
    }

    public void setEdition(String edition){
        this.edition = edition;
    }
}
