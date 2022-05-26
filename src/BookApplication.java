import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class BookApplication {

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        BookDatabaseManager bookDatabaseManager = new BookDatabaseManager();

        int choice;
        do {
        System.out.println("Enter 1 to Print all the books from the database (showing the authors)");
        System.out.println("Enter 2 to Print all the authors from the database (showing the books)");
        System.out.println("Enter 3 to Add a book to the database for an existing author ");
        System.out.println("Enter 4 to Add a new author");
        System.out.println("Enter 5 to Quit");

        choice = input.nextInt();
        if (choice == 1) {

            for (Book book : bookDatabaseManager.getBookList()) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Edition: " + book.getEditionNumber());
                System.out.println("Copyright: " + book.getCopyright());
                book.getAuthorList().forEach(author -> author.printAuthorsInfo(System.out));
                System.out.println("\n");
            }
        } else if (choice == 2) {
            for (Author author : bookDatabaseManager.getAuthorList()) {
                System.out.println("Author ID: " + author.getAuthorID());
                System.out.println("First Name: " + author.getFirstName());
                System.out.println("Last Name : " + author.getLastName());
                author.getBookList().forEach(book -> book.printBookInfo(System.out));
                System.out.println("\n");
                System.out.println("Last Name: " + author.getLastName());
            }
        } else if (choice == 3) {
            System.out.println("Enter ISBN");
            String isbn1 = input.next();

            System.out.println("Enter title");
            String title = input.next();

            System.out.println("Enter edition number ");
            int number = input.nextInt();

            System.out.println("Enter year");
            String year = input.next();
            Book book = new Book(isbn1, title, number, year);

            System.out.println("Number of Authors: ");
            int numAuthors = input.nextInt();
            for(int i = 0; i < numAuthors; i++){
                System.out.println("\nAuthor ID: ");
                int authorID = input.nextInt();
                Author author = new Author(authorID, "", "");
                book.getAuthorList().add(author);
            }
            BookDatabaseManager.insertBook(book);
//           System.out.println("\n" + title + " Has been added");
        } else if (choice == 4) {
            System.out.println("\nAuthor ID: ");
            int authorID = input.nextInt();
            input.nextLine();
            System.out.println("First Name: ");
            String firstName = input.nextLine();
            System.out.println("Last Name: ");
            String lastName = input.nextLine();
            Author newAuthor = new Author(authorID, firstName, lastName);
            bookDatabaseManager.insertAuthor(newAuthor);


        } else {
            break;
        }

    }while(true);
                    System.out.println("See you next time Bye!");
}
}

