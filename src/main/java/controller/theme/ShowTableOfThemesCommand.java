package controller.theme;

import bl.Util;
import controller.Command;
import controller.book.OpenBookCommand;
import entity.Theme;
import service.ThemeService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowTableOfThemesCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Util util = new Util();
        ThemeService themeService = new ThemeService(util.getConnection());

        List<Theme> listThemes = themeService.getAll(OpenBookCommand.getIdBook(request.getSession()));
        request.setAttribute("list", listThemes);
        return "/jsp/theme/pageThemes.jsp";
    }
}
