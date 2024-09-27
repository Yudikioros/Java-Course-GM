package mx.com.gm.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;
import mx.com.gm.servicio.ServicioAlumno;

import java.io.IOException;

@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idAlumnoS = req.getParameter("idAlumno");
        Integer idAlumno = Integer.parseInt(idAlumnoS);

        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);

        ServicioAlumno servicioAlumno = new ServicioAlumno();
        alumno = servicioAlumno.encontrarAlumno(alumno);

//        req.setAttribute("alumno", alumno);
        HttpSession session = req.getSession();
        session.setAttribute("alumno", alumno);

        req.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        String btn = req.getParameter("modificar");

        if (btn != null) {
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            String calle = req.getParameter("calle");
            String noCalle = req.getParameter("noCalle");
            String pais = req.getParameter("pais");
            String email = req.getParameter("email");
            String telefono = req.getParameter("telefono");

            HttpSession session = req.getSession();
            Alumno alumno = (Alumno) session.getAttribute("alumno");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNoCalle(noCalle);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            servicioAlumno.guardarAlumno(alumno);

            session.removeAttribute("alumno");

        } else {
            //Caso eliminar
            String idAlumnoS = req.getParameter("idAlumno");
            Integer idAlumno = Integer.parseInt(idAlumnoS);
            Alumno alumno = new Alumno(idAlumno);
            servicioAlumno.eliminarAlumno(alumno);

        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);


    }
}
