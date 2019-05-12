public class Book {
    private String title;
    private String isbn;
    private String year;
    private BookCover bookCover;
    private int bookID;
    private int categoryID;

    public Book(String title, String isbn, String year, BookCover bookCover, int bookID, int categoryID) {
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

    public String getYear() {
        return year;
    }

    public BookCover getBookCover() {
        return bookCover;
    }

    public int getBookID() {
        return bookID;
    }

    public int getCategoryID() {
        return categoryID;
    }
}
