package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String metodoHTTP = request.getMethod();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Headers</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Headers</h1>");
        out.println("<br>");
        out.println("Metodo HTTP: " + metodoHTTP);

        String uri = request.getRequestURI();
        out.println("<br>");
        out.println("URI solicitada: " + uri);

        //Imprimir cabeceros disponibles
        Enumeration cabeceros = request.getHeaderNames();
        String nombreCabecero;
        out.println("<br>");
        out.println("<br>");
        while (cabeceros.hasMoreElements()) {
            nombreCabecero = (String) cabeceros.nextElement();
            out.println("<b>" + nombreCabecero + "</b>:");
            out.println(request.getHeader(nombreCabecero));
            out.println("<br>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();//Se cierra al ejecutarse el método doGet (No es necesario agregarlo)

    }
}
