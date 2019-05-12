import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class ListOfBooks {

    private static List<String> booksList() {
        List<Book> tempList = new ArrayList<>();
        Scanner read = null;
        try {
            read = new Scanner(new File("src\\main\\resources\\books.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] bookParts = line.split(";");

            String title = bookParts[1];
            String isbn = bookParts[2];
            String year = bookParts[3];
            String bookCover = bookParts[4];
            String bookID = bookParts[5];
            String categoryID = bookParts[6];

            Book book = new Book(title, isbn, year, bookCover, bookID, categoryID);
        }
        return tempList;
    }

    void readAllLines() {
        System.out.println(booksList());
    }

    public static Book createABook() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tytuł: ");
        String title = scanner.next();

        System.out.println("Podaj ISBN (od 10 do 13 cyfr): ");
        String isbn = scanner.next();
        acceptISBN(isbn);

        System.out.println("Podaj rok wydania: ");
        String year = scanner.next();
        acceptYear(year);

        System.out.println("Podaj rodzaj oprawy (T - twarda; M- miękka");
        String cover = scanner.next();

        System.out.println("Podaj ID autorów książki");
        String idAutor = scanner.next();

        System.out.println("Podaj ID kategorii");
        String idCategory = scanner.next();

        Book bookToAdd = new Book(title, isbn, year, cover, idAutor, idCategory);
        return bookToAdd;
    }

    static void addABook() {
        List<Book> tempList = new ArrayList<>();
        tempList.add(booksList()); //todo dodać do listy
        tempList.add(createABook());
    }

    private static boolean isISBNCorrect(String isbn) {

        if (isbn.length() >= 10 && isbn.length() <= 13) {
            return true;
        } else {
            System.out.println("Niepoprawny ISBN. Podaj numer raz jeszcze:");
        }
        return false;
    }

    private static String acceptISBN(String isbn) {
        Scanner scanner = new Scanner(System.in);
        String isbnTemp;
        boolean checkISBN = isISBNCorrect(isbn);

        if (checkISBN == false) {
            isbnTemp = scanner.next();
        } else {
            return isbn;
        }
        return isbnTemp;
    }

    private static boolean isYearCorrect(String year) {
        if (year.length() == 4) {
            return true;
        } else {
            System.out.println("Podaj poprawny rok:");
        }
        return false;
    }

    private static String acceptYear(String year) {
        Scanner scanner = new Scanner(System.in);
        String yearTemp;
        boolean checkYear = isYearCorrect(year);

        if (checkYear == false) {
            yearTemp = scanner.next();
        } else {
            return year;
        }
        return yearTemp;
    }

    public static void remove(String name) {


    }
}
