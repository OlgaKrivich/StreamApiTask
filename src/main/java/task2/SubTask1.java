package task2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SubTask1 {

    public static void main(String[] args) {
        List<Book> bookList = Book.createListOfBooks(10);
        System.out.println(
                "Print all books using method toString (information should be consistent, "
                        + "like real name and price of each book)");
        Iterator<Book> itr = bookList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println();
        System.out.println("Get List<String> of all book names and print them");
        bookList.stream().map((Book::getName))
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println();
        System.out.println("Get total price of all books and print it");
        bookList.stream().map(Book::getPrice).reduce(Integer::sum).ifPresent(System.out::println);

        System.out.println();
        System.out.println("Get any book with “A” or “a” character in name and print its name");
        bookList.stream().map(Book::getName)
                .filter(name -> name.contains("A") || name.contains("a")).findAny()
                .ifPresent(System.out::println);

        System.out.println();
        System.out.println("Print book name with highest price");
        bookList.stream()
                .max(Comparator.comparing(Book::getPrice)).map(Book::getName)
                .ifPresent(System.out::println);

        System.out.println();
        System.out.println("Get number of books where name consists of 5 letters");
        long number = bookList.stream().map(Book::getName).filter(name -> name.length() == 5)
                .count();
        System.out.println(number);

        System.out.println();
        System.out.println("Get all books except books with price higher than 70");
        bookList.stream().map(Book::getPrice).filter(price -> !(price > 70))
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println();
        System.out.println("Sort books by name in desc order, if name equals then sort by price");
        bookList.stream().sorted(Comparator.comparing(Book::getName).reversed()
                .thenComparing(Book::getPrice)).forEach(System.out::println);

    }
}
