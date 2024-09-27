package mx.com.gm.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.gm.domain.Alumno;
import mx.com.gm.servicio.ServicioAlumno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        List<Alumno> alumnos = servicioAlumno.listarAlumnos();

        req.setAttribute("alumnos", alumnos);

        req.getRequestDispatcher("/WEB-INF/listarAlumnos.jsp").forward(req, resp);

    }
}
