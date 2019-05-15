import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

    static {
        System.out.println("My BOOKSTORE");
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Wyświetl listę książek:");
        System.out.println("2. Wyjdź");
        System.out.println("Podaj liczbę, by wskazać co chcesz zrobić: ");

        int oneOrTwo = scanner.nextInt();

        while (oneOrTwo != 2) {
            if (oneOrTwo == 1) {
                System.out.println("To lista książek: ");
                ListOfBooks books = new ListOfBooks();
                books.readAllLines();
                System.out.println("Co chcesz zrobić? 3. Dodaj książkę  2. Wyjdź");
                oneOrTwo = scanner.nextInt();
                if (oneOrTwo == 3) {
                    ListOfBooks books2 = new ListOfBooks();
                    books2.createABook();
                    books2.addABook(); //todo zapętla  dodanie książki, dlaczego?
                }

                System.out.println("Podaj liczbę, by wskazać co chcesz zrobić: ");
                oneOrTwo = scanner.nextInt();
            } else {
                System.out.println("Możesz wybrać tylko 1 lub 2! Wpisz poprawną liczbę: ");
                oneOrTwo = scanner.nextInt();
            }
        }
        System.out.println("Do zobaczenia! :) ");
    }
}
