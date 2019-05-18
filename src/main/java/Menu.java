import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

    static {
        System.out.println("My BOOKSTORE");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        Menu menu = new Menu();

        while (true) {
            menu.showMenu();
            String userAction = scanner.next();
            switch (userAction) {
                case "1":
                    System.out.println("To lista książek: ");
                    library.listOfBooks.forEach(book -> System.out.println(book));
                    break;
                case "2":
                    Book newBook = library.createBook();
                    library.addBook(newBook);
                    break;
                case "3":
                    System.out.println("Do zobaczenia! :) ");
                    return;
                case "4":
//                    library.saveToFile(library.listOfBooks);
                    System.out.println("Zapisane, sprawdź nowy plik z listą książek");
                default:
                    System.out.println("Możesz wybrać tylko 1, 2 lub 3! Wpisz poprawną liczbę: ");
                    break;

            }
        }
    }

    private void showMenu() {
        System.out.println("1. Wyświetl listę książek: ");
        System.out.println("2. Dodaj książkę do listy ");
        System.out.println("3. Wyjdź");
        System.out.println("4. Zapisz listę książek do pliku");
        System.out.println("Podaj liczbę, by wskazać co chcesz zrobić: ");
    }
}
