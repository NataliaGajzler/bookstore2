import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    public int compare(Book o1, Book o2) {
        return Integer.compare(o1.getYear(),o2.getYear());
    }

}
