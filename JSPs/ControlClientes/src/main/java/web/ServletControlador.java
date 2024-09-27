package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "editar":
                    this.editarCliente(req, resp);
                    break;
                    case "eliminar":
                        this.eliminarCliente(req, resp);
                        break;
                default:
                    this.accionDefault(req, resp);
            }
        }else {
            this.accionDefault(req, resp);
        }
    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("Lista de clientes: " + clientes);
        HttpSession session = req.getSession();
        session.setAttribute("clientes", clientes);
        session.setAttribute("totalClientes", clientes.size());
        session.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        //El URL no cambia
//        req.getRequestDispatcher("clientes.jsp").forward(req, resp);
        //Si notifica al navegador
        resp.sendRedirect("clientes.jsp");
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }

    private void editarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Recuperamos el idCliente
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        Cliente cliente = new ClienteDaoJDBC().encontrarCliente(new Cliente(idCliente));
        req.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertarCliente(req, resp);
                    break;
                case "modificar":
                    this.modificarCliente(req, resp);
                    break;
                default:
                    this.accionDefault(req, resp);
            }
        }else {
            this.accionDefault(req, resp);
        }
    }
    private void insertarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //Recuperamos valores del formulario
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        if(saldoString != null && !saldoString.equals("")){
            saldo = Double.parseDouble(saldoString);
        }
//        Creamos objeto de cliente (modelo)
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
//        Insertamos el nuevo objeto en la BD
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
//        Redirigimos hacia la acción default
        this.accionDefault(req, resp);
    }

    private void modificarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //Recuperamos valores del formulario
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        if(saldoString != null && !saldoString.equals("")){
            saldo = Double.parseDouble(saldoString);
        }
//        Creamos objeto de cliente (modelo)
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
//        Modificar el nuevo objeto en la BD
        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
//        Redirigimos hacia la acción default
        this.accionDefault(req, resp);
    }

    private void eliminarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //Recuperamos valores del formulario
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
//        Creamos objeto de cliente (modelo)
        Cliente cliente = new Cliente(idCliente);
//        Eliminar el nuevo objeto en la BD
        int registrosModificados = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
//        Redirigimos hacia la acción default
        this.accionDefault(req, resp);
    }

}
