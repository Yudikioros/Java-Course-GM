package mx.com.gm.sga.web;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.service.PersonaService;

import java.io.IOException;
import java.util.List;

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {
    @Inject
    PersonaService personaService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Persona> personas = personaService.getPersonas();
        System.out.println("Variable de personas lista");
        req.setAttribute("personas", personas);
        req.getRequestDispatcher("/listadoPersonas.jsp").forward(req, resp);
    }
}
