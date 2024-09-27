package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Suponemos que el usuario visita por primera vez nuestro sitio
        boolean nuevoUsuario = true;

        //Obtener el arreglo de cookies
        Cookie[] cookies = req.getCookies();

        //Buscar si existe una cookie creada anteriormente
        // Cookie visitante recurrente
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("visitanteRecurrente") && cookie.getValue().equals("true")) {
                    //Si ya existe la cookie es un usuario recurrente
                    nuevoUsuario = false;
                    break;
                }
            }
        }

        //Verificar bandera
        String message = null;
        if(nuevoUsuario) {
            Cookie cookie = new Cookie("visitanteRecurrente", "true");
            resp.addCookie(cookie);
            message = "Gracias por visitar nuestro sitio por primera vez";
        }else {
            message = "Gracias por visitar nuestro sitio nuevamente";
        }

        //Imprimiendo mensaje
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("Mensaje: " + message);
        out.close();
    }
}
