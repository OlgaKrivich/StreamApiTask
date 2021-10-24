package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.RandomStringUtils;

public class Book {

    String name;
    Integer price;

    public Book(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public static List<Book> createListOfBooks(int numberOfBooks) {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < numberOfBooks; i++) {
            String bookName = RandomStringUtils.randomAlphabetic(3, 10);
            Integer bookPrice = Integer.parseInt(RandomStringUtils.random(2, 1, 99, false, true));

            bookList.add(new Book(bookName, bookPrice));
        }
        return bookList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return getName().equals(book.getName()) && getPrice().equals(book.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }
}
