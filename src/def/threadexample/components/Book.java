package def.threadexample.components;

import java.util.Objects;

public class Book {

    private String bookName;

    public Book(){

    }

    public Book(String bookName){
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookName, book.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName);
    }
}
