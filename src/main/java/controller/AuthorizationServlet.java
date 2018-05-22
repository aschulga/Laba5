package controller;

import controller.site.HandlerGitHub;
import controller.site.HandlerVK;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {
    private HandlerVK handlerVK = new HandlerVK();
    private HandlerGitHub handlerGitHub = new HandlerGitHub();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        common(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        common(request, response);
    }

    public void common(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        if ("logout".equals(command)) {
            request.getSession().invalidate();
            response.sendRedirect("http://localhost:8080/jsp/home.jsp");
        } else {
            String code = request.getParameter("code");
            String name = null;
            String token = null;

            if (code == null) {
                request.getSession().removeAttribute("userName");
                if ("site_vk".equals(command)) {
                    request.getSession().setAttribute("site", "vk");
                    handlerVK.authorize(response);
                }
                if ("site_github".equals(command)) {
                    request.getSession().setAttribute("site", "github");
                    handlerGitHub.authorize(response);
                }
            } else {
                if ("vk".equals(request.getSession().getAttribute("site"))) {
                    token = handlerVK.getAccessToken(code);
                    if (token != null) {
                        name = handlerVK.getUser(token);
                    }
                } else if ("github".equals(request.getSession().getAttribute("site"))) {
                    token = handlerGitHub.getAccessToken(code);
                    if (token != null) {
                        name = handlerGitHub.getUser(token);
                    }
                }

                request.getSession().setAttribute("userName", name);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/book/pageBooks.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}