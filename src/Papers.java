/**
 * @author Ronkalot Co
 */
public class Papers extends Literature
    {
        String frequentPublishing;
        String paperType;

    public Papers(String title, String publisher, String datePublished, int numberOfPages, String genre, String frequentPublishing, String paperType, int quantity)
        {
        super(title, publisher, datePublished, numberOfPages, genre, quantity);
        this.frequentPublishing = frequentPublishing;
        this.paperType = paperType;
        }

    public void setFrequentPublishing(String frequentPublishing)
        {
        this.frequentPublishing = frequentPublishing;
        }

    public void setPaperType(String paperType)
        {
        this.paperType = paperType;
        }

    public String getFrequentPublishing()
        {
        return frequentPublishing;
        }

    public String getPaperType()
        {
        return paperType;
        }
    
        
    }
