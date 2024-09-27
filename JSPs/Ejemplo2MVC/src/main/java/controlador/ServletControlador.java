package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
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
        String accion = req.getParameter("accion");

        //2. Crear JavaBeans
        Rectangulo recRequest = new Rectangulo(1, 2);
        Rectangulo recSession = new Rectangulo(3, 4);
        Rectangulo recApplication = new Rectangulo(5, 6);

        //3. Agregamos el JB a algun Scope
        //Revisamos la accion proporcionada
        if("agregarVariables".equals(accion)){
            //Request Scope
            req.setAttribute("recRequest", recRequest);
            //Session scope
            HttpSession session = req.getSession();
            session.setAttribute("recSession", recSession);
            //Aplication Scope
            ServletContext application = req.getServletContext();
            application.setAttribute("recApplication", recApplication);
            //Agregamos mensaje
            req.setAttribute("mensaje","Variables agregadas correctamente");

            //4. Redireccionar a la vista de inicio
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else if ("listarVariables".equals(accion)) {
            //4. Redireccionar a la vista seleccionada
            req.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(req, resp);
        }else {
            //4. Redireccionar a la vista de inicio
            req.setAttribute("mensaje", "Sin acción conocida");
            req.getRequestDispatcher("index.jsp").forward(req, resp);

//            No es posible compartir información, ya que no propaga request ni response
//            resp.sendRedirect("index.jsp");
        }


    }
}
