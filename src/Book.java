import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String isbn;
    private String title;
    private int editionNumber;
    private String copyright;
    private List<Author> authorList = new ArrayList<>();

    public Book(String isbn, String title, int editionNumber, String copyright){
        this.isbn = isbn;
        this.title = title;
        this.editionNumber = editionNumber;
        this.copyright = copyright;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public void printBookInfo(PrintStream printStream){
        printStream.printf("\nISBN: %s \t\t Title: %-80s \t\t Edition: %d \t\t Copyright: %s",
                this.getIsbn(),this.getTitle(),this.getEditionNumber(),this.getCopyright());


    }
}
