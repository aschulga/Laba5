package controller.theme;

import bl.Util;
import controller.Command;
import service.ThemeService;

import javax.servlet.http.HttpServletRequest;

public class DeleteThemeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Util util = new Util();
        ThemeService themeService = new ThemeService(util.getConnection());

        String themeId = request.getParameter("id_theme");
        themeService.remove(Integer.parseInt(themeId));

        return "/jsp/theme/pageThemes.jsp";
    }
}
