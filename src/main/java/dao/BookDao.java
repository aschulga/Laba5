package dao;

import entity.Book;
import java.util.List;

public interface BookDao {
    void add(Book book);

    List<Book> getAll();

    void update(Book book);

    void remove(int id);
}
