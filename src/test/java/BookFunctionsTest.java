import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class BookFunctionsTest {
    static List<Book> bookTestList;
    BookFunctions bookFunctions = new BookFunctions();

    @BeforeAll
    static void init() {
        bookTestList = new ArrayList<>();
        Book book1 = new Book("abcd", 1234567890, 2008, "T", "2", "1");
        Book book2 = new Book("abcd", 1234787890, 2007, "T", "2", "3");
        Book book3 = new Book("abcd", 1234567890, 2005, "T", "3", "1");
        Book book4 = new Book("abcd", 1234117890, 2010, "T", "3", "1");
        Book book5 = new Book("abcd", 1231117890, 2016, "T", "3", "1");
        Book book6 = new Book("abcd", 1234533330, 1999, "T", "3", "1");
        bookTestList.add(book1);
        bookTestList.add(book2);
        bookTestList.add(book3);
        bookTestList.add(book4);
        bookTestList.add(book5);
        bookTestList.add(book6);
    }


    @Test
        //1
    void testISBN() {
        Book book = bookFunctions.findISBN(1234567890, bookTestList);
        Assertions.assertEquals(1234567890, book.getIsbn());

    }


    @Test
        //2
    void test2lastBooks() {
        List<Book> lastTwoBooksTest = bookFunctions.lastTwoBooks(bookTestList);
        assertThat(lastTwoBooksTest).hasSize(2)
                .contains(bookTestList.get(4), bookTestList.get(5));

    }

    @Test
        //5
    void testYearsSum() {
        int yearsSum = bookFunctions.yearsSum(bookTestList);
        Assertions.assertEquals(yearsSum, 1989 * 3 + 2010 + 2009 + 2008);
    }

    @Test
        //6
    void testSum2007() {
        int sum2007 = bookFunctions.numBooksAfter2007(bookTestList);
        Assertions.assertEquals(sum2007, 2);
    }

    @Test
        //7
    void testIsAfterAllYear2000() {

    }

    @Test
        //8

    void testYearAvr() {
        int yearAvr = bookFunctions.yearAvrage(bookTestList);
        Assertions.assertEquals(yearAvr, 1999);
    }

    @Test
        //9

    void testBookBefore2003 () {
        boolean before2003 = bookFunctions.isBookBefore2003(bookTestList);
        Assertions.assertTrue(before2003);
    }
}
