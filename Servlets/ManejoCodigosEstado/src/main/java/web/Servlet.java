package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       //Simular valores correctos
       String usuarioOK = "Juan";
       String passwordOK = "123";

       String usuario = req.getParameter("usuario");
       String password = req.getParameter("password");

       PrintWriter out = resp.getWriter();

       if (usuario.equals(usuarioOK) && password.equals(passwordOK)) {
           out.println("<h1>");
           out.println("Datos correctos");
           out.println("<br>Usuario: " + usuario);
           out.println("<br>Password: " + password);
           out.println("</h1>");
       }else {
           //SC = Status Code
           resp.sendError(resp.SC_UNAUTHORIZED, "Credenciales incorrectas");
       }

       out.close();

    }
}
