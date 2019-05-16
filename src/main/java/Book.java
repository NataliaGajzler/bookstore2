public class Book {
    private String title;
    private String isbn;
    private int year;
    private String bookCover;
    private String bookID;
    private String categoryID;

    Book(String title, String isbn, int year, String bookCover, String bookID, String categoryID) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.bookCover = bookCover;
        this.bookID = bookID;
        this.categoryID = categoryID;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public String getBookCover() {
        return bookCover;
    }

    public String getBookID() {
        return bookID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    @Override
    public String toString() {
        return  "Title: " + title + "\n" +
                "ISBN: " + isbn + "\n" +
                "Year: " + year + "\n" +
                "Book cover: " + bookCover + "\n" +
                "Book ID: " + bookID + "\n" +
                "Category ID: " + categoryID + "\n";
    }
}
