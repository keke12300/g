package Dao;

import entity.Book;

import java.util.List;

/**
 * Created by LENOVO on 2019-01-15.
 */
public interface BookDao {
    List<Book> selectAll();
    int add(Book book);
    int delete(int id);
}
