package aron.sinoai.servletshelloworld;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    public static final String REMEMBERED_NAME = "RememberedName";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final PrintWriter writer = response.getWriter();

        final String name = request.getParameter("name");

        final HttpSession session = request.getSession();

        if (name != null && !name.isEmpty()) {
            writer.format("Hello %s!", name);

            session.setAttribute(REMEMBERED_NAME, name);
        }
        else {

            final Object rememberedName = session.getAttribute(REMEMBERED_NAME);
            writer.format("Hello again %s!", rememberedName);

        }
    }
}
