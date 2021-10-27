package task2;

import java.util.HashMap;
import java.util.Map;

public class SubTask2 {

    public static void main(String[] args) {
        Book book1 = new Book("myBook", 5);
        Map<Book, String> mapWithBook = new HashMap<>();
        mapWithBook.put(book1, "Library1");
        Book book2 = new Book("myBook", 5);

        System.out.println(mapWithBook.get(book2));
    }

}
