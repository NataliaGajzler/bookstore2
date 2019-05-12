public class Book {
    private String title;
    private String isbn;
    private String year;
    private String bookCover;
    private String bookID;
    private String categoryID;

    public Book(String title, String isbn, String year, String bookCover, String bookID, String categoryID) {
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

    public String getBookCover() {
        return bookCover;
    }

    public String getBookID() {
        return bookID;
    }

    public String getCategoryID() {
        return categoryID;
    }
}
