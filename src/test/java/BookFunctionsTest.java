import org.assertj.core.internal.bytebuddy.implementation.auxiliary.MethodCallProxy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.hamcrest.collection.IsMapContaining;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookFunctionsTest {
    static List<Book> bookTestList;
    BookFunctions bookFunctions = new BookFunctions();

    @BeforeAll
    static void init() {
        bookTestList = new ArrayList<>();
        Book book1 = new Book("AAA", 1234567890L, 2008, "T", "2", "1");
        Book book2 = new Book("BBB", 1234787890, 2007, "T", "2", "3");
        Book book3 = new Book("CCC", 1234567890, 2005, "T", "3", "1");
        Book book4 = new Book("DDD", 1234117890, 2010, "T", "3", "1");
        Book book5 = new Book("EEE", 1231117890, 2016, "T", "3", "1");
        Book book6 = new Book("FFF", 1234533330, 1999, "T", "3", "1");
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
    void test2LastBooksOther() {
        List<Book> last2BooksOther = bookFunctions.lastTwoBooksother(bookTestList);
        assertThat(last2BooksOther).hasSize(2).contains(bookTestList.get(4), bookTestList.get(5));
    }

    @Test
        //5
    void testYearsSum() {
        int yearsSum = bookFunctions.yearsSum(bookTestList);
        Assertions.assertEquals(yearsSum, 1989 * 3 + 2010 + 2009 + 2008);
    }

    @Test
    void testYearsSumStream() {
        int yearsSum = bookFunctions.yearSumStream(bookTestList);
        Assertions.assertEquals(yearsSum, 10046 - 2007);
    }

    @Test
        //6
    void testSum2007() {
        int sum2007 = bookFunctions.numBooksAfter2007(bookTestList);
        Assertions.assertEquals(sum2007, 2);
    }

    @Test

    void numOfBooks2007Stream () {
        long sum2007 = bookFunctions.numBooksAfter2007Stream(bookTestList);
        Assertions.assertEquals(sum2007,12045);
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

    void testBookBefore2003() {
        boolean before2003 = bookFunctions.isBookBefore2003(bookTestList);
        Assertions.assertTrue(before2003);
    }


    @Test//12

    void testMapBooks () {
        Map<Long,Book> testMap = bookFunctions.bookMap(bookTestList);
      Assert.assertThat(testMap, IsMapContaining.hasEntry(1234567890L,bookTestList.get(0)));
    }



    @Test
    //14
    void fromYoungestStream () {
        List<Book> fromYoungest = bookFunctions.fromYoungestStream(bookTestList);

    }



    @Test
    //17

    void mapOfBook2 () {
        Map<Boolean, List<Book>> mapOfBooks2009 = bookFunctions.mapOfBooks2(bookTestList);
        Assertions.assertEquals(mapOfBooks2009.containsKey(false), false);
    }


}
