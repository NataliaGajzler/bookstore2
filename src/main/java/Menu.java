import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Menu {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Wyświetl listę książek:");
        System.out.println("2. Wyjdź");
        System.out.println("Podaj liczbę, by wskazać co chcesz zrobić: ");

        int oneOrTwo = scanner.nextInt();

        while (oneOrTwo != 2) {
            if (oneOrTwo == 1) {
                System.out.println("To lista książek");
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
