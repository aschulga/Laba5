package controller.theme;

import bl.Util;
import controller.Command;
import controller.book.OpenBookCommand;
import entity.Theme;
import service.ThemeService;

import javax.servlet.http.HttpServletRequest;

public class AddThemeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Util util = new Util();
        ThemeService themeService = new ThemeService(util.getConnection());

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Theme theme = new Theme();
        theme.setTitle(title);
        theme.setContent(content);
        theme.setIdBook(OpenBookCommand.getIdBook(request.getSession()));

        themeService.add(theme);

        return "/jsp/theme/pageThemes.jsp";
    }
}
