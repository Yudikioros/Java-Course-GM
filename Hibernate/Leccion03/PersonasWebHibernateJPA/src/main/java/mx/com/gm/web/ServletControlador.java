package mx.com.gm.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.ServicioPersonas;

import java.io.IOException;
import java.util.List;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        ServicioPersonas servicio = new ServicioPersonas();
        List<Persona> personas = servicio.listarPersonas();
        req.setAttribute("personas", personas);
        try {
            req.getRequestDispatcher("/WEB-INF/listado.jsp").forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
