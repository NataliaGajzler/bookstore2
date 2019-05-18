public class Book {
    private int identifier;
    private String title;
    private long isbn;
    private int year;
    private String bookCover;
    private String bookID;
    private String categoryID;

    private Category category; //todo zastąpić Stringi ID obiektami

    Book(String title, long isbn, int year, String bookCover, String bookID, String categoryID) {
        this.identifier = identifier;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.bookCover = bookCover;
        this.bookID = bookID;
        this.categoryID = categoryID;
    }

    public int getIdentifier() { return identifier; }

    public String getTitle() {
        return title;
    }

    public long getIsbn() {
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
        return "Identifier: " + identifier + "\n" +
                "Title: " + title + "\n" +
                "ISBN: " + isbn + "\n" +
                "Year: " + year + "\n" +
                "Book cover: " + bookCover + "\n" +
                "Book ID: " + bookID + "\n" +
                "Category ID: " + categoryID + "\n";
    }
}
