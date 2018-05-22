package service;

import dao.ThemeDao;
import entity.Theme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThemeService implements ThemeDao{
    private Connection connection;

    public ThemeService(Connection connection){
        this.connection = connection;
    }

    @Override
    public void add(Theme theme) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO themes(title, content, book_id)" +
                " VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, theme.getTitle());
            preparedStatement.setString(2, theme.getContent());
            preparedStatement.setInt(3, theme.getIdBook());

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
    public List<Theme> getAll(int bookId) {
        List<Theme> listThemes = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT theme_id, title, content, book_id FROM themes WHERE book_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Theme theme = new Theme();
                theme.setId(resultSet.getInt("theme_id"));
                theme.setTitle(resultSet.getString("title"));
                theme.setContent(resultSet.getString("content"));
                theme.setIdBook(resultSet.getInt("book_id"));

                listThemes.add(theme);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null) {
                    connection.close();
                    System.out.println("connection close");
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return listThemes;
    }

    @Override
    public void update(Theme theme) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE themes SET title = ?, content = ? WHERE theme_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, theme.getTitle());
            preparedStatement.setString(2, theme.getContent());
            preparedStatement.setInt(3, theme.getId());

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
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM themes WHERE theme_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

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
}
