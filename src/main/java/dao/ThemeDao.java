package dao;

import entity.Theme;
import java.util.List;

public interface ThemeDao {
    void add(Theme theme);

    List<Theme> getAll(int bookId);

    void update(Theme theme);

    void remove(int id);
}
