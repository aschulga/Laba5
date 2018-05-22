import bl.Util;
import entity.Book;
import entity.Theme;
import service.BookService;
import service.ThemeService;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String args[]){
        Util util = new Util();
        Connection connection = util.getConnection();

        BookService bookService = new BookService(connection);
        ThemeService themeService = new ThemeService(connection);

        //Book book = new Book(new Author("Sergey", "Sergey"), "Ruby");
        //bookService.add(new Book(new Author("Sergey", "Sergey"), "Ruby"));
        //bookService.update(new Book(4, new Author("Sergey", "Shulga"), "PHP"));
        //bookService.remove(3);

        /*List<Book> listBooks = bookService.getAll();

        for (Book book: listBooks){
            System.out.println(book.getId() + " " +
                    book.getAuthor().getFirstname() + " " +
                    book.getAuthor().getLastname() + " " +
                    book.getTitle()
            );
        }*/

       // themeService.add(new Theme("theme1", "theme1", 1));

       /* Theme th  = new Theme();
        th.setId(3);
        th.setTitle("theme3");
        th.setContent("theme3");
        themeService.update(th);*/
        //themeService.remove(2);

        List<Theme> listThemes = themeService.getAll(1);

        for (Theme theme: listThemes){
            System.out.println(theme.getId() + " " +
                    theme.getTitle() + " " +
                    theme.getContent() + " " +
                    theme.getIdBook()
            );
        }

    }
}
