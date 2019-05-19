import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class BookFunctions {

    //Task 1
    //Pętla
    Book findISBN(long isbn, List<Book> bookList) {
        for (Book book : bookList) {
            long tempIsbn = book.getIsbn();
            if (tempIsbn == isbn) {
                return book;
            }
        }
        return null;
    }

    //Strumień

    Book findIsbnStream(long isbn, List<Book> bookList) {
        Book book1 = bookList.stream()
                .filter(book -> book.getIsbn() == isbn)
                .findFirst().orElse(null);
        return book1;
    }
    // Strumień z Optionalem

    Optional<Book> findISBNOptional(long isbn, List<Book> bookList) {
        BookComparator bookComparator = new BookComparator();

        Optional<Book> book = bookList.stream().filter(b -> b.getIsbn() == (isbn)).findFirst();
        return book;
    }


    //Task 2
    //Pętla
    List<Book> lastTwoBooks(List<Book> givenList) {
        List<Book> tempList2 = new ArrayList<>();
        Book lastBook = null;
        Book oneBeforeLastBook = null;

        if (givenList.size() > 2) {
            for (Book book : givenList) {
                lastBook = givenList.get(givenList.size() - 1);
                oneBeforeLastBook = givenList.get(givenList.size() - 2);
            }
            tempList2.add(oneBeforeLastBook);
            tempList2.add(lastBook);
            return tempList2;
        } else {
            System.out.println("Lista zawiera mniej niż 2 elementy.");
        }
        return tempList2;
    }

    //
    List<Book> lastTwoBooksother(List<Book> givenList) {

        if (givenList.size() > 2) {
            List<Book> twoLastBooks = givenList.subList(givenList.size() - 2, givenList.size());
            return twoLastBooks;
        } else {
            System.out.println("Lista zawiera mniej niż 2 elementy.");
        }
        return null;
    }

    //Task 3
    //Pętla
    Book newestBook(List<Book> givenList) {
        return null; //todo Pętla
    }

    // Strumień
    Book newestBookStream(List<Book> givenList) {
        return null;
    }


    Optional<Book> findOldestYearOptional(List<Book> bookList) {
        BookComparator bookComparator = new BookComparator();

        Optional<Book> oldestYear = bookList.stream().max(bookComparator);
        return oldestYear;
    }

    //Task 4

    Book oldestBook(List<Book> givenList) {
        for (Book book : givenList) {
            //todo pętla
        }
        return null;
    }

    //Stream
    Optional<Book> newestBookYearOptional(List<Book> givenList) {
        BookComparator bookComparator = new BookComparator();

        Optional<Book> newestBook = givenList.stream().min(bookComparator);
        return newestBook;
    }


    //Task 5
    int yearsSum(List<Book> givenList) {
        int sum = 0;
        for (int i = 0; i < givenList.size(); i++) {
            sum = sum + givenList.get(i).getYear();
        }
        return sum;
    }

    //Stream

    int yearSumStream(List<Book> givenList) {
        int yearsSum = givenList.stream().mapToInt(book -> book.getYear()).sum();
        return yearsSum;
    }


    //Task 6
    int numBooksAfter2007(List<Book> givenList) {
        int sum = 0;

        for (int i = 0; i < givenList.size(); i++) {
            if (givenList.get(i).getYear() > 2007) {
                sum += sum;
            }
        }
        return sum;
    }

    //Stream

    long numBooksAfter2007Stream(List<Book> givenList) {
        long numOfBooks2007 = givenList.stream().filter(book -> book.getYear() > 2007).count();
        return numOfBooks2007;
    }

    //Task 7
    boolean isAllAfterYear2000(List<Book> givenList) {

        for (int i = 0; i < givenList.size(); i++) {
            if (givenList.get(i).getYear() > 2000) {
                return true;
            }
        }
        return false;
    }

    boolean isAllAfter2000Stream(List<Book> givenList) {
        boolean isAfter2000 = givenList.stream().allMatch(book -> book.getYear() > 2000);
        return isAfter2000;
    }

    //Task 8
    int yearAvrage(List<Book> givenList) {
        int yearAv = 0;
        int sum = 0;
        for (int i = 0; i < givenList.size(); i++) {
            sum = sum + givenList.get(i).getYear();
        }
        yearAv = sum / givenList.size();
        return yearAv;
    }

    int yearAvrageStream(List<Book> givenList) {
        int yearAvr = (givenList.stream().mapToInt(book -> book.getYear()).sum()) / givenList.size();
        return yearAvr;
    }

    //Task 9

    boolean isBookBefore2003(List<Book> givenList) {
        for (int i = 0; i < givenList.size(); i++) {
            if (givenList.get(i).getYear() < 2003) {
                return true;
            }
        }
        return false;
    }

    boolean isBookBefore2003Stream(List<Book> givenList) {
        boolean isBefore2003 = givenList.stream().anyMatch(book -> book.getYear() > 2003);
        return isBefore2003;
    }


    //Task10
    //Stream

    List<Book> startsWithCAfter2007(List<Book> givenList) {
        List<Book> tempList = new ArrayList<>();
        List<Book> tempList2 = new ArrayList<>();
        tempList = givenList.stream()
                .filter(book -> book.getYear() > 2007).collect(Collectors.toList());
        tempList2 = tempList.stream()
                .filter(book -> book.getTitle().startsWith("C"))
                .collect(Collectors.toList());
        return tempList2;
    }

    //Task11
    //Stream

    List<String> TitlesYearDivideBy2(List<Book> givenList) {
        List<Book> tempList = new ArrayList<>();
        List<String> tempList2 = new ArrayList<>();
        tempList = givenList.stream()
                .filter(book -> book.getYear() % 2 == 0)
                .collect(Collectors.toList());
        tempList2 = tempList.stream()
                .map(book -> book.getTitle())
                .collect(Collectors.toList());

        return tempList2;
    }

    //Task12 Zwróć mapę, która będzie miała klucz isbn i wartość obiekt Book (Map<String, Book>)

    Map<Long, Book> bookMap(List<Book> givenList) {
        return givenList.stream().collect(Collectors.toMap(Book::getIsbn, book -> book));
    }

    //Task 13 Posortuj książki po roku wydania zaczynając od wydanej najpóźniej.

    List<Book> fromYoungestStream(List<Book> givenList) {
        List<Book> tempList = new ArrayList<>();

        BookComparator bookComparator = new BookComparator();
        tempList = givenList.stream().sorted(bookComparator).collect(Collectors.toList());
        Collections.reverse(tempList);
        return tempList;
    }

    //Task 14 Posortuj książki po roku wydania zaczynając od wydanej najwcześniej.

    List<Book> fromOldestStream(List<Book> givenList) {
        List<Book> tempList = new ArrayList<>();

        BookComparator bookComparator = new BookComparator();
        tempList = givenList.stream().sorted(bookComparator).collect(Collectors.toList());
        return tempList;
    }

    //Task15 Podziel listę książek na 3 listy po 2 książki i zwróć z metody. (*) (bez streama)
    //Stream

    List<List<Book>> splitList(List<Book> givenList) {
        return Lists.partition(givenList, 3);
    }

    //Task16 Pogrupuj książki po roku wydania. Metoda powinna zwrócić Map<Integer,
    // List<Book>> gdzie kluczem jest rok wydania a wartością lista książek wydana w tym roku. (*)

    Map<Integer, List<Book>> mapOfBooks(List<Book> givenList) {
        Map<Integer, List<Book>> tempMap = givenList.stream()
                .collect(Collectors.groupingBy(book -> book.getYear()));
        return tempMap;
    }

    //Task17 Podziel książki na te wydane po 2009 roku i pozostałe. Metoda powinna zwrócić
    // Map<Boolean, List<Book>> gdzie kluczem jest boolean oznaczający czy została wydana po 2009
    // a wartością będą listy książek. (*)

    Map<Boolean, List<Book>> mapOfBooks2(List<Book> givenList) {

        Map<Boolean, List<Book>> tempMap =givenList.stream()
                .collect(Collectors.groupingBy(book -> book.getYear()>2009));

        return tempMap;

    }


}
