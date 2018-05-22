package controller.book;

import bl.Util;
import controller.Command;
import entity.Author;
import entity.Book;
import entity.Theme;
import service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowTableOfBookCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Util util = new Util();
        BookService bookService = new BookService(util.getConnection());

        List<Book> listBooks = bookService.getAll();
        request.setAttribute("list", listBooks);
        request.setAttribute("author", new Author("qwgyr", "ewqtqwet"));
        return "/jsp/book/pageBooks.jsp";
    }
}
