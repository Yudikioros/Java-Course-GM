package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Rectangulo;

import java.io.IOException;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. Procesamos parametros

        //2. Crear JavaBeans
        Rectangulo rec = new Rectangulo(3, 6);

        //3. Agregamos el JB a algun Scope
        //Request Scope
        req.setAttribute("mensaje", "Saludos desde el Servlet");
        HttpSession session = req.getSession();
        //Session Scope
        session.setAttribute("rectangulo", rec);

        //4. Redireccionar a la vista seleccionada
        RequestDispatcher rd = req.getRequestDispatcher("vista/desplegarVariables.jsp");
        rd.forward(req, resp);
    }
}
