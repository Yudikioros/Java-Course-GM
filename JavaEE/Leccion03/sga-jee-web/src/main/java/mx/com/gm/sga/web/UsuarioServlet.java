package mx.com.gm.sga.web;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.service.UsuarioService;

import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
    @Inject
    UsuarioService usuarioService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        System.out.println("Variable de usuarios lista");
        req.setAttribute("usuarios", usuarios);
        req.getRequestDispatcher("/listadoUsuarios.jsp").forward(req, resp);
    }

}
