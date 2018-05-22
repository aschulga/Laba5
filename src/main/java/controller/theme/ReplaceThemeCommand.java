package controller.theme;

import bl.Util;
import controller.Command;
import entity.Theme;
import service.ThemeService;

import javax.servlet.http.HttpServletRequest;

public class ReplaceThemeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Util util = new Util();
        ThemeService themeService = new ThemeService(util.getConnection());

        String themeId = request.getParameter("theme_id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Theme theme = new Theme();
        theme.setId(Integer.parseInt(themeId));
        theme.setTitle(title);
        theme.setContent(content);

        themeService.update(theme);

        return "/jsp/theme/pageThemes.jsp";
    }
}
