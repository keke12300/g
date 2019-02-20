package Dao.impl;

import Dao.BaseDao;
import Dao.BookDao;
import entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2019-01-15.
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public List<Book> selectAll() {
        List<Book> list=new ArrayList<>();
        conn=connection();
        String sql="select * from book";
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Book book=new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setTime(rs.getDate("time"));
                book.setType(rs.getInt("type"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(Book book) {
        conn=connection();
        String sql="insert into book(name,author,time,type) values(?,?,?,?)";
        Object[] objects={
               book.getName(),
                book.getAuthor(),
                book.getTime(),
                book.getType()
        };
        return exceuteUpdate(sql,objects);
    }

    @Override
    public int delete(int id) {
        conn=connection();
        String sql="delete from book where id=?";
        Object[] objects={
                id
        };
        return exceuteUpdate(sql,objects);
    }
}
