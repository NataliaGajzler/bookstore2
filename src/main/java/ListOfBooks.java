import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLOutput;
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
            line.split(;) //todo split
        }
        return tempList;
    }

    void readAllLines() {
        System.out.println(booksList());
    }

    public static Book newBook() {

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
        BookCover cover = scanner.next(); //todo enum?

        System.out.println("Podaj ID autorów książki");
        int idAutor = scanner.nextInt();

        System.out.println("Podaj ID kategorii");
        int idCategory = scanner.nextInt();

        Book bookToAdd = new Book(title, isbn, year, cover, idAutor, idCategory);
        return bookToAdd;
    }

    static List<Book> updateBookList() {
        List<Book> tempList = new ArrayList<>();
        tempList.add(booksList()); //todo dodać do listy
        tempList.add(newBook());
        return tempList;
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
        } else{
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

    public static void remove (String name) {


    }
}
