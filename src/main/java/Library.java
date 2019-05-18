import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Library {

    static List<Book> listOfBooks = Library.booksFromFile();

    private static List<Book> booksFromFile() {
        List<Book> tempList = new ArrayList<>();
        Scanner read = null;
        try {
            read = new Scanner(new File("src\\main\\resources\\books.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("Nie udało się wczytać książki :(  Zła ścieżka");
            throw new IllegalStateException(e.getMessage());
        }
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] bookParts = line.split(";");

            int identifer = Integer.parseInt(bookParts[0]);
            String title = bookParts[1];
            long isbn = Long.parseLong(bookParts[2]);
            int year = Integer.parseInt(bookParts[3]);
            String bookCover = bookParts[4];
            String bookID = bookParts[5];
            String categoryID = bookParts[6];

            Book book = new Book(title, isbn, year, bookCover, bookID, categoryID);
            tempList.add(book);
        }
        return tempList;
    }

//    static void saveToFile(List<Book> listOfBooks) {
//        Path path = Paths.get("C:/Users/natalia/Desktop/Programowanie SDA/190414_wzorceprjektowe/design-patterns-sda_ldz_18/bookstore/src/main/ListaKsiążek.csv");
//        try (BufferedWriter write = Files.newBufferedWriter(path)) {
//            //todo co tu wpisać żeby zapisac liste ksiązek;
//            while (!listOfBooks.isEmpty()) {
//
//                for (int i = 0; i < listOfBooks.size(); i++) {
//                    listOfBooks.get(i).getIdentifier();
//                    System.out.println(";");
//
//                    write.write(listOfBooks.toString());
//                }
//
//
//            } catch(IOException e){
//                System.out.println("Niepoprawna ścieżka pliku");
//            }
//        }

        static Book createBook () {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Podaj tytuł: ");
            String title = scanner.next();

            System.out.println("Podaj ISBN (od 10 do 13 cyfr): ");
            long isbn = scanner.nextLong();
            readISBN(); // todo validate tak jak year, obsłużyć jak litery

            int year = readYear(); // todo obsłużyć jak user poda litery

            System.out.println("Podaj rodzaj oprawy (T - twarda; M- miękka");
            String cover = scanner.next(); // todo wyjątek jak user poda cos innego
            BookCover bookCover = BookCover.valueOf(cover);

            System.out.println("Podaj ID autorów książki");
            String idAutor = scanner.next();

            System.out.println("Podaj ID kategorii");
            String idCategory = scanner.next();

            return new Book(title, isbn, year, cover, idAutor, idCategory); //todo można jakoś pominąć identifer?
        }

        void addBook (Book book){
            listOfBooks.add(book);
        }

        private static boolean isISBNCorrect ( long isbn){

            return isbn > 99_999_9999 && isbn < 100000000000L; //todo dodać warunek

        }


        private static long readISBN () {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Podaj ISBN: ");
                String line = scanner.nextLine();
                boolean numeric = StringUtils.isNumeric(line);

                while (numeric) {
                    long isbn = Long.parseLong(line);

                    if (isISBNCorrect(isbn)) {
                        return isbn;
                    } else {
                        System.out.println("Niepoprawny ISBN");
                    }
                }
            }
        }

        private static boolean isYearCorrect ( int year){
            return (year > 1000 && year < 2020);
        }

        private static int readYear () {
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

        public static void remove (String name){


        }
    }
