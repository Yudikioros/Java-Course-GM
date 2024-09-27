package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SesionesServlet")
public class SesionesServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();
        String titulo = null;

        //Pedir el atributo contador visitas a la sesión
        Integer contadorVisitas = (Integer) session.getAttribute("contadorVisitas");

        //Verificar si es nulo
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido al sistema por primera vez";
        }else {
            contadorVisitas++;
            titulo = "Bienvenido al sistema nuevamente";
        }

        //Agregamos el nuevo valor a la sesión
        session.setAttribute("contadorVisitas", contadorVisitas);

        //Respondemos al cliente
        PrintWriter out = resp.getWriter();
        out.println(titulo);
        out.println("<br>");
        out.println("Accesos al sistema: " + contadorVisitas);
        out.println("<br>");
        out.println("ID de la sesion " + session.getId());
        out.close();

    }
}
