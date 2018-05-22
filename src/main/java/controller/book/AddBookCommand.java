package controller.book;

import bl.Util;
import controller.Command;
import entity.Author;
import entity.Book;
import service.BookService;

import javax.servlet.http.HttpServletRequest;

public class AddBookCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        Util util = new Util();
        BookService bookService = new BookService(util.getConnection());

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String title = request.getParameter("title");

        Book book = new Book();
        book.setAuthor(new Author(firstname, lastname));
        book.setTitle(title);

        bookService.add(book);

        return "/jsp/book/pageBooks.jsp";
    }
}
