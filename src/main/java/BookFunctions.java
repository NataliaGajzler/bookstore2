import java.util.ArrayList;
import java.util.List;

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
                .findFirst().get();

        return book1;
    }

    //Task 2
    //Pętla
    List<Book> lastTwoBooks(List<Book> givenList) {
        List<Book> tempList2 = new ArrayList<>();
        Book lastBook = null;
        Book oneBeforeLastBook = null;
        for (Book book : givenList) {
            lastBook = givenList.get(givenList.size() - 1);
            oneBeforeLastBook = givenList.get(givenList.size() - 2);
        }
        tempList2.add(oneBeforeLastBook);
        tempList2.add(lastBook);
        return tempList2;
    }

    //Task 3
    //Pętla
    Book newestBook(List<Book> givenList) {
        Book book = null;
        int result;
        for (int i = 0; i < givenList.size(); i++) {
            result = givenList.get(i).getYear();
            if (result < givenList.get(i++).getYear()) {
                return book.getYear(result);
            }
        }
    }

    // Strumień
    Book newestBookStream(List<Book> givenList) {
//        givenList.stream().max(book -> book.getYear());
        return null; // todo do wyjaśnienia
    }

    //Task 4

    Book oldestBook(List<Book> givenList) {
        for (Book book : givenList) {

        }
        return null;
    }

    //Task 5
    int yearsSum(List<Book> givenList) {
        int sum = 0;
        for (int i = 0; i < givenList.size(); i++) {
            sum = sum + givenList.get(i).getYear();
        }
        return sum;
    }

    //Task 6
    int numBooksAfter2007(List<Book> givenList) {
        int sum;

        for (int i = 0; i < givenList.size(); i++) {
            if (givenList.get(i).getYear() > 2007) {
                sum += sum;
            }
        }
        return sum;
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

    //Task 9

    boolean isBookBefore2003(List<Book> givenList) {
        for (int i = 0; i < givenList.size(); i++) {
            if (givenList.get(i).getYear() < 2003) {
                return true;
            }
        }
        return false;
    }

}
