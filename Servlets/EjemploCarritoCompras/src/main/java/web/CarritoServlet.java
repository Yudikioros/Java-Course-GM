package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");


        //Recuperamos la sesión
        HttpSession session = req.getSession();

        //Recuperamos la lista de articulos existentes
        List<String> articulos = (List<String>) session.getAttribute("articulos");

        //Verificamos si existe la lista de articulos
        if (articulos == null) {
            //Inicializando la lista
            articulos = new ArrayList<>();
            session.setAttribute("articulos", articulos); //Al manejar referencias, modificar la lista actualiza la sesión también
        }

        //Procesar nuevo artículo
        String articuloNuevo = req.getParameter("articulo");
        if (articuloNuevo != null && !articuloNuevo.trim().isEmpty()) {
            articulos.add(articuloNuevo);
        }

        //Imprimir lista de articulos
        PrintWriter out = resp.getWriter();
        out.println("<h1>Lista de artículos</h1>");
        out.println("<br>");
        //Iteramos la lista
        for (String articulo : articulos) {
            out.println("<li>" + articulo + "</li>");
        }
        //Agregamos un link para regresar al inicio
        out.println("<br>");
        out.println("<a href=\"/EjemploCarritoCompras\">Salir</a>");
        out.close();
    }
}
