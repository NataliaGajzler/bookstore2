import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Library {

    List<Book> listOfBooks = Library.booksFromFile();

    private static List<Book> booksFromFile() {
        List<Book> tempList = new ArrayList<>();
        Scanner read = null;
        try {
            read = new Scanner(new File("src\\main\\resources\\books.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("Nie udało się wczytać książki :( ");
        }
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] bookParts = line.split(";");

            String title = bookParts[1];
            String isbn = bookParts[2];
            int year = Integer.parseInt(bookParts[3]);
            String bookCover = bookParts[4];
            String bookID = bookParts[5];
            String categoryID = bookParts[6];

            Book book = new Book(title, isbn, year, bookCover, bookID, categoryID);
            tempList.add(book);
        }
        return tempList;
    }

    static Book createBook() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tytuł: ");
        String title = scanner.next();

        System.out.println("Podaj ISBN (od 10 do 13 cyfr): ");
        String isbn = scanner.next();
        acceptISBN(isbn); // todo validate tak jak year

        int year = readYear(); // todo obsłużyć jak litery

        System.out.println("Podaj rodzaj oprawy (T - twarda; M- miękka");
        String cover = scanner.next(); // todo wyjątek jak user poda cos innego

        System.out.println("Podaj ID autorów książki");
        String idAutor = scanner.next();

        System.out.println("Podaj ID kategorii");
        String idCategory = scanner.next();

        return new Book(title, isbn, year, cover, idAutor, idCategory);
    }

    void addBook(Book book) {
        listOfBooks.add(book);
    }

    private static boolean isISBNCorrect(String isbn) {

        if (isbn.length() >= 10 && isbn.length() <= 13) {
            return true;
        }
        return false;
    }

    private static String acceptISBN(String isbn) {
        Scanner scanner = new Scanner(System.in);
        String isbnTemp;
        boolean checkISBN = isISBNCorrect(isbn);

        if (!checkISBN) {
            System.out.println("Niepoprawny ISBN. Podaj numer raz jeszcze:");
            isbnTemp = scanner.next();
        } else {
            return isbn;
        }
        return isbnTemp;
    }

    private static boolean isYearCorrect(int year) {
        return (year > 1000 && year < 2019);
    }

    private static int readYear() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Podaj rok wydania: ");
            int year = scanner.nextInt();
            if (isYearCorrect(year)) {
                return year;
            } else {
                System.out.println("Niepoprawny rok.");
            }
        }
    }

    public static void remove(String name) {


    }
}
