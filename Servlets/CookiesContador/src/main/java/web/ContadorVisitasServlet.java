package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Declaramos la variable contador
        int contadorVisitas = 0;

        //Revisar arreglo de cookies
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (var cookie : cookies) {
                if (cookie.getName().equals("contadorVisitas")) {
                    contadorVisitas = Integer.parseInt(cookie.getValue());
                }
            }
        }
        //Incrementar el contador
        contadorVisitas++;

        //Agregar la cookie nuevamente
        Cookie cookie = new Cookie("contadorVisitas", String.valueOf(contadorVisitas));
        //La cookie se almacenará por una hora (3600s)
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);

        //Mandar mensaje al navegador
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("Contador de visitas: " + contadorVisitas);
    }
}
