package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");
        String tecnologias[] = req.getParameterValues("tecnologia");
        String genero = req.getParameter("genero");
        String ocupacion = req.getParameter("ocupacion");
        String musica[] = req.getParameterValues("musica");
        String comentarios = req.getParameter("comentarios");

        String tecs = "";

        for(String tec: tecnologias){
            tecs += tec + " / ";
        }

        String songs = "";
        if (musica != null){
            for(String song: musica){
                songs += song + " / ";
            }
        }else {
            songs = "Valor no proporcionado";
        }


        out.println("<html>"
        + "<head><title>Resultado Servlet</title></head>" +
                "<body>" +
                "<h1>Parametros procesados por el Servlet</h1>" +
                "<table border='1'>" +


                "<tr>" +
                "<td>" +
                "Usuario" +
                "</td>" +
                "<td>" +
                usuario +
                "</td>" +
                "</tr>" +

                "<tr>" +
                "<td>" +
                "Contraseña" +
                "</td>" +
                "<td>" +
                password +
                "</td>" +
                "</tr>" +

                "<tr>" +
                "<td>" +
                "Tecnologías" +
                "</td>" +
                "<td>" +
                tecs +
                "</td>" +
                "</tr>" +

                "<tr>" +
                "<td>" +
                "Género" +
                "</td>" +
                "<td>" +
                genero +
                "</td>" +
                "</tr>" +

                "<tr>" +
                "<td>" +
                "Ocupación" +
                "</td>" +
                "<td>" +
                ocupacion +
                "</td>" +
                "</tr>" +

                "<tr>" +
                "<td>" +
                "Música favorita" +
                "</td>" +
                "<td>" +
                songs +
                "</td>" +
                "</tr>" +

                "<tr>" +
                "<td>" +
                "Comentarios" +
                "</td>" +
                "<td>" +
                comentarios+
                "</td>" +
                "</tr>" +

                "</table>" +
                "<body>" +
                "</html>");

    }
}
