package service;

import dao.BookDao;
import entity.Author;
import entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService implements BookDao{
    private Connection connection;

    public BookService(Connection connection){
        this.connection = connection;
    }

    @Override
    public void add(Book book) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO books(author_firstname, author_lastname, title)" +
                " VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, book.getAuthor().getFirstname());
            preparedStatement.setString(2, book.getAuthor().getLastname());
            preparedStatement.setString(3, book.getTitle());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null) {
                    connection.close();
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Book> getAll() {
        List<Book> listBooks = new ArrayList<>();
        Statement statement = null;

        String sql = "SELECT book_id, author_firstname, author_lastname, title FROM books";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("book_id"));
                book.setAuthor(new Author(resultSet.getString("author_firstname"),
                        resultSet.getString("author_lastname")));
                book.setTitle(resultSet.getString("title"));

                listBooks.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null) {
                    connection.close();
                    System.out.println("connection close");
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return listBooks;
    }

    @Override
    public void update(Book book) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE books SET author_firstname = ?, author_lastname = ?, title = ? WHERE book_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, book.getAuthor().getFirstname());
            preparedStatement.setString(2, book.getAuthor().getLastname());
            preparedStatement.setString(3, book.getTitle());
            preparedStatement.setInt(4, book.getId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remove(int id) {
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;

        String sql1 = "DELETE FROM themes WHERE book_id = ?";
        String sql2 = "DELETE FROM books WHERE book_id = ?";

        try {
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setInt(1, id);
            preparedStatement1.executeUpdate();

            preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setInt(1, id);
            preparedStatement2.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement1 != null)
                    preparedStatement1.close();
                if (preparedStatement2 != null)
                    preparedStatement2.close();
                if (connection != null)
                    connection.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
