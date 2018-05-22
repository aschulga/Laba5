package controller.book;

import bl.Util;
import controller.Command;
import service.BookService;

import javax.servlet.http.HttpServletRequest;

public class DeleteBookCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        Util util = new Util();
        BookService bookService = new BookService(util.getConnection());

        String idBook = request.getParameter("id_book");
        bookService.remove(Integer.parseInt(idBook));

        return "/jsp/book/pageBooks.jsp";
    }
}
