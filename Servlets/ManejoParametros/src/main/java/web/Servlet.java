package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Leer los parámetros del formulario html
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");

        System.out.println("usuario = " + usuario);
        System.out.println("password = " + password);

        PrintWriter out = resp.getWriter();
        out.format("<html> <body> " +
                "El parámetro usuario es: %s " +
                "<br> " +
                "El parámetro password es: %s" +
                "</body> </html>", usuario, password);
        out.close();
    }
}
