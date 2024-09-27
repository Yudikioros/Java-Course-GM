package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/HoraServlet")
public class HoraServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("refresh", "1");
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("'Hora actualizada:' HH:mm:ss");
        String hora = formato.format(fecha);
        PrintWriter out = resp.getWriter();
        out.println(hora);
        out.close();
    }
}
