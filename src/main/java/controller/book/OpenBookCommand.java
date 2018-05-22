package controller.book;

import controller.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

public class OpenBookCommand implements Command {
    private String idBook;
    private static Map mapIdBook = new HashMap();

    @Override
    public String execute(HttpServletRequest request) {
        idBook = request.getParameter("id_book");

        mapIdBook.put(request.getSession(), Integer.parseInt(idBook));

        return "/jsp/theme/pageThemes.jsp";
    }

    public static int getIdBook(HttpSession session){
        return (int) mapIdBook.get(session);
    }
}
